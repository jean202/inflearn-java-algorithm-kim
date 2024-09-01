package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NCombinationR {

    static int n;
    static int[][] dy;

    public int dfs(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            dy[n][r] = dfs(n - 1, r -1) + dfs(n - 1, r);
            return dy[n][r];
        }
    }

    public static void main(String[] args) throws IOException {
        NCombinationR main = new NCombinationR();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nr = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nr.nextToken());
        dy = new int[n + 1][n + 1];
        int r = Integer.parseInt(nr.nextToken());
        int answer = main.dfs(n, r);
        System.out.println(answer);
    }

}
