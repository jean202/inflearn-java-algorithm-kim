package similar_questions.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CatchingCalf_3강 {


    public int catchTheCalf(int s, int e) {
        if (s == e) return 0; // 현수의 시작 위치와 송아지의 시작 위치가 같으면 0초가 걸립니다.

        int[] visited = new int[200001]; // 방문한 위치를 기록할 배열
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
//        visited[s] = 1;

        int[] moves = {1, -1, 2}; // 현수가 이동할 수 있는 방향
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            // 송아지가 이동
            e += time;

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int move : moves) {
                    int next;
                    if (move == 2) {
                        next = current * move;
                    } else {
                        next = current + move;
                    }

                    if (next == e) return time; // 송아지의 위치에 도달하면 현재 시간을 반환

                    if (next >= 0 && next <= 200000 && visited[next] == 0) {
//                    if (next >= 0 && next <= 200000) {
                        visited[next] = 1;
                        queue.offer(next);
                    }
                }
            }

            if (e > 200000) e = 200000; // 최대 좌표를 넘지 않도록 제한
        }

        return -1; // 송아지를 잡을 수 없는 경우 -1 반환 (이 문제에서는 발생하지 않음)
    }



    private int solution(int s, int e) {
        int[][] ch = new int[2][200001];
        Queue<Integer> Q = new LinkedList<>();
        // 시작점 : 0레벨, 짝수레벨
        ch[0][s] = 1;
        Q.offer(s);
        int level = 0;
        while (!Q.isEmpty()) {
            int length = Q.size();
            level++;
            for (int i = 0; i < length; i++) {
                int x = Q.poll(); // 미리 넣어져 있던 값(이전 레벨 노드)
                // 현재 노드 진행
                int[] next = {x - 1, x + 1, x * 2};
                for (int nx : next) {
                    if (nx >= 0 && nx <= 200000 && ch[level % 2][nx] == 0) {
                        ch[level % 2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            e = e + level;
            if (e > 200000) {
                return -1;
            }
            if (ch[level % 2][e] == 1) {
                return level;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        CatchingCalf_3강 main = new CatchingCalf_3강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
//        int answer = main.solution(s, e);
        int answer = main.catchTheCalf(s, e);
        System.out.println(answer);
    }
}
