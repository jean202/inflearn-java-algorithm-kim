package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination {
    static int n;
    static int m;
    static int[] combi;

    // 순열 : 체크배열 있고
    // 조합 : 체크배열 없는

    public void dfs(int level, int start) {
        if (level == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                combi[level] = i;
                dfs(level + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Combination main = new Combination();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());
        combi = new int[m];
        main.dfs(0, 1);
    }
}
