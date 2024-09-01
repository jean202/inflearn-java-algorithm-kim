package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CoinExchange {

    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;

    private void dfs(int level, int sum, Integer[] input) {
        if (sum > m || level >= answer) {
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, level);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(level + 1, sum + input[i], input);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CoinExchange main = new CoinExchange();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Integer[] input = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] =  Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());
        main.dfs(0, 0, input);
        System.out.println(answer);
    }
}
