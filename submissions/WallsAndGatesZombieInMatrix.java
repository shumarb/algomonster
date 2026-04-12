// Question: https://algo.monster/problems/walls_and_gates

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

class WallsAndGatesZombieInMatrix {
    private static boolean isTest;
    private static int key;
    private static int m;
    private static int n;

    public static List<List<Integer>> mapGateDistances(List<List<Integer>> dungeonMap) {
        List<List<Integer>> result = new ArrayList<>();
        isTest = false;
        key = Integer.MAX_VALUE;
        m = dungeonMap.size();
        n = dungeonMap.get(0).size();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int current = dungeonMap.get(i).get(j);
                if (current != key) {
                    row.add(current);
                } else {
                    row.add(bfs(dungeonMap, i, j));
                }
            }
            result.add(row);
        }
        if (isTest) {
            display("dungeonMap:", dungeonMap);
            display("result", result);
        }

        return result;
    }

    private static int bfs(List<List<Integer>> grid, int row, int column) {
        if (isTest) {
            System.out.println("------------------------------------");
            System.out.println("bfs @ [" + row + ", " + column + "]");
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[m][n];
        int[] deltaColumns = new int[] {0, 1, 0, -1};
        int[] deltaRows = new int[] {-1, 0, 1, 0};
        int level = 0;

        queue.offer(new int[] {row, column});
        isVisited[row][column] = true;

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println(" * level: " + level + " | queue: ");
                for (int[] e: queue) {
                    System.out.print(Arrays.toString(e) + " ");
                }
                System.out.println();
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int c = top[1];
                int r = top[0];

                if (grid.get(r).get(c) == 0) {
                    return level;
                }

                for (int k = 0; k < deltaRows.length; k++) {
                    int adjacentColumn = c + deltaColumns[k];
                    int adjacentRow = r + deltaRows[k];

                    if (adjacentColumn >= 0 && adjacentColumn < n
                            && adjacentRow >= 0 && adjacentRow < m
                            && grid.get(adjacentRow).get(adjacentColumn) != -1
                            && !isVisited[adjacentRow][adjacentColumn]) {
                        isVisited[adjacentRow][adjacentColumn] = true;
                        queue.offer(new int[] {adjacentRow, adjacentColumn});
                    }
                }
            }

            level++;
        }

        return key;
    }

    private static void display(String s, List<List<Integer>> grid) {
        System.out.println(s);
        for (List<Integer> row: grid) {
            System.out.println(row);
        }
        System.out.println("--------------------------------------");
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
