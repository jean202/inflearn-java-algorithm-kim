package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LRU {

    public int[] solution(int s, int[] work) {
        int[] cache = new int[s];
        for(int x : work) {
            int idx = -1;
            for (int i = 0; i < s; i++) {
                if (x == cache[i]) {
                    idx = i;
                }
            }
            if (idx == -1) { // miss 인 경우
                for (int i = s - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }

            } else { // hit 인 경우
                for (int i = idx; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }

    public static void main(String[] args) throws IOException {
        LRU main = new LRU();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sn = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(sn.nextToken());
        int n = Integer.parseInt(sn.nextToken());
        int[] work = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            work[i] = Integer.parseInt(st.nextToken());
        }
        int[] solution = main.solution(s, work);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
