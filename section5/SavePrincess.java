package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SavePrincess {

    public int solution(int n, int k) {

        int answer = 0;

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }

        while (!Q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                Q.offer(Q.poll());
            }
            Q.poll();
            if (Q.size() == 1) {
                answer = Q.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        SavePrincess main = new SavePrincess();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = main.solution(n, k);
        System.out.println(answer);
    }
}
