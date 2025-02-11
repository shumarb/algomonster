import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class SubarraySumFixed {
    public static int subarraySumFixed(List<Integer> nums, int k) {
        int largestSum = 0;
        for (int i = 0; i < k; i++) {
            largestSum += nums.get(i);
        }
        int currentSum = largestSum;
        for (int i = k; i < nums.size(); i++) {
            currentSum = currentSum + nums.get(i) - nums.get(i - k);
            largestSum = Math.max(largestSum, currentSum);
        }
        return largestSum;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = subarraySumFixed(nums, k);
        System.out.println(res);
    }
}
