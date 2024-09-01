package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch {
    private int solution(int[] input, int m) {
        Arrays.sort(input);
        int lt = 0;
        int rt = input.length - 1;
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (input[mid] == m) {
                answer = mid + 1;
                break;
            } else {
                if (input[mid] > m) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BinarySearch main = new BinarySearch();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int answer = main.solution(input, m);
        System.out.println(answer);
    }

}
