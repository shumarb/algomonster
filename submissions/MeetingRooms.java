// Question: https://algo.monster/problems/meeting_rooms

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class MeetingRooms {
    public static boolean meetingRooms(List<List<Integer>> intervals) {
        boolean isTest = false;
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)) == 0
                ? Integer.compare(a.get(1), b.get(1))
                : Integer.compare(a.get(0), b.get(0))
        );
        if (isTest) {
            System.out.println("sorted intervals:");
            for (List<Integer> e: intervals) {
                System.out.println(e);
            }
        }

        List<Integer> current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> next = intervals.get(i);
            if (next.get(0) <= current.get(1)) {
                return false;
            }
            current = next;
        }

        return true;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intervalsLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> intervals = new ArrayList<>();
        for (int i = 0; i < intervalsLength; i++) {
            intervals.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        boolean res = meetingRooms(intervals);
        System.out.println(res);
    }
}
