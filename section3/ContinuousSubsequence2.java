package section3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ContinuousSubsequence2 {
    static int N;
    static int M; // 수열을 더했을 때 목표 값

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();


        int[] sum = new int[N];
        sum[0] = nums[0];

        int t = 0;
        int count = 0;

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + nums[i];

            if (sum[i] == M) {
                count++;
                continue;
            }

            for (int j = t; j < i; j++) {
                if (sum[i] - sum[j] == M) {
                    t = j;
                    count++;

                    break;
                }
            }
        }

        System.out.println(count);

    }
}
