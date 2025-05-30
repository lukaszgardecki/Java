package com.example.Testy_Cwiczenie5.TDD_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rover {
    private String facing;
    private int[] position = {0, 0};
    private final String[] clockwise = new String[]{"N", "E", "S", "W"};

    public Rover(String startsFacing, int x, int y) {
        this.facing = startsFacing;
        this.position[0] = x;
        this.position[1] = y;
    }

    public String getFacing() {
        return facing;
    }

    public void go(String instructions) {
        instructions.chars().forEach(c -> mapToCommand((char)c).run());
    }

    public int[] getPosition() {
        return position;
    }

    private void left() {
        turn(new String[]{"N", "W", "S", "E"});
    }

    private void right() {
        turn(new String[]{"N", "E", "S", "W"});
    }

    public void forward() {
        move(Gear.FORWARD);
    }

    public void back() {
        move(Gear.REVERSE);
    }

    private void turn(String[] compass) {
        facing = compass[(facingIndex(compass) + 1) % 4];
    }

    private int facingIndex(String[] compass) {
        return Arrays.asList(compass).indexOf(facing);
    }

    private void move(int gear) {
        int[][] vectors = {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
        int[] vector = vectors[facingIndex(clockwise)];
        position[0] = position[0] + (vector[0] * gear);
        position[1] = position[1] + (vector[1] * gear);
    }

    public Runnable mapToCommand(Character instruction) {
        Map<Character, Runnable> commands = new HashMap<>();
        commands.put('F', this::forward);
        commands.put('B', this::back);
        commands.put('R', this::right);
        commands.put('L', this::left);
        return commands.get(instruction);
    }

    private class Gear {
        public static final int FORWARD = 1;
        public static final int REVERSE = -1;
    }
}
