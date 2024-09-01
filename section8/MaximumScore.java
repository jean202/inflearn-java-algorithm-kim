package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumScore {

    static int n;
    static int m;
    static int answer = Integer.MIN_VALUE;

    public void dfs(int level, int sum, int time, int[] ps, int[] pt) {
        if (time > m) {
            return;
        }
        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level + 1, sum + ps[level], time + pt[level], ps, pt);
            dfs(level + 1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) throws IOException {
        MaximumScore main = new MaximumScore();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer cn = new StringTokenizer(br.readLine());
        n = Integer.parseInt(cn.nextToken());
        m = Integer.parseInt(cn.nextToken());
        int[] score = new int[n];
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        main.dfs(0, 0, 0, score, time);
        System.out.println(answer);
    }
}
