package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Friendcheck_UnionFind {

    static int[] unf;

    // 매개변수인 학생의 집합 번호를 리턴
    public static int find(int ch) {
        if (ch == unf[ch]) {
            return ch;
        } else {
            return unf[ch] = find(unf[ch]);
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
        Friendcheck_UnionFind main = new Friendcheck_UnionFind();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        int m = Integer.parseInt(nm.nextToken());
        for (int i = 0; i < m; i++) {
            StringTokenizer ab = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(ab.nextToken());
            int b = Integer.parseInt(ab.nextToken());
            union(a, b);
        }
        StringTokenizer chAB = new StringTokenizer(br.readLine());
        int chA = Integer.parseInt(chAB.nextToken());
        int chB = Integer.parseInt(chAB.nextToken());
        int fA = find(chA);
        int fB = find(chB);
        if (fA == fB) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
