package baekjoon.B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci5 {

    public int solution(int n) {
        int zero = 0;
        int first = 1;

        int fibonacci = 0;

        if (n == 1) {
            fibonacci = zero + 1;
        }

        // 반복
        for (int i = 2; i <= n; i++) {
            // int i = 1 : f = 0 + 1
            // int i = 2 : f = 1 + 1
            // int i = 3 : f = 1 + 2
            fibonacci = zero + first;
            // zero = 1
            // zero = 1
            // zero = 2
            zero = first;
            // first = 1
            // first = 2
            // first = 3
            first = fibonacci;
        }

        return fibonacci;
    }

    public static void main(String[] args) throws IOException {
        Fibonacci5 main = new Fibonacci5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(main.solution(n)));
        br.close();
        bw.flush();
    }

}
