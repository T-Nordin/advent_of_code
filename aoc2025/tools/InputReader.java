package aoc2025.tools;

import java.nio.file.*;
import java.util.*;

public class InputReader {

    /** Read file as a list of lines */
    public static List<String> readLines(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
    }

    /** Read entire file as one string */
    public static String readString(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + path, e);
        }
    }

    /** Read file and split on commas */
    public static List<String> readCSV(String path) {
        return Arrays.asList(readString(path).split(","));
    }

    /** Read file into a list of integers */
    public static List<Integer> readInts(String path) {
        return readLines(path).stream()
            .map(Integer::parseInt)
            .toList();
    }
}