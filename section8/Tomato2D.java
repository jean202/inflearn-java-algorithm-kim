package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato2D {
    static int n;
    static int m;
    static int[][] board;
    static int[][] day;
    static Queue<Point> Q = new LinkedList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    private void bfs() {
        // 하루가 지났다고 가정
        // 큐 맨앞 좌표부터 빼기 cur
        // 1. board에서 좌표의 상하좌우로 (익힐 수 있는) 토마토 익히기 -> board에 1 표시
        // 2. day에 해당 좌표 토마토 익는데 얼마나 걸렸는지 기재 (day[cur][좌표] + 1한 값으로)
        // 3. 방금 익힌 토마토 큐에 offer
        while (!Q.isEmpty()) {
            Point curPoint = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    day[nx][ny] = day[curPoint.x][curPoint.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Tomato2D main = new Tomato2D();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer mn = new StringTokenizer(br.readLine());
        m = Integer.parseInt(mn.nextToken());
        n = Integer.parseInt(mn.nextToken());
        board = new int[n][m];
        day = new int[n][m];
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    Q.offer(new Point(i, j));
                }
            }
        }

        main.bfs();

        // 1. board 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                }
            }
        }

        if (flag) {
            // 2. day 검사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, day[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

//        if (하나 이상의 토마토가 전부 -1로 둘러쌓여있어서 익을수 없었으면 : board에 익지 않은 0이 남아있으면??) {
//            System.out.println(-1);
//        }
//        if (처음부터 -1이랑 1만 있어서 day 결과가 전부 0이면 : board는 0보다 큰 수 아니면 -1) {
//            System.out.println(0);
//        }
//        if (둘 다 아니면 : board는 전부 0보다 큰 숫자) {
//            System.out.println(answer);
//        }
// 이런 방식을 생각했는데, 사실 day가 전부 0인 상황이면 최대값 자체가 0일테니 그대로 0을 출력하면 됨(문제 조건에 의해)

// ->
//      if () {
//      } else {
//      }

    }
}
