package programmers.codingTest.aivleschool.codingmasters.test2;
public class HistogramRestoration2 {

    public static int solution(int[][] histogram) {
        int rows = histogram.length; // 히스토그램의 세로 길이
        int cols = histogram[0].length; // 히스토그램의 가로 길이

        // 가능한 경우의 수를 계산하기 위해 DFS를 시작
        return dfs(histogram, rows, cols, 0, -1); // 첫 번째 열에서 시작, 이전 높이는 -1로 설정
    }

    private static int dfs(int[][] histogram, int rows, int cols, int col, int prevHeight) {
        if (col == cols) {
            // 모든 열을 처리한 경우 유효한 조합이므로 1을 반환
            return 1;
        }

        int count = 0;

        // 현재 열에서 가능한 모든 높이를 탐색
        for (int h = 0; h <= rows; h++) {
            if (canPlace(histogram, rows, col, h) && isContinuous(prevHeight, h)) {
                // 유효한 경우 다음 열로 이동
                count += dfs(histogram, rows, cols, col + 1, h);
            }
        }

        return count;
    }

    private static boolean canPlace(int[][] histogram, int rows, int col, int h) {
        boolean hasBar = false;

        // 해당 열에서 현재 높이를 놓을 수 있는지 확인
        for (int row = 0; row < rows; row++) {
            if (histogram[row][col] == 0 && h > row) {
                return false; // 빈 공간 위에 높이를 놓을 수 없음
            }
            if (histogram[row][col] == 1 && h == row + 1) {
                hasBar = true; // 막대가 있어야 하는 위치에 적합
            }
        }

        // 손상된 부분(2)이나 높이가 0인 경우도 허용
        return hasBar || h == 0;
    }

    private static boolean isContinuous(int prevHeight, int currHeight) {
        // 연속성 조건: 이전 높이와 현재 높이 차이가 1 이하이어야 함
        return prevHeight == -1 || Math.abs(prevHeight - currHeight) <= 1;
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
