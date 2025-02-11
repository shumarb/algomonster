// Question: https://algo.monster/problems/heap_intro

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

class HeapFundamentals {
    public static List<Integer> heapTop3(List<Integer> arr) {
        List<Integer> ans = new ArrayList<> ();
        PriorityQueue<Integer> minHeap = new PriorityQueue<> ();
        for (int x: arr) {
            minHeap.offer(x);
        }
        for (int i = 0; i < 3; i++) {
            ans.add(minHeap.poll());
        }
        return ans;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = heapTop3(arr);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
