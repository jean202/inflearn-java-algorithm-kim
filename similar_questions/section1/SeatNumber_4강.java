package similar_questions.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeatNumber_4강 {

    private int[] solution(int c, int r, int k) {
        int[] answer = new int[2];
        // 받은 int[r][c] 를 시계방향 90도 회전시킴
        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0;
        int d = 1;
        int count = 1;
        if (k > c * r) {
            return new int[]{0, 0};
        }
        // todo while 조건이랑 nx ny, x y 처리 등 이런 식으로 했는지 다른 코드랑 비교 확인
        while(count < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        SeatNumber_4강 main = new SeatNumber_4강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        System.out.println(Arrays.toString(main.solution(c, r, k)));
    }

}
