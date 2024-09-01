package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class wEdge implements Comparable<wEdge>{

    public int v1;
    public int v2;
    public int cost;

    wEdge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(wEdge o) {
        return this.cost - o.cost;
    }
}

public class Wonderland_Kruskal {
// [3][3][3][4][5][][]
    static int[] unf;
    public static int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        int m = Integer.parseInt(nm.nextToken());
        ArrayList<wEdge> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer abc = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(abc.nextToken());
            int b = Integer.parseInt(abc.nextToken());
            int c = Integer.parseInt(abc.nextToken());
            arr.add(new wEdge(a, b, c));
        }

        int answer = 0;
        int cnt = 0;
        Collections.sort(arr);
        for (wEdge ob : arr) {
            int fv1 = find(ob.v1);
            int fv2 = find(ob.v2);
            if (fv1 != fv2) {
                answer += ob.cost;
                union(ob.v1, ob.v2);
                cnt++;
            }
            // 트리에서 정점이 n개면 간선 개수는 n-1개인 것을 이용
            if (cnt == n-1) {
                break;
            }
        }
        System.out.println(answer);
    }
}
