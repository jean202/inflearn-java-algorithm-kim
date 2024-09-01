package section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrossingStone {

    static int[] dy;

    public int solution(int n) {

        // 1개의 돌다리 건너기
        dy[1] = 1;
        // 2ㄱㅐㅇㅡㅣ ㄷㅗㄹㄷㅏㄹㅣ ㄱㅓㄴㄴㅓㄴㅡㄴ ㅂㅏㅇㅂㅓㅂ
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n];
    }

    public static void main(String[] args) throws IOException {
        CrossingStone main = new CrossingStone();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dy = new int[n + 2];
        int answer = main.solution(n + 1);
        System.out.println(answer);
    }
}
