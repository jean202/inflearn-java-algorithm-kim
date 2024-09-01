package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumLengthConsecutiveSubsequences {

    public int solution(int n, int k, int[] input) {
        int answer = 0;
        int lt = 0;
        int cnt = 0;

        // k + 1 까지만 커져야 k가 2라면 3이되면 특정 동작을 해야
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13

                          // rt
                // lt
        // 1 1 0 0 1 1 0 1 1 0 1 1 0 1

        // rt - lt + 1

        // 1 1 0 1 1 1 1 1

        for (int rt = 0; rt < n; rt++) {
            if (input[rt] == 0) {
                // 0을 1로 바꿨다 가정하고
                cnt++;
            }

            // 2보다 커지면
            while (cnt > k) {
                if (input[lt++] == 0) {
                    cnt--;
                }
//                if (input[lt] == 0) {
//                    cnt--;
//                    lt++;
//                }
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        MaximumLengthConsecutiveSubsequences main = new MaximumLengthConsecutiveSubsequences();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nk.nextToken());
        int k = Integer.parseInt(nk.nextToken());

        int[] input = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int answer = main.solution(n, k, input);
        System.out.println(answer);
    }
}
