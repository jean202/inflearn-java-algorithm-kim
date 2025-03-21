package baekjoon.B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// TODO 단순화 해서 다시 풀어보기
public class EasySolvingProblem {

    public int solution(int[] input) {
        int answer = 0;
        int A = input[0];
        int B = input[1];

        /*
        // 1. 우선 끝 범위까지를 전부 배열 안에 넣어본다고 생각함
        // 1 2 3 4 5 6 7 8 9 10 11
        // 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 를 만들어 놔야
        int[] arr = new int[B + 1]; // 0 ~ 7 되도록, 그리고 1 2 3 4 5 6 7 이렇게 넣기
        int cnt = 1;
        for (int i = 1; i <= B; i++) {
            if (cnt > B) {
                break;
            }
            for (int j = 0; j < i; j++) {
                arr[cnt] = i;
                cnt++;
                if (cnt > B) {
                    break;
                }
            }
        }
         */
        int n = 0;
        for (int i = 1; i <= B; i++) {
            if (n >= B) {
                break;
            }
            for (int j = 0; j < i; j++) {
                n++;
                if (n < A) {
                    continue;
                }
                answer += i;
                if (n >= B) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        EasySolvingProblem main = new EasySolvingProblem();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = main.solution(input);
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
