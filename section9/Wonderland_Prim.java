package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Wonderland_Prim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

        // 1 - (2, 12) , (9, 25)
        // 2 - (1, 12)
        // 3
        // ...
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        int[] ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer abc = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(abc.nextToken());
            int b = Integer.parseInt(abc.nextToken());
            int c = Integer.parseInt(abc.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge cur = pQ.poll();
            int v = cur.vex;
            if (ch[v] == 0) {
                ch[v] = 1;
                answer += cur.cost;
                for (Edge ob : graph.get(v)) {
                    if (ch[ob.vex] == 0) {
                        pQ.offer(new Edge(ob.vex, ob.cost));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
