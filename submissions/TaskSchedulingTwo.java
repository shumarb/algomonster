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
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> finish = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, Integer> taskDuration = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        boolean isTest = false;
        int result = 0;

        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            taskDuration.put(task, times.get(i));
            graph.put(task, new ArrayList<>());
            inDegree.put(task, 0);
        }
        for (List<String> requirement: requirements) {
            String destination = requirement.get(1);
            String source = requirement.get(0);

            graph.get(source).add(destination);
            inDegree.put(destination, 1 + inDegree.get(destination));
        }
        for (String key: inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
                finish.put(key, taskDuration.get(key));
            } else {
                finish.put(key, 0);
            }
        }
        if (isTest) {
            System.out.println("graph:");
            for (String key: graph.keySet()) {
                System.out.println(" * " + key + ": " + graph.get(key));
            }
            System.out.println("\ninDegree: " + inDegree + "\nfinish: " + finish);
            System.out.println("----------------------------------------------");
        }

        while (!queue.isEmpty()) {
            String source = queue.poll();

            // 1. Determine longest time to finish a task so far.
            result = Math.max(result, finish.get(source));

            // 2. Determine longest time to finish destination.
            // - first: finish time of destination so far
            // - second: finish time of source + time taken to complete destination
            for (String destination: graph.get(source)) {
                int first = finish.get(destination);
                int second = finish.get(source) + taskDuration.get(destination);
                finish.put(destination, Math.max(first, second));

                inDegree.put(destination, inDegree.get(destination) - 1);
                if (inDegree.get(destination) == 0) {
                    queue.offer(destination);
                }
            }
        }
        if (isTest) {
            System.out.println("finish: " + finish + "\ninDegree: " + inDegree + "\nresult: " + result);
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
