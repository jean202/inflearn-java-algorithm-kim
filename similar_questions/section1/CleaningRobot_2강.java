package similar_questions.section1;

public class CleaningRobot_2강 {

    private int[] solution(int[][] board, int k) {
        int[] answer = new int[2];
        int n = board.length;
        int x = 0;
        int y = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int d = 1;
        int count = 0;
        while (count < k) {
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args) {
        CleaningRobot_2강 main = new CleaningRobot_2강();
        int[][] arr1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 0,
            0}, {1, 0, 1, 0, 1}, {0, 0, 0, 0, 0}};
        int k1 = 10;
        int[] answer1 = main.solution(arr1, k1);
        System.out.println("[" + answer1[0] + ", " + answer1[1] + "]");
        int[][] arr2 = {{0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0}, {0, 0,
            0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0,
            0},{0, 0, 0, 0, 0, 0}};
        int k2 = 20;
        int[] answer2 = main.solution(arr2, k2);
        System.out.println("[" + answer2[0] + ", " + answer2[1] + "]");
        int[][] arr3 = {{0, 0, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0,
            0}, {1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}};
        int k3 = 25;
        int[] answer3 = main.solution(arr3, k3);
        System.out.println("[" + answer3[0] + ", " + answer3[1] + "]");
    }
}
