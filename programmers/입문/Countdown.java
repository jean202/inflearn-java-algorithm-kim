package programmers.입문;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Countdown {
    public int[] solution(int start_num, int end_num) {
        int n = start_num - end_num + 1;
        int[] answer = new int[n];
        for (int i = start_num; i >= end_num; i--) {
            answer[- (i - start_num)] = i;
            // 9
            // - 10
            // = -1
            // 1

            // 8
            // - 10
            // = -2
            // 2
        }
        return answer;
    }

    // 좀 더 보기 좋은것
    public int[] iSolution(int start, int end) {
        int[] answer = new int[start - end + 1];
        for(int i = 0; i <= start - end; i++) {
            answer[i] = start - i;
        }
        return answer;
    }

    // IntStream.rangeClosed는 항상 왼쪽 값 ≤ 오른쪽 값이어야만 정상 동작
    public int[] pSolution(int start, int end) {
            // −10, −9, −8, −7, −6, −5, −4, −3
        return IntStream.rangeClosed(-start, -end)
            // 10, 9, 8, 7, 6, 5, 4, 3
            .map(i -> -i)
            .toArray();
    }

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        int[] answer = countdown.solution(10, 3);
        System.out.println(Arrays.toString(answer));
    }
}
