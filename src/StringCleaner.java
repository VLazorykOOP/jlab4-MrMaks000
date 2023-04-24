import java.io.*;
import java.util.*;

public class StringCleaner {
    public static void cleanAndSort(String inputFileName, String outputFileName) throws IOException {
        // читаємо рядки з файлу та вилучаємо порожні рядки
        List<String> lines = readLines(inputFileName);
        lines.removeIf(line -> line.trim().isEmpty());

        // вилучаємо символи, які не є маленькими латинськими літерами, та сортуємо рядки
        List<String> cleanedLines = new ArrayList<>();
        for (String line : lines) {
            StringBuilder sb = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (Character.isLowerCase(c) && Character.isLetter(c)) {
                    sb.append(c);
                }
            }
            cleanedLines.add(sb.toString());
        }
        Collections.sort(cleanedLines);

        // записуємо відсортовані рядки у файл
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
            for (String line : cleanedLines) {
                writer.println(line);
            }
        }
    }

    private static List<String> readLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
