package com.example.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserCreationServiceTest {

    @Test
    void shouldSetCreationDate() {
        DateTimeProvider dateTimeProvider = new DateTimeProvider();
        UserCreationService userCreationService = new UserCreationService(dateTimeProvider);

        User user = userCreationService.createUser("Admin");

        assertThat(user.getCreationDate()).isNotNull();
    }

    @Test
    void shouldSetCreationDateToCurrentDate() {
        DateTimeProvider dateTimeProviderMock = Mockito.mock(DateTimeProvider.class);
        ZonedDateTime now = ZonedDateTime.now();
        Mockito.when(dateTimeProviderMock.currentZonedDateTime()).thenReturn(now);
        UserCreationService userCreationService = new UserCreationService(dateTimeProviderMock);

        User user = userCreationService.createUser("Admin");

        assertThat(user.getCreationDate()).isNotNull();
    }
}