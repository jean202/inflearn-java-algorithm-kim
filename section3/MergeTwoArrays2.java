package section3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeTwoArrays2 {
    static int N;
    static int[] NN;

    static int M;
    static int[] MM;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        NN = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        M = Integer.parseInt(br.readLine());
        MM = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
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
        while (pm < M) {

            if (pn < N && cn[pn] < cm[pm]) {
                System.out.print(cn[pn++] + " ");
            }else {
                System.out.print(cm[pm++] + " ");
            }
        }

        System.out.println();
    }
}
