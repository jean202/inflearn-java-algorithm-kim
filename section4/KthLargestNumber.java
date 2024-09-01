package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class KthLargestNumber {

    private int solution(int n, int k, int[] input) {
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(input[i] + input[j] + input[l]);
                }
            }
        }

        int cnt = 0;
        for (int target : Tset) {
            cnt++;
            if (cnt == k) {
                return target;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        KthLargestNumber main = new KthLargestNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nk.nextToken());
        int k = Integer.parseInt(nk.nextToken());

        int[] input = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int answer = main.solution(n, k, input);
        System.out.println(answer);
    }
}
