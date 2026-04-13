// Question: https://algo.monster/problems/walls_and_gates

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

class WallsAndGatesZombieInMatrix {
    public static List<List<Integer>> mapGateDistances(List<List<Integer>> dungeonMap) {
        Queue<int[]> queue = new LinkedList<>();
        boolean isTest = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int INF = Integer.MAX_VALUE;
        int m = dungeonMap.size();
        int n = dungeonMap.get(0).size();

        if (isTest) {
            print("before:", dungeonMap);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dungeonMap.get(i).get(j) == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int c = top[1];
            int r = top[0];

            for (int[] direction: directions) {
                int adjacentColumn = c + direction[1];
                int adjacentRow = r + direction[0];

                if (adjacentColumn < 0 || adjacentColumn >= n || adjacentRow < 0 || adjacentRow >= m) {
                    continue;
                }

                if (dungeonMap.get(adjacentRow).get(adjacentColumn) == INF) {
                    dungeonMap.get(adjacentRow).set(adjacentColumn, dungeonMap.get(r).get(c) + 1);
                    queue.offer(new int[] {adjacentRow, adjacentColumn});
                }
            }
        }

        if (isTest) {
            print("-----------------------\nafter:", dungeonMap);
        }

        return dungeonMap;
    }

    private static void print(String s, List<List<Integer>> grid) {
        System.out.println(s);
        for (List<Integer> row: grid) {
            System.out.println(row);
        }
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dungeonMapLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> dungeonMap = new ArrayList<>();
        for (int i = 0; i < dungeonMapLength; i++) {
            dungeonMap.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        List<List<Integer>> res = mapGateDistances(dungeonMap);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}

