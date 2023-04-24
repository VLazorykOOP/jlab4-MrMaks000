import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WordMatcher {
    public static void matchWords(String file1, String file2, String outputFile) throws IOException {
        // читаємо тексти з файлів
        String text1 = readFile(file1);
        String text2 = readFile(file2);

        // приводимо тексти до верхнього регістру та розбиваємо на слова
        Set<String> words1 = extractWords(text1.toUpperCase());
        Set<String> words2 = extractWords(text2.toUpperCase());

        // знаходимо слова, які зустрічаються в обох файлах
        Set<String> commonWords = new HashSet<>(words1);
        commonWords.retainAll(words2);

        // записуємо у вихідний файл слова, які зустрічаються окремо в першому та другому файлі
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            for (String word : words1) {
                if (!words2.contains(word)) {
                    writer.println(word);
                }
            }
            for (String word : words2) {
                if (!words1.contains(word)) {
                    writer.println(word);
                }
            }
        }

        // виводимо на консоль слова, які зустрічаються в обох файлах
        System.out.println("Words in common:");
        for (String word : commonWords) {
            System.out.println(word);
        }
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    private static Set<String> extractWords(String text) {
        Set<String> words = new HashSet<>();
        StringTokenizer tokenizer = new StringTokenizer(text, " .,:;");
        while (tokenizer.hasMoreTokens()) {
            words.add(tokenizer.nextToken());
        }
        return words;
    }
}
