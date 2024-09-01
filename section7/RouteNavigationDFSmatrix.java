package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RouteNavigationDFSmatrix {

    static int n;
    static int m;
    static int answer;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if ((graph[v][i] == 1) && (ch[i] == 0)) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        RouteNavigationDFSmatrix main = new RouteNavigationDFSmatrix();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer ab = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(ab.nextToken());
            int b = Integer.parseInt(ab.nextToken());
            graph[a][b] = 1;
        }

        ch[1] = 1;
        main.DFS(1);
        System.out.println(answer);
    }
}
