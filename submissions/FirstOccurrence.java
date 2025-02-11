// Question:

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FirstOccurrence {
    public static int findFirstOccurrence(List<Integer> arr, int target) {
        int index = -1;
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                if (arr.get(mid) == target) {
                    index = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findFirstOccurrence(arr, target);
        System.out.println(res);
    }
}
