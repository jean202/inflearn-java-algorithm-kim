package programmers.level1;

import java.util.Arrays;

public class nNumbersWithaGapofX {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        nNumbersWithaGapofX main = new nNumbersWithaGapofX();
        long[] answer = main.solution(-4, 2);
        System.out.println(Arrays.toString(answer));
    }
}
