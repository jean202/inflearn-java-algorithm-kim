package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSubsequence {

    public int solution(int n, int k, int[] input) {
        int lt = 0;
        int rt = 0;
        int answer = 0;
        int sum = 0;

        // 8 6
        // 1 2 1 3 1 1 1 2

        // 6 2 3

        // i = 0 부터 0까지
        // 0일때 시작
        // sum = sum + 6

        while (rt < n && lt < n) {
            sum = 0;
            for (int i = lt; i <= rt; i++) {
                sum += input[i];
            }
            if (sum < k) {
                rt++;
            } else {
                lt++;
            }
            if (sum == k) {
                answer++;
            }
        }
        return answer;
    }

    public int teacherSolution(int n, int k, int[] input) {
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += input[rt];
            if (sum == k) {
                answer++;
            }
            while (sum >= k) {
                sum -= input[lt++];
                if (sum == k) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        ContinuousSubsequence main = new ContinuousSubsequence();
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
