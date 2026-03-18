// Question: https://algo.monster/problems/prefix_count

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class PrefixCount {
    public static List<Integer> prefixCount(List<String> words, List<String> prefixes) {
        List<Integer> result = new ArrayList<>();

        for (String prefix: prefixes) {
            int count = 0;
            for (String word: words) {
                if (word.startsWith(prefix)) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = splitWords(scanner.nextLine());
        List<String> prefixes = splitWords(scanner.nextLine());
        scanner.close();
        List<Integer> res = prefixCount(words, prefixes);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
