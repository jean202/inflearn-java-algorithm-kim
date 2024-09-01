package section3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumofConsecutiveNaturalNumbers2 {
/*
        N = 15, 답3
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

        * N보다 작을때까지 p1~p2 계산
        * N보다 크면 p1을 뺀다
        * N이면 카운트 +1

     */

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        int p1 = 1;
        int p2 = 1;
        int sum = 0;
        int count = 0;

        while (p1 < N && p2 < N) {

            if (sum < N) {
                sum += p2++;
            }
            else if (sum > N) {
                sum -= p1++;
            }
            else {// sum == N
                count++;
                sum += p2++;
            }

        }

        System.out.println(count);

    }
}
