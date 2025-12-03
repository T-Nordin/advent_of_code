package aoc2025.solutions.day03;

import java.util.*;

import aoc2025.tools.*;

public class Part1 {
    public static void main(String[] args) {
        List<String> input = InputReader.readLines("aoc2025/inputs/day03/inputPart1.txt");

        System.out.println(solve(input));
    }

    private static int solve(List<String> input) {
        int result = 0;


        for (String line : input) {
            char[] chars = line.toCharArray();
            char highestChar = getHighestChar(chars);
            int indexOfHighestChar = line.indexOf(highestChar);
            char secondChar = getSecondNumber(chars, indexOfHighestChar);
            String combinedChars = "" + highestChar + secondChar;
            result += Integer.parseInt(combinedChars);
        }

        return result;
    }

    private static char getHighestChar(char[] chars) {

        int highestNumber = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > highestNumber) {
                highestNumber = chars[i];
            }
        }
        return (char) highestNumber;
    }
    private static char getSecondNumber(char[] chars, int indexOfHighestChar) {

        int secondNumber = 0;
        for (int i = indexOfHighestChar + 1; i < chars.length; i++) {
            if (chars[i] > secondNumber) {
                secondNumber = chars[i];
            }
        }
        return (char) secondNumber;
    }
}
