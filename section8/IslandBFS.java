package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IslandBFS {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer;
    static int n;

    public void bfs(int x, int y,  int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while(!queue.isEmpty()) {
            Point cPoint = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cPoint.x + dx[i];
                int ny = cPoint.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
                }
            }
        }

    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    bfs(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        IslandBFS main = new IslandBFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        main.solution(input);
        System.out.println(answer);
    }
}
