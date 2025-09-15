package collectors;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "The quick brown fox jumps over the lazy dog and the dog jumps over the fox";
        
        Map<String, Integer> wordCount = Arrays.stream(paragraph.toLowerCase().split("\\s+"))
            .collect(Collectors.groupingBy(word -> word, Collectors.summingInt(word -> 1)));

        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}