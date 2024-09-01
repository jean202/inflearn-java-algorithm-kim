package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class MazeShortestBFS {

    static int[][] board;
    static int[][] dis;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    private void bfs(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        board[x][y] = 1;
        // 초기화하면서 되어있을테니 생략가능
//        dis[x][y] = 0;
        while(!Q.isEmpty()) {
            Point cPoint = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cPoint.x + dx[i];
                int ny = cPoint.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[cPoint.x][cPoint.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MazeShortestBFS main = new MazeShortestBFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        main.bfs(1, 1);
        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }
}
