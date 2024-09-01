package similar_questions.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class CardSelect_3강 {


    private int solution(int[] nums, int k) {
        int answer = 0;
        nums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int n = nums.length;
        int[] diff = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            answer += nums[i * 2 + 1];
            diff[i] = nums[i * 2] - nums[i * 2 + 1];
        }
        diff = Arrays.stream(diff).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < k; i++) {
            answer += diff[i];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        CardSelect_3강 main = new CardSelect_3강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println(main.solution(nums, k));
    }

}
