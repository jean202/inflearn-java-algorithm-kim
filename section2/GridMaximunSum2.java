package section2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GridMaximunSum2 {
    static int N;
    static int[][] graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            for (int j = 0; j < N; j++) {
                graph[i][j] = arr[j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int y = 0; y < N; y++) {

            for (int x = 0; x < N; x++) {
                int sumX = getSumX(y);
                int sumY = getSumY(x);
                int sumRightCross = getSumRightCross(y, x);
                int sumLeftCross = getSumLeftCross(y, x);

                int test1 = Math.max(sumX, sumY);
                int test2 = Math.max(test1, sumRightCross);
                int test3 = Math.max(test2, sumLeftCross);

                max = Math.max(max, test3);
            }
        }

        System.out.println(max);

    }

    static boolean isValidIndex(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    static int getSumX(int y) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += graph[y][i];
        }
        return sum;
    }

    static int getSumY(int x) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += graph[i][x];
        }
        return sum;
    }

    static int getSumRightCross(int y, int x) {
        int sum = 0;

        int ny = y;
        int nx = x;
        while (isValidIndex(ny, nx)) {
            sum += graph[ny][nx];

            ny++;
            nx++;
        }

        return sum;
    }

    static int getSumLeftCross(int y, int x) {
        int sum = 0;

        int ny = y;
        int nx = x;
        while (isValidIndex(ny, nx)) {
            sum += graph[ny][nx];

            ny++;
            nx--;
        }

        return sum;
    }
}
