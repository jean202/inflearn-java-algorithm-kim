package similar_questions.section1;

import java.util.Arrays;

public class 인프런_청소 {


    public static void main(String[] args) {
        int[][] board1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(answer(board1, 10)));

        int[][] board2 = {{0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(answer(board2, 20)));

        int[][] board3 = {{0, 0, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(answer(board3, 25)));
    }

    public static int[] answer(int[][] board, int k) {
        int direction = 0;
        int y = 0;
        int x = 0;

        while (k > 0) {
            int ty = y;
            int tx = x;

            switch (direction) {
                case 0: // 오른쪽
                    x++;
                    break;

                case 1: // 아래
                    y++;
                    break;

                case 2: // 왼쪽
                    x--;
                    break;

                case 3: // 위
                    y--;
                    break;
            }

            if (!check(board, y, x)) {
                direction = (direction + 1) % 4;

                y = ty;
                x = tx;
            }

            k--;
        }

        // 행, 열
        return new int[]{y, x};
    }

    public static boolean check(int[][] board, int y, int x) {
        int n = board.length;
        return (x >= 0 && y >= 0 && y < n && x < n) && (board[y][x] == 0);
    }
}