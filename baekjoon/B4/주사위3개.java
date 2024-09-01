package baekjoon.B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위3개 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;

        // ? ? 요게 이해가 안감
        int prcie2 = a == b ? b == c ? 10000+(a*1000) : 1000+(a*100) : b == c || a == c ? 1000+(c*100) :  Math.max(Math.max(a, b), c) * 100;

        // 겨우 이해
        int price = (a == b && b == c) ? a * 1000 + 10000 : (a==b||a==c) ? a * 100 + 1000 : (b == c) ? c * 100 + 1000 : (a > b && a > c) ? a * 100 : (b > c) ? b * 100 : c * 100;

        if (a == b && b == c) {
            answer = 10000 + a * 1000;
        } else if (a != b && b != c && a != c) {
            if (a > b && a > c) {
                answer = a * 100;
            } else if (b > c) {
                answer = b * 100;
            } else {
                answer = c * 100;
            }
        } else {
            if (a == b || a == c) {
                answer = 1000 + a * 100;
            } else {
                answer = 1000 + b * 100;
            }
        }
        System.out.println(answer);
    }
}
