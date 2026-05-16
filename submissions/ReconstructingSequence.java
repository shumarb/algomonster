// Question: https://algo.monster/problems/sequence_reconstruction

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class ReconstructingSequence {
    public static boolean sequenceReconstruction(List<Integer> original, List<List<Integer>> seqs) {
        List<Integer> path = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer>[] graph;
        boolean isTest = false;
        int[] inDegree;
        int largest = 0;
        int level = 0;

        for (int e: original) {
            largest = Math.max(e, largest);
        }
        graph = new HashSet[largest + 1];
        inDegree = new int[largest + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        for (List<Integer> sequence: seqs) {
            for (int i = 1; i < sequence.size(); i++) {
                int destination = sequence.get(i);
                int source = sequence.get(i - 1);

                if (graph[source].add(destination)) {
                    inDegree[destination]++;
                }
            }
        }
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree) + "\ngraph:");
            for (int i = 1; i < graph.length; i++) {
                System.out.println(" * " + graph[i]);
            }
            System.out.println("----------------------------------");
        }

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println(" * level: " + level + ": " + queue);
            }

            int size = queue.size();
            if (size > 1) {
                return false;
            }

            while (size-- > 0) {
                int top = queue.poll();
                path.add(top);
                for (int neighbour: graph[top]) {
                    if (--inDegree[neighbour] == 0) {
                        queue.offer(neighbour);
                    }
                }
            }
            level++;
        }
        if (isTest) {
            System.out.println("----------------------------------\npath: " + path + ", original: " + original);
        }

        return original.equals(path);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> original = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int seqsLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> seqs = new ArrayList<>();
        for (int i = 0; i < seqsLength; i++) {
            seqs.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        boolean res = sequenceReconstruction(original, seqs);
        System.out.println(res);
    }
}
