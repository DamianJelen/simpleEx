package ex1;

import java.util.Arrays;

public class Ex_1 {
    public static void main(String[] args) {
        int[][] arrInt = {{1, 4}, {7, 10}, {3, 5}};
        int[][] arrInt1 = {{5, 8}, {3, 6}, {1, 2}};
        int[][] arrInt2 = {{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}};
        int[][] arrInt3 = {{-1000000000, 1000000000}};
        int[][] arrInt4 = {{0, 20}, {-100000000, 10}, {30, 40}};
        System.out.println("Wynik: " + sumIntervals(arrInt3));
        System.out.println("Wynik: " + sumIntervals(arrInt4));
    }

    public static int sumIntervals (int [][] intervals) {
        int result = 0;

        if (intervals.length == 0) {
            return 0;
        }

        if (intervals.length == 1) {
            result += Math.abs(intervals[0][1] - intervals[0][0]);
        }

        if (intervals.length > 0) {
            for (int i = 0; i < intervals.length - 1; i++) {
                for(int j = i + 1; j < intervals.length; j++) {
                    // A A' B B'
                    if(intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1] && intervals[j][1] >= intervals[i][1]) {
                        if(intervals[j][0] >= intervals[i][0]) {
                            intervals[j][0] = intervals[i][0];
                        }
                        intervals[i][0] = 0;
                        intervals[i][1] = 0;
                    }
                    // A' A B' B
                    else if(intervals[j][1] >= intervals[i][0] && intervals[j][1] <= intervals[i][1] && intervals[j][0] <= intervals[i][0]) {
                        if(intervals[j][1] <= intervals[i][1]) {
                            intervals[j][1] = intervals[i][1];
                        }
                        intervals[i][0] = 0;
                        intervals[i][1] = 0;
                    }
                    // A A' B' B
                    else if(intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1] && intervals[j][1] <= intervals[i][1]) {
                        intervals[j][0] = intervals[i][0];
                        intervals[j][1] = intervals[i][1];
                        intervals[i][0] = 0;
                        intervals[i][1] = 0;
                    }

                    if(i == intervals.length - 2 && j == intervals.length - 1) {
                        result += Math.abs(intervals[j][1] - intervals[j][0]);
                    }
                }
                result += Math.abs(intervals[i][1] - intervals[i][0]);
            }
        }

        return result;
    }
}
