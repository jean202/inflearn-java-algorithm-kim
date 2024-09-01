package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort {

//    6
//        13 5 11 7 23 15


    public int[] solution(int[] sort) {
        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = 0; j < sort.length - 1 + i; j++) {
                if (sort[j] > sort[j + 1]) {
                    int tmp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = tmp;
                }
            }
        }
        return sort;
    }

    public static void main(String[] args) throws IOException {
        BubbleSort main = new BubbleSort();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sort = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sort[i] = Integer.parseInt(st.nextToken());
        }
        int[] solution = main.solution(sort);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
