package com.example.Testy_Cwiczenie5.TDD_3_Tests;

import com.example.Testy_Cwiczenie5.TDD_3.CompactDisc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuyCdTest {

    @Test
    public void cdIsInStock() {
        CompactDisc cd = new CompactDisc(10);
        cd.buy(1);
        assertEquals(9, cd.getStockCount());
    }


}
