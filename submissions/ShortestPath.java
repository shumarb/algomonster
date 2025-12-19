// Question: https://algo.monster/problems/shortest_path_unweight

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class ShortestPath {
    public static int shortestPath(List<List<Integer>> graph, int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        boolean isTest = false;
        int level = 0;

        queue.offer(a);
        visited.add(a);

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("---------------------------\nlevel: " + level + " -> queue: " + queue);
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                if (top == b) {
                    return level;
                }
                visited.add(top);
                for (int neighbour: graph.get(top)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                    }
                }
            }
            level++;
        }

        return level;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int graphLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < graphLength; i++) {
            graph.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = shortestPath(graph, a, b);
        System.out.println(res);
    }
}
