package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_shortestPathtoEndNode {

    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dis;

    public void bfs(int v) {
        Queue<Integer> Q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        Q.offer(v);
        // 큐에 들어왔다 빠져나가는 순서
        // 1 -> 3, 4 ->
        while (!Q.isEmpty()) {
            int cv = Q.poll();
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    Q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Graph_shortestPathtoEndNode main = new Graph_shortestPathtoEndNode();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer ab = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(ab.nextToken());
            int b = Integer.parseInt(ab.nextToken());
            graph.get(a).add(b);
        }
        main.bfs(1);
        for (int i = 2; i <=n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
