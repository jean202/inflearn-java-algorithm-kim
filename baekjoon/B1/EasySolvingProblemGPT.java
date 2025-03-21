package baekjoon.B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class EasySolvingProblemGPT {

    public int solution(int[] input) {
        int answer = 0;
        int A = input[0];
        int B = input[1];
        int cnt = 0;
        for (int i = 1; cnt < B; i++) {
            for (int j = 0; j < i && cnt < B; j++, cnt++) {
                if (cnt >= A) {
                    answer += i;
                }
            }
        }
        return answer;
    }

    public int solution2(int[] input) {
        int answer = 0;
        int A = input[0];
        int B = input[1];
        int cnt = 0;
        for (int i = 1; cnt < B; i++) {
            for (int j = 0; j < i; j++) {
                if (cnt >= B) {
                    break;
                }
                if (cnt >= A) {
                    answer += i;
                }
                cnt++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        EasySolvingProblemGPT main = new EasySolvingProblemGPT();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = main.solution2(input);
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
