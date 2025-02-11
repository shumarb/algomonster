// Question: https://algo.monster/problems/subarray_sum_shortest
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    /**
     nums = [1, 4, 1, 7, 3, 0, 2, 5] and target = 10
     find length of smallest subArray whose sum >= 10
     */
    public static int subarraySumShortest(List<Integer> nums, int target) {
        int left = 0;
        int length = nums.size();
        int sum = 0;

        for (int right = 0; right < nums.size(); right++) {
            sum += nums.get(right);
            while (sum >= target) {
                length = Math.min(length, right - left + 1);
                sum -= nums.get(left++);
            }
        }

        return length;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumShortest(nums, target);
        System.out.println(res);
    }
}
