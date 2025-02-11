// Question: FirstTrueInASortedArray

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FirstTrueInASortedArray {
    public static int findBoundary(List<Boolean> arr) {
        int first = 0;
        int l = 0;
        int h = arr.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr.get(m)) {
                first = m;
                h = m;
            } else {
                l = m + 1;
            }
        }
        return first;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Boolean> arr = splitWords(scanner.nextLine()).stream().map(v -> v.equals("true")).collect(Collectors.toList());
        scanner.close();
        int res = findBoundary(arr);
        System.out.println(res);
    }
}
