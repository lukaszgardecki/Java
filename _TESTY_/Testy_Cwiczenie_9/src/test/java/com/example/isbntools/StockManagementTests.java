package com.example.isbntools;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StockManagementTests {
    ExternalISBNDataService testWebService;
    ExternalISBNDataService testDatabaseService;
    StockManager stockManager;

    @BeforeEach
    public void setUp() {
        testWebService = mock(ExternalISBNDataService.class);
        testDatabaseService = mock(ExternalISBNDataService.class);
        stockManager = new StockManager();
        stockManager.setWebService(testWebService);
        stockManager.setDatabaseService(testDatabaseService);
    }

    @Test
    public void testCanGetACorrectLocatorCode() {
        // Given
        String isbn = "0140177396";

        // When
        when(testWebService.lookup(anyString())).thenReturn(new Book(isbn, "Oj Mice And Men", "J. Steinbeck"));
        when(testDatabaseService.lookup(anyString())).thenReturn(null);
        String locatorCode = stockManager.getLocatorCode(isbn);

        // Then
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        // Given
        String isbn = "0140177396";

        // When
        when(testDatabaseService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));
        String locatorCode = stockManager.getLocatorCode(isbn);

        // Then
        verify(testDatabaseService).lookup(isbn);
        verify(testWebService, never()).lookup(anyString());
    }

    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
        // Given
        String isbn = "0140177396";

        // When
        when(testDatabaseService.lookup(isbn)).thenReturn(null);
        when(testWebService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));
        String locatorCode = stockManager.getLocatorCode(isbn);

        // Then
        verify(testDatabaseService).lookup(isbn);
        verify(testWebService).lookup(isbn);
    }
}
