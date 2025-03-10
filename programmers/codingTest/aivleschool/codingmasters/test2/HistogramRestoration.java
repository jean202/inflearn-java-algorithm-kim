package programmers.codingTest.aivleschool.codingmasters.test2;

import java.util.*;

public class HistogramRestoration {

    public static int solution(int[][] histogram) {
        int rows = histogram.length; // 세로 길이 (히스토그램의 최대 높이)
        int cols = histogram[0].length; // 가로 길이 (히스토그램의 수)

        // 가능한 히스토그램의 경우의 수를 저장할 배열
        int[] possibleHeights = new int[cols];
        Arrays.fill(possibleHeights, 1); // 기본값으로 1로 초기화

        // 열 별로 가능한 높이의 수를 계산
        for (int col = 0; col < cols; col++) {
            Set<Integer> heights = new HashSet<>();
            boolean hasGap = false;

            for (int row = 0; row < rows; row++) {
                int cell = histogram[row][col];
                if (cell == 0) {
                    // 빈 공간이 있다면 높이를 유추할 수 없음
                    hasGap = true;
                } else if (cell == 2) {
                    // 손상된 부분일 경우, 가능한 높이를 추측
                    heights.add(row + 1);
                } else if (cell == 1 && !hasGap) {
                    // 확실한 막대가 있는 경우
                    heights.clear();
                    heights.add(row + 1);
                }
            }

            // 가능한 높이의 수를 저장
            possibleHeights[col] = heights.isEmpty() ? 1 : heights.size();
        }

        // 가능한 경우의 수 계산
        int totalCases = 1;
        for (int height : possibleHeights) {
            totalCases *= height;
        }

        return totalCases;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[][] histogram1 = {
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 1},
            {1, 1, 2, 2, 1, 0, 1},
            {2, 2, 2, 2, 1, 2, 2},
            {2, 2, 1, 1, 1, 2, 2},
            {2, 2, 1, 1, 1, 2, 2}
        };
        System.out.println("Result 1: " + solution(histogram1)); // Expected: 12

        // 테스트 케이스 2
        int[][] histogram2 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {2, 2, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {2, 1, 2, 2, 2},
            {2, 1, 2, 2, 2}
        };
        System.out.println("Result 2: " + solution(histogram2)); // Expected: 18
    }
}
