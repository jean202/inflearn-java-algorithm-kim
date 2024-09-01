package similar_questions.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CandyShop_bj4781 {

//    private int solution(int n, double m, double[][] arr) {
//    }

    private int solution(int n, int m, int[][] arr) {
        int[] dy = new int[m + 1];
        Arrays.fill(dy, 0);
        for (int i = 0; i < n; i++) {
            for (int j = arr[i][1]; j < dy.length; j++) {
                dy[j] = Math.max(dy[j], dy[j - arr[i][1]] + arr[i][0]);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) throws IOException {
        CandyShop_bj4781 main = new CandyShop_bj4781();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(nm.nextToken());
            double dm = Double.parseDouble(nm.nextToken());
            int m = (int) Math.round(dm * 100);
//            int m = (int) (dm * 100 + 0.5);
            if ((n == 0) && (m == 0)) {
                break;
            }
//            if ((n == 0) && (dm == 0.00)) {
//                break;
//            }
            int[] dy = new int[m + 1];
            int[][] arr = new int[n][2]; //solution

            for (int i = 0; i < n; i++) {
                StringTokenizer cp = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(cp.nextToken());
                double dp = Double.parseDouble(cp.nextToken());
                int p = (int) (dp * 100 + 0.5);
                arr[i][0] = c; // solution
                arr[i][1] = p; // solution
                for (int j = p; j <= m; j++) {
                    dy[j] = Math.max(dy[j], dy[j - p] + c);
                }
            }
            int answer = main.solution(n, (int) m, arr); // solution
            System.out.println(dy[m]);
        }

    }


}
