// Question: https://algo.monster/problems/binary_search_first_element_not_smaller_than_target

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FirstElementNotSmallerThanTarget {
    public static int firstNotSmaller(List<Integer> arr, int target) {
        // a [1 3 3 5 8 8 10], target = 2
        int low = 0;
        int high = arr.size() - 1;
        int boundaryIndex = -1;

        while (low <= high) {
            int middle = (high + low) / 2;

            // 1. Current element >= target,
            // so current to last elements are each >= target,
            // so discard all elements from this element to end of ArrayList
            // and and set boundaryIndex as this element's index
            // as this may be first element >= target in ArrayList.
            if (arr.get(middle) >= target) {
                boundaryIndex = middle;
                high = middle - 1;

            } else {
                // 2. Current element < target,
                // so first to current element are each < target
                // hence discard all these elements.
                low = middle + 1;
            }
        }

        return boundaryIndex;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = firstNotSmaller(arr, target);
        System.out.println(res);
    }
}
