package aoc2025.solutions.day01;

import java.util.*;

import aoc2025.tools.*;

public class Part1 {
    public static void main(String[] args) {
        List<String> input = InputReader.readLines("aoc2025/inputs/day01/inputPart1.txt");

        System.out.println(solve(input));
    }

    private static int solve(List<String> input) {
        int result = 0;
        int position = 50;

        for (String string : input) {
            char direction = string.charAt(0);
            int distance = Integer.parseInt(string.substring(1));
            switch (direction) {
                case 'R' -> position = finalizePosition(position += distance);
                case 'L' -> position = finalizePosition(position -= distance);
                default -> throw new IllegalArgumentException("Invalid direction: " + direction);
            }
            if (position == 0) {
                result++;
            }
        }

        return result;

    }

    private static int finalizePosition(int position) {
        if(position < 0) {
            return finalizePosition(position + 100);
        } else if (position > 99) {
            return finalizePosition(position - 100);
        } else {
            return position;
        }
    }

}
