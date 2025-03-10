package programmers.codingTest.aivleschool.codingmasters.test2;


public class HistogramRestoration3 {
    public static void main(String[] args) {
        int[][] histogram1 = {
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 1},
            {1, 1, 2, 2, 1, 0, 1},
            {2, 2, 2, 2, 1, 2, 2},
            {2, 2, 1, 1, 1, 2, 2},
            {2, 2, 1, 1, 1, 2, 2}
        };
        int[][] histogram2 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {2, 2, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {2, 1, 2, 2, 2},
            {2, 1, 2, 2, 2}
        };
        System.out.println(solution(histogram1)); // Output: 12
        System.out.println(solution(histogram2)); // Output: 18
    }

    public static int solution(int[][] histogram) {
        int rows = histogram.length;
        int cols = histogram[0].length;
        return countWays(histogram, rows, cols, 0, 0);
    }

    private static int countWays(int[][] histogram, int rows, int cols, int row, int col) {
        if (row == rows) {
            return 1;
        }
        if (col == cols) {
            return countWays(histogram, rows, cols, row + 1, 0);
        }
        if (histogram[row][col] != 2) {
            return countWays(histogram, rows, cols, row, col + 1);
        }

        int maxHeight = getMaxHeight(histogram, row, col);
        int ways = 0;
        for (int height = 0; height <= maxHeight; height++) {
            histogram[row][col] = height;
            ways += countWays(histogram, rows, cols, row, col + 1);
        }
        histogram[row][col] = 2; // Reset to original state
        return ways;
    }

    private static int getMaxHeight(int[][] histogram, int row, int col) {
        int maxHeight = 0;
        for (int i = row; i >= 0; i--) {
            if (histogram[i][col] == 1) {
                maxHeight = row - i + 1;
                break;
            }
        }
        return maxHeight;
    }
}
