package section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinExchangeDp {

    static int n;
    static int m;
    static int[] dy;

    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) throws IOException {
        CoinExchangeDp main = new CoinExchangeDp();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] coin = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        dy = new int[m + 1];
        int answer = main.solution(coin);
        System.out.println(answer);
    }
}
