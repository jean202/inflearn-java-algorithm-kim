package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RouteNavigationDFSlist {

    static int n;
    static int m;
    static int answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        RouteNavigationDFSlist main = new RouteNavigationDFSlist();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer ab = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(ab.nextToken());
            int b = Integer.parseInt(ab.nextToken());
            graph.get(a).add(b);
        }

        ch[1] = 1;
        main.DFS(1);
        System.out.println(answer);
    }
}
