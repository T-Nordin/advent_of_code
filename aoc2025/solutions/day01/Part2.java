package aoc2025.solutions.day01;

import java.util.*;

import aoc2025.tools.*;

public class Part2 {
    public static void main(String[] args) {
        List<String> input = InputReader.readLines("aoc2025/inputs/day01/inputPart1.txt");

        System.out.println(solve(input));
    }

    private static int recursionCount = 0;

    private static int solve(List<String> input) {
        int result = 0;
        int position = 50;

        for (String string : input) {
            char direction = string.charAt(0);
            int distance = Integer.parseInt(string.substring(1));
            boolean isStartingPositionZero = (position == 0);
            switch (direction) {
                case 'R' -> position = finalizePosition(position += distance, isStartingPositionZero);
                case 'L' -> position = finalizePosition(position -= distance, isStartingPositionZero);
                default -> throw new IllegalArgumentException("Invalid direction: " + direction);
            }
            if (position == 0) {
                result++;
            }
        }

        return result + recursionCount;

    }

    private static void countLaps(int position, int distance){
        if (position == 0) {
            return;
        }

    }

    private static int finalizePosition(int position, boolean isStartingPositionZero) {
        if (position < 0) {
            if(!isStartingPositionZero) {
                recursionCount++;
            }
            return finalizePosition(position + 100, false);
        } else if (position > 99) {
            if(position != 100) {
                recursionCount++;
            }
            return finalizePosition(position - 100, false);
        } else {
            return position;
        }
    }

}
