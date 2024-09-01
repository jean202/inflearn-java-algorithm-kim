package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM3 {

    static int[] pm;
    static int n;
    static int m;

    public void dfs(int level) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[level] = i;
                dfs(level + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NandM3 main = new NandM3();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());
        pm = new int[m];
        main.dfs(0);
    }
}
