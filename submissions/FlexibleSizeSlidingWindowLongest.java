// Question: https://algo.monster/problems/subarray_sum_longest

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int subarraySumLongest(List<Integer> nums, int target) {
        /**
         nums = [1, 6, 3, 1, 2, 4, 5] and target = 10
         */
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int sum = 0;

        while (right < nums.size()) {
            // 1. Add current value to sum so far
            sum += nums.get(right);

            // 2. Keep expanding subArray to the right as long as sum <= target
            // if (sum > target), reduce the window by eliminating its first element,
            // hence reducing its sum by current element of left
            // and setting left to its next element (left + 1)
            while (sum > target) {
                sum -= nums.get(left++);
            }

            // 3. Subarray of elements whose sum <= target has been formed,
            // so compare this subarray's length with the maximum length
            // or a subarray whose elements sum <= target
            // Since we are comparing difference in indices to be the length
            // of the current window (subarray), increase it by 1 due to 0-based index value
            maxLen = Math.max(maxLen, right - left + 1);

            // 4. Expand current window by 1 element
            right++;
        }

        return maxLen;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumLongest(nums, target);
        System.out.println(res);
    }
}
