// Questions: https://algo.monster/problems/newspapers_split

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Newspapers {
    public static int newspapersSplit(List<Integer> newspapersReadTimes, int numCoworkers) {
        boolean isTest = false;
        int firstTrueIndex = -1;
        int high = 0;
        int low = 0;

        for (int time: newspapersReadTimes) {
            high += time;
            low = Math.max(low, time);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isTest) {
                System.out.println("low: " + low + ", high: " + high + " -> mid: " + mid);
            }
            if (isValid(newspapersReadTimes, numCoworkers, mid)) {
                firstTrueIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (isTest) {
            System.out.println("firstTrueIndex: " + firstTrueIndex);
        }

        return firstTrueIndex;
    }

    private static boolean isValid(List<Integer> times, int k, int limit) {
        int sum = 0;
        int workers = 0;

        for (int time: times) {
            if (time + sum > limit) {
                workers++;
                sum = 0;
            }
            sum += time;
        }

        if (sum > 0) {
            workers++;
        }

        return workers <= k;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> newspapersReadTimes = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int numCoworkers = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = newspapersSplit(newspapersReadTimes, numCoworkers);
        System.out.println(res);
    }
}
