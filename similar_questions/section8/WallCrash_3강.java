package similar_questions.section8;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WallCrash_3강 {
        public int solution(int[][] board) {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            int n = board.length;
            int m = board[0].length;
            // 0행 0열로부터 각 지점까지 오기 위해 부숴야 하는 벽의 개수
            int[][] cost = new int[n][m];
            for(int i = 0; i < n; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            cost[0][0] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pq.add(new int[]{0, 0, 0});
            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                // 지금 탐색하는 노드까지의 벽 부수는 개수 > 기존 배열 해당 지점의 벽 부수는 최소 개수
                if(cur[2] > cost[cur[0]][cur[1]]) {
                    continue;
                }
                for(int k = 0; k < 4; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    // 격자 밖이면
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    // 가려는 위치가 벽을 허물지 않아도 되는 경우 : 지금 탐색하는 노드의 벽 부수는 개수가 기존 값 보다 더 적게 부술 때
                    if(board[nx][ny] == 0 && cost[nx][ny] > cur[2]) {
                        cost[nx][ny] = cur[2];
                        pq.offer(new int[]{nx, ny, cur[2]});
                    // 가려는 위치가 벽을 허물어야 하는 경우 : 지금 탐색하는 노드의 벽 부수는 개수 + 하나 더 부쉈을 때 를 고려
                    } else if (board[nx][ny] == 1 && cost[nx][ny] > cur[2] + 1) {
                        cost[nx][ny] = cur[2] + 1;
                        pq.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
            return cost[n - 1][m - 1];
        }

    public static void main(String[] args) {
        WallCrash_3강 main = new WallCrash_3강();
        int answer = main.solution(new int [][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}});
        int answer2 = main.solution(new int [][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}});
        int answer3 = main.solution(new int [][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0,
            1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}});
        int answer4 = main.solution(new int [][]{{0, 1, 1, 0, 1, 1, 1},{1, 1, 1, 0, 1, 1, 1},{1, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}});
        int answer5 = main.solution(new int [][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1},
            {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1},
            {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}});

        System.out.println(answer);
    }
}
