package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PuppyRiding {

    static int c;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public void dfs(int level, int sum, int[] input) {
        if (sum > c) {
            return;
        }
        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level + 1, sum + input[level], input);
            dfs(level + 1, sum, input);
        }
    }

    public static void main(String[] args) throws IOException {
        PuppyRiding main = new PuppyRiding();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer cn = new StringTokenizer(br.readLine());
        c = Integer.parseInt(cn.nextToken());
        n = Integer.parseInt(cn.nextToken());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        main.dfs(0, 0, input);
        System.out.println(answer);
    }
}
