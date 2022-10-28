package com.example.Testy_Cwiczenie5.TDD_4_Tests;

import com.example.Testy_Cwiczenie5.TDD_4.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @ParameterizedTest
    @CsvSource({
            "N, E",
            "E, S",
            "S, W",
            "W, N",
    })
    public void turnsRightNorthToEast(String startsFacing, String endsFacing) {
        Rover rover = new Rover(startsFacing, 0, 0);
        rover.go("R");
        assertEquals(endsFacing, rover.getFacing());
    }

    @ParameterizedTest
    @CsvSource({
            "N, W",
            "W, S",
            "S, E",
            "E, N",
    })
    public void turnsLeftAnticlockwise(String startsFacing, String endsFacing) {
        Rover rover = new Rover(startsFacing, 0, 0);
        rover.go("L");
        assertEquals(endsFacing, rover.getFacing());
    }

    @ParameterizedTest
    @CsvSource({
            "N,5,6",
            "E,6,5",
            "S,5,4",
            "W,4,5",
    })
    public void movesForwardInDirectionFacing(String facing, int endX, int endY) {
        Rover rover = new Rover(facing, 5, 5);
        rover.forward();
        assertArrayEquals(new int[]{endX, endY}, rover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({
            "N,5,4",
            "E,4,5",
            "S,5,6",
            "W,6,5",
    })
    public void movesBackInDirectionFacing(String facing, int endX, int endY) {
        Rover rover = new Rover(facing, 5, 5);
        rover.back();
        assertArrayEquals(new int[]{endX, endY}, rover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({
            "F,N,5,6",
            "B,N,5,4",
            "R,E,5,5",
            "L,W,5,5",
    })
    public void mapsInstructionToCommand(Character instruction, String endsFacing, int endX, int endY) {
        Rover rover = new Rover("N", 5, 5);
        rover.mapToCommand(instruction).run();
        assertEquals(endsFacing, rover.getFacing());
        assertArrayEquals(new int[]{endX, endY}, rover.getPosition());
    }

    @Test
    public void executesSequenceOfInstructions() {
        Rover rover = new Rover("N", 5, 5);
        rover.go("RFF");
        assertEquals("E", rover.getFacing());
    }
}
