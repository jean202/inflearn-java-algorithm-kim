package baekjoon.S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj1789_minN {

    public int solution(long S) {
        // 200 > n (n + 1) / 2
        // 1보다 크다는건 1일수도 있다는거
        // 1 * 2 / 2 = 1
        // 반복문으로 1부터 계속 키우면서 그게 주어진 n을 넘으면 while에서 걸러서 탈출하게?
        long sum = 0;
        int i = 0;
        while(S >= sum) {
            // 여기서 하면 시작부터 1
            i++;
            // 1일때 1인거부터 시작해서
            // 19일때 190 확인했는데
            sum = (long) i * (i + 1) / 2;
        }
        return i - 1;
    }

    public int gptI(long S) {
        long sum = 0;
        for (int i = 1; ; i++) {
            if (sum + i > S) return i - 1;
            sum += i;
        }
    }

    public int gptCount(long S) {
        long sum = 0;
        int count = 0;
        for (int i = 1; ; i++) {
            if (sum + i > S) break;
            sum += i;
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        bj1789_minN main = new bj1789_minN();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long S = Long.parseLong(br.readLine());
        bw.write(String.valueOf(main.solution(S)));
        br.close();
        bw.close();
    }

}
