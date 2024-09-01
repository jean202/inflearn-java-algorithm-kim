package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PizzaDelivery {
    static int n;
    static int m;
    static int len;
    static int answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, hs;

    public void dfs(int level, int s) {
        if (level == m) {
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[level] = i;
                dfs(level + 1, s + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PizzaDelivery main = new PizzaDelivery();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    hs.add(new Point(i, j));
                }
                if (tmp == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }
        len = pz.size();
        combi = new int[m];
        main.dfs(0, 0);
        System.out.println(answer);
    }
}
