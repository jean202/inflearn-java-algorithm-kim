package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MusicVideo {
// 27
    public int dvdCount(int[] input, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            if (sum + input[i] > capacity) {
                cnt++;
                sum = input[i];
            } else {
                sum += input[i];
            }
        }
        return cnt;
    }
    private int solution(int[] input, int m) {
        int answer = 0;
        int lt = Arrays.stream(input).max().getAsInt();
        int rt = Arrays.stream(input).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (dvdCount(input, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
//        9 3
//        1 2 3 4 5 6 7 8 9
        // lt = 9
        // mid = 16

        // lt = rt = 10

        // lt + rt / 2 = 10

        // rt = 9

        // rt = 26

        // mid = 27 : m

        // rt = 45

        return answer;
    }

    public static void main(String[] args) throws IOException {
        MusicVideo main = new MusicVideo();
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
