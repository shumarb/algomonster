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

        if (isTest) {
            print("dungeonMap:", dungeonMap);
        }
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
            print("result:", result);
        }

        return result;
    }

    private static int bfs(List<List<Integer>> grid, int row, int column) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[m][n];
        int[] deltaColumns = new int[] {0, 1, 0, -1};
        int[] deltaRows = new int[] {-1, 0, 1, 0};
        int level = 0;

        if (isTest) {
            System.out.println("-------------------------------\nbfs @ [" + row + ", " + column + "]");
        }

        queue.offer(new int[] {row, column});
        isVisited[row][column] = true;
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("\nlevel: " + level);
                System.out.print("queue: ");
                for (int[] point: queue) {
                    System.out.print("\n * " + Arrays.toString(point) + ": " + grid.get(point[0]).get(point[1]));
                }
                System.out.println();
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int c = top[1];
                int r = top[0];

                if (grid.get(r).get(c) == 0) {
                    if (isTest) {
                        System.out.println("\n ** exit @ level " + level);
                    }
                    return level;
                }

                for (int j = 0; j < deltaRows.length; j++) {
                    int adjacentColumn = c + deltaColumns[j];
                    int adjacentRow = r + deltaRows[j];
                    if (adjacentColumn >= 0 && adjacentColumn < n
                            && adjacentRow >= 0 && adjacentRow < m
                            && grid.get(adjacentRow).get(adjacentColumn) != -1
                            && !isVisited[adjacentRow][adjacentColumn]) {

                        queue.offer(new int[] {adjacentRow, adjacentColumn});
                        isVisited[adjacentRow][adjacentColumn] = true;
                    }
                }
            }

            level++;
        }

        return key;
    }

    private static void print(String s, List<List<Integer>> grid) {
        System.out.println(s);
        for (List<Integer> e: grid) {
            System.out.println(e);
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
