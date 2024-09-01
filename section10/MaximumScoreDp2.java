package section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// main에서 바로 받으면서 하는 방식이 아닌 solution으로 나눠서 해보기
public class MaximumScoreDp2 {

    public int solution(int[][] arr, int limit) {
        int[] dy = new int[limit + 1];
        for (int i = 0; i < arr.length; i++) {
            int ps = arr[i][0];
            int pt = arr[i][1];
            for (int j = limit; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j - pt] + ps);
            }
        }
        return dy[limit];
    }

    public static void main(String[] args) throws IOException {
        MaximumScoreDp2 main = new MaximumScoreDp2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            ps
            arr[i][0] = Integer.parseInt(st.nextToken());
//            pt
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = main.solution(arr, m);
        System.out.println(answer);
    }

}
