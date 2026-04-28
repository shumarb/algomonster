// Question: https://algo.monster/problems/task_scheduling_2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

class TaskSchedulingTwo {
    public static int taskScheduling2(List<String> tasks, List<Integer> times, List<List<String>> requirements) {
        List<String> topologicalOrder = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> finish = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, Integer> taskTimeMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        boolean isTest = false;
        int n = tasks.size();
        int result = 0;

        for (int i = 0; i < n; i++) {
            graph.put(tasks.get(i), new ArrayList<>());
            inDegree.put(tasks.get(i), 0);
            taskTimeMap.put(tasks.get(i), times.get(i));
        }
        for (List<String> edge: requirements) {
            String destination = edge.get(1);
            String source = edge.get(0);
            graph.get(source).add(destination);
            inDegree.put(destination, 1 + inDegree.getOrDefault(destination, 0));
        }
        if (isTest) {
            System.out.println("taskTimeMap: " + taskTimeMap + "\n--------------------------------------------------------------------------------\ngraph:");
            for (String key: graph.keySet()) {
                System.out.println(" * " + key + " -> " + graph.get(key));
            }
        }

        for (String key: inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
                finish.put(key, taskTimeMap.get(key));
            } else {
                finish.put(key, 0);
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("inDegree: " + inDegree + "\nbefore, finish: " + finish);
        }
        while (!queue.isEmpty()) {
            String source = queue.poll();

            result = Math.max(finish.get(source), result);

            // 1. destination: neighbours of source.
            // set finish time of destination as largest value of:
            // - first: finish time of destination
            // - second: finish time of source + time taken to complete destination.
            // once a destination is completed, add it to queue if its in-degree == 0.
            for (String destination: graph.get(source)) {
                int first = finish.get(destination);
                int second = finish.get(source) + taskTimeMap.get(destination);
                finish.put(destination, Math.max(first, second));

                inDegree.put(destination, inDegree.get(destination) - 1);
                if (inDegree.get(destination) == 0) {
                    queue.offer(destination);
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------------\ntopologicalOrder: " + topologicalOrder);
            System.out.println("\nafter, finish: " + finish + "\nresult: " + result);
        }

        return result;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = splitWords(scanner.nextLine());
        List<Integer> times = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int requirementsLength = Integer.parseInt(scanner.nextLine());
        List<List<String>> requirements = new ArrayList<>();
        for (int i = 0; i < requirementsLength; i++) {
            requirements.add(splitWords(scanner.nextLine()));
        }
        scanner.close();
        int res = taskScheduling2(tasks, times, requirements);
        System.out.println(res);
    }
}
