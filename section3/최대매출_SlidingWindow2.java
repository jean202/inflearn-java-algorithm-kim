package section3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 최대매출_SlidingWindow2 {
    static int N;
    static int K; // 연속된 k일

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();


        int[] sum = new int[N-3];
        sum[0] = nums[0] + nums[1] + nums[2];

        int max = sum[0];

        for (int i = 1; i < N-3; i++) {
            sum[i] = nums[i] + nums[i+1] + nums[i+2];
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);


    }
}
