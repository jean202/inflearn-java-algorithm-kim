package section3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumLengthConsecutiveSubsequences2 {
 /*
        답 8
        14 2
        1 1 0 0 1 1 0 1 1 0 1 1 0 1

        - k개 만큼 업데이트 후 p1~p2 계산 후 수열 길이 저장
        - 업데이트 전 마지막 0 위치 저장
        - 반복하면서 수열 길이 math.max로 업데이트

     */

    static int N;
    static int K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int p1 = 0;
        int p2 = 0;
        int k = K;
        int count = 0;
        int max = 0;

        while (p2 < N) {
            try {

                if (k > 0 && nums[p2] == 0) {
                    k--;
                    count++;
                    continue;
                }

                if (nums[p2] == 1) {
                    count++;
                    continue;
                }

                if (k == 0 && nums[p2] == 0) {
                    max = Math.max(max, count);

                    p2 = p1++;
                    k = K;
                    count = 0;
                }

            }finally {
                p2++;
            }

        }

        max = Math.max(max, count);

        System.out.println(max);

    }

}
