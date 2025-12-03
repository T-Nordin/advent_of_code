package aoc2025.solutions.day02;

import java.util.*;

import aoc2025.tools.*;

public class Part2 {
    public static void main(String[] args) {
        List<String> input = InputReader.readCSV("aoc2025/inputs/day02/inputPart1.txt");

        System.out.println(solve(input));
    }

    private static long solve(List<String> input) {
        long result = 0;

        for (String string : input) {
            String[] parts = string.split("-");
            long first = Long.parseLong(parts[0]);
            long second = Long.parseLong(parts[1]);

            for (long i = first; i <= second; i++) {
                if (!isItValidId(i)) {
                    result += i;
                }
            }
        }
        return result;
    }

    private static boolean isRepeatedPattern(long n) {
        String s = String.valueOf(n);
        String ss = s + s;

        String middle = ss.substring(1, ss.length() - 1);

        return middle.contains(s);
    }

    private static boolean isItValidId(long id) {
        return !isRepeatedPattern(id);
    }
}
