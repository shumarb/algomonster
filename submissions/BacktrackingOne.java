// Question: https://algo.monster/problems/backtracking

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BacktrackingOne {
    private static List<String> result = new ArrayList<>();

    public static List<String> letterCombination(int n) {
        helper(new StringBuilder(), n, 'a', 'b');
        return result;
    }

    private static void helper(StringBuilder current, int n, char first, char second) {
        if (current.length() > n) {
            return;
        }

        if (current.length() == n) {
            result.add(current.toString());
        }

        int oriLen = current.length();

        current.append(first);
        helper(current, n, first, second);
        current.setLength(oriLen);

        current.append(second);
        helper(current, n, first, second);
        current.setLength(oriLen);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<String> res = letterCombination(n);
        res.stream().sorted().forEach(System.out::println);
    }
}

