package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuessingSequence {
    static int n;
    static int f;

    boolean flag = false;

    static int[] answer;
    static int[] combi;
    static int[] ch;

    static int[][] dy;

    public int combination(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            dy[n][r] = combination(n - 1, r -1) + combination(n - 1, r);
            return dy[n][r];
        }
    }

    public void dfs(int level, int sum) {
        if (flag) {
            return;
        }
        if (level == n) {
            if (sum == f) {
                for (int x : answer) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <=n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    answer[level] = i;
                    dfs(level + 1, sum + answer[level] * combi[level]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        GuessingSequence main = new GuessingSequence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nf = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nf.nextToken());
        f = Integer.parseInt(nf.nextToken());
        dy = new int[n + 1][n + 1];
        answer = new int[n];
        combi = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) {
            combi[i] = main.combination(n-1, i);
        }
        main.dfs(0, 0);
    }
}
