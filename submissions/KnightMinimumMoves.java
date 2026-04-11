// Question: https://algo.monster/problems/knight_shortest_path

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Scanner;

class Solution {
    public static int getKnightShortestPath(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        boolean isTest = false;
        int[] deltaColumns = new int[] {1, -1, 1, -1, 2, -2, 2, -2};
        int[] deltaRows = new int[] {2, 2, -2, -2, 1, 1, -1, -1};
        int[][] deltas = getDeltas();
        int level = 0;

        queue.offer(new int[] {0, 0});
        isVisited.add(Arrays.toString(new int[] {0, 0}));
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("level: " + level + "\n\nqueue:");
                for (int[] e: queue) {
                    System.out.println(Arrays.toString(e));
                }
                System.out.println("----------------------------");
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int column = top[1];
                int row = top[0];

                if (row == x && column == y) {
                    if (isTest) {
                        System.out.println(" * found @ level " + level);
                    }
                    return level;
                }

                for (int j = 0; j < deltaRows.length; j++) {
                    int[] incoming = new int[] {row + deltaRows[j], column + deltaColumns[j]};
                    String key = Arrays.toString(incoming);
                    if (!isVisited.contains(key)) {
                        isVisited.add(key);
                        queue.offer(incoming);
                    }
                }
            }

            level++;
        }
        if (isTest) {
            System.out.println(" * found @ level " + level);
        }

        return level;
    }

    private static int[][] getDeltas() {
        int[][] result = new int[8][2];
        result[0] = new int[] {2, 1};
        result[1] = new int[] {2, -1};
        result[2] = new int[] {-2, 1};
        result[3] = new int[] {-2, -1};
        result[4] = new int[] {1, 2};
        result[5] = new int[] {1, -2};
        result[6] = new int[] {-1, 2};
        result[7] = new int[] {-1, -2};
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = getKnightShortestPath(x, y);
        System.out.println(res);
    }
}
