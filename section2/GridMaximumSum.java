package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridMaximumSum {

    public int solution(int[][] input) {

        int answer = Integer.MIN_VALUE;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < input.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < input[i].length; j++) {
                // 행의 합
                sum1 += input[i][j];
                // 열의 합
                sum2 += input[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = 0;
        sum2 = 0;
        // 두 대각선의 합
        for (int i = 0; i < input.length; i++) {
            sum1 += input[i][i];
            sum2 += input[i][input.length - 1 - i];
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        GridMaximumSum main = new GridMaximumSum();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberSize = Integer.parseInt(br.readLine());
        int[][] input = new int[numberSize][numberSize];

        for (int i = 0; i < numberSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numberSize; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
