import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class WordFrequencyCounterApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your sentence : ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");

         Arrays.asList(words)
                .parallelStream()
                .collect(Collectors.toConcurrentMap(String::toLowerCase, word -> 1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(reverseOrder()))
                .forEach(System.out::println);

        scanner.close();
    }
}
