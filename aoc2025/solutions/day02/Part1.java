package aoc2025.solutions.day02;

import java.util.*;

import aoc2025.tools.*;

public class Part1 {
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

private static boolean isItValidId(long id) {
    String idString = String.valueOf(id);

    if (idString.length() % 2 != 0) {
        return true;
    }

    int middleIndex = idString.length() / 2;
    String firstHalf = idString.substring(0, middleIndex);
    String secondHalf = idString.substring(middleIndex);

    return !firstHalf.equals(secondHalf);
}
}
