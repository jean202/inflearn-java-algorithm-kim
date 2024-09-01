package similar_questions.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeRunner_4강 {

    private int solution(int[][] board) {

        Queue<int[]> Q = new LinkedList<>();

        // 1. dist 만들기
        int[][] dist = new int[8][8];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int L = 0;

        // 2. 큐에 넣기 (1,1)에서 시작해서 (7,7)까지 갈것임
        Q.offer(new int[]{1, 1});
        board[1][1] = 1;
//        dist[1][1] = 0;

        while (!Q.isEmpty()) {
            // cur의 레벨이 아닌 nx의 레벨
            L++;
            for (int i = 0; i < Q.size(); i++) {
                int[] cur = Q.poll();
//                board[cur[0]][cur[1]] = 1;
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] != 1) {
                        // 방문한 지점 체크
                        board[nx][ny] = 1;
                        // 출발 지점으로부터 nx까지 가는 거리값
                        dist[nx][ny] = L;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        if (dist[7][7] == 0) {
            return -1;
        } else return dist[7][7];

    }

    public static void main(String[] args) throws IOException {
        MazeRunner_4강 main = new MazeRunner_4강();
        int[][] board = new int[8][8];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 8; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = main.solution(board);
        System.out.println(answer);
    }
}
