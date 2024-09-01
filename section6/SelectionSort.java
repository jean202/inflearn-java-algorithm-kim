package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SelectionSort {

    public static void main(String[] args) throws IOException {
        SelectionSort main = new SelectionSort();
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

//    6
//        13 5 11 7 23 15


    private int[] solution(int[] sort) {
        for (int i = 0; i < sort.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < sort.length; j++) {
                if (sort[j] < sort[idx]) {
                    idx = j;
                }
            }
            int tmp = sort[i];
            sort[i] = sort[idx];
            sort[idx] = tmp;
        }
        return sort;
    }
}
