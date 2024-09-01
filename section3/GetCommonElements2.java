package section3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class GetCommonElements2 {
    static int N;
    static int[] NN;

    static int M;
    static int[] MM;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        NN = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();

        M = Integer.parseInt(br.readLine());
        MM = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();


        int[] cn = NN.clone();
        int[] cm = MM.clone();

        if (M < N) {
            cn = MM.clone();
            N = MM.length;

            cm = NN.clone();
            M = NN.length;
        }

        int pn = 0;
        int pm = 0;

        int prev1 = 1;
        int prev2 = 2;

        while (pm < M) {
            if (pn < N && cn[pn] < cm[pm]) {
                prev1 = cn[pn++];
            }else {
                prev2 = cm[pm++];
            }

            if (prev1 == prev2) {
                System.out.print(prev1 + " ");
            }
        }

        System.out.println();
    }
}
