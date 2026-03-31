// Question: https://algo.monster/problems/task_scheduling

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class TaskScheduling {
    public static List<String> taskScheduling(List<String> tasks, List<List<String>> requirements) {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        boolean isTest = false;

        for (String task: tasks) {
            graph.put(task, new ArrayList<>());
            inDegree.put(task, 0);
        }
        for (List<String> edge: requirements) {
            String destination = edge.get(1);
            String source = edge.get(0);

            graph.get(source).add(destination);
            inDegree.put(destination, 1 + inDegree.getOrDefault(destination, 0));
        }
        if (isTest) {
            System.out.println("inDegree: " + inDegree);
            System.out.println("-----------------------------------------\ngraph:");
            for (String vertex: graph.keySet()) {
                System.out.println(" * " + vertex + ": " + graph.get(vertex));
            }
        }

        for (String vertex: inDegree.keySet()) {
            if (inDegree.get(vertex) == 0) {
                queue.offer(vertex);
            }
        }
        while (!queue.isEmpty()) {
            String source = queue.poll();
            result.add(source);

            List<String> destinations = graph.get(source);
            for (String destination: destinations) {
                inDegree.put(destination, inDegree.getOrDefault(destination, 0) - 1);
                if (inDegree.get(destination) == 0) {
                    queue.offer(destination);
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------\nresult: " + result);
        }

        return result;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = splitWords(scanner.nextLine());
        int requirementsLength = Integer.parseInt(scanner.nextLine());
        List<List<String>> requirements = new ArrayList<>();
        for (int i = 0; i < requirementsLength; i++) {
            requirements.add(splitWords(scanner.nextLine()));
        }
        scanner.close();
        List<String> res = taskScheduling(tasks, requirements);
        if (res.size() != tasks.size()) {
            System.out.println("output size " + res.size() + " does not match input size " + tasks.size());
            return;
        }
        HashMap<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < res.size(); i++) {
            indices.put(res.get(i), i);
        }
        for (List<String> req : requirements) {
            for (String task : req) {
                if (!indices.containsKey(task)) {
                    System.out.println("'" + task + "' is not in output");
                    return;
                }
            }
            String a = req.get(0);
            String b = req.get(1);
            if (indices.get(a) >= indices.get(b)) {
                System.out.println("'" + a + "' is not before '" + b + "'");
                return;
            }
        }
        System.out.println("ok");
    }
}
