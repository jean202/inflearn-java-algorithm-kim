package baekjoon.S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class InsertingOperators {

    // + - x /
    // 2 1 1 1 이라고 하면
    // + + - x / 라는걸 놓고 조합해서 계산하는게 아니고

    // + - x / 를 for문 돌리면서 i로 switch case문 만들어서 구분하는게 포인트였음

    static int n;
    static int[] operator;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] answer;

    public void solution() {
        answer = new int[2];
        // DFS 구조 잡기
        // + + - x / 를 가지고 가능한 모든 경우의 수를 구해서 최소값 최대값 찾기
        DFS(1, arr[0]);
    }

    public void DFS(int startIdx, int result) {
        int nextResult = 0;
        if (startIdx == n) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            answer[0] = max;
            answer[1] = min;
           return;
        } else {
            for (int i = 0; i < 4; i++) {
                if (operator[i] > 0) {
                    // 사용하겠다
                    operator[i]--;
                    switch (i) {
                        case 0:
                            nextResult = result + arr[startIdx];
                            break;
                        case 1:
                            nextResult = result - arr[startIdx];
                            break;
                        case 2:
                            nextResult = result * arr[startIdx];
                            break;
                        case 3:
                            if (result < 0) {
                                nextResult = - (Math.abs(result) / arr[startIdx]);
                            } else {
                                nextResult = result / arr[startIdx];
                            }
                            break;
                    }
                    DFS(startIdx + 1, nextResult);
                    operator[i]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InsertingOperators main = new InsertingOperators();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operator = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        main.solution();
        bw.write(String.valueOf(answer[0]));
        bw.newLine();
        bw.write(String.valueOf(answer[1]));

        br.close();
        bw.close();

    }

}
