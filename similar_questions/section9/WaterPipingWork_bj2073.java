package similar_questions.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaterPipingWork_bj2073 {


    private int solution(int d, int[][] lc) {

        /*
        7 6
l c
4 5
3 6
2 7
1 4
6 7
1 5

l끼리 더해서 d를 만드는데, 더하는데 사용된 요소의 c값중 가장 작은 값이 최대가 되도록 -> c값 큰 순서대로 먼저 뽑아서 d를 만들 수 있고..
         */

        // dy[i] : i길이의 수도관으로 만들수 있는 최대 용량

        int[] dy = new int[d + 1];

        for (int i = 0; i < lc.length; i++) {
            int l = lc[i][0];
            int c = lc[i][1];
            // l이 되기 전까지만 시행
            for (int j = d; j > l; j--) {
                // 수도관이 만들어져 있지 않아서 이어붙일 수 없다
                if (!(dy[j - l] == 0)) {
                                    // 이전값         // 파이프1 용량, 파이프2 용량
                    dy[j] = Math.max(dy[j], Math.min(dy[j - l], c));
                }
            }
            // l이 될 때 : dy[j - l]이 0이어도 이 0은 dy[0]이라 0인 것이니 dy[l] = c; 바로 넣어 주면 되서 min으로 비교할 필요가 없음
            dy[l] = Math.max(dy[l], c);
        }
        return dy[d];
    }

    public static void main(String[] args) throws IOException {
        WaterPipingWork_bj2073 main = new WaterPipingWork_bj2073();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer dp = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(dp.nextToken());
        int p = Integer.parseInt(dp.nextToken());

        int[][] lc = new int[p][2];

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lc[i][0] = Integer.parseInt(st.nextToken());
            lc[i][1] = Integer.parseInt(st.nextToken());
        }
        int answer = main.solution(d, lc);
        System.out.println(answer);
    }
}
