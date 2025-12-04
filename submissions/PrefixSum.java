// Question:

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class PrefixSum {
    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;

        map.put(0, -1);
        for (int i = 0; i < arr.size(); i++) {
            prefixSum += arr.get(i);
            int complement = prefixSum - target;

            if (map.containsKey(complement)) {
                result.add(1 + map.get(complement));
                result.add((i + 1));
                return result;
            }

            map.put(prefixSum, i);
        }

        return null;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = subarraySum(arr, target);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
