package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingWindow {

    public int solution(int n, int k, int[] input) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += input[i];
        }
        answer = sum;
        for (int i = k; i < n; i++) {
            sum -= input[i - k];
            sum += input[i];
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        SlidingWindow main = new SlidingWindow();
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
