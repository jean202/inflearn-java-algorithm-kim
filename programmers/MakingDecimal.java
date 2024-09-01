package programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakingDecimal {

    int comb;
    int comb_count;
    List<Integer> sum_num_arr = new ArrayList<>();

    public int solution(int[] nums) {
        int answer = 0;

        combination(nums, 0, 0);


        // 에라토스테네스의 체 -> 안된다. 2부터 특정 숫자까지 숫자중 모두 소수를 밝혀내는게 아니라, 특정 숫자들이 소수인지 보는거라서
        // 특정 숫자에서부터 특정 숫자까지 하기도 애매하고..

/*
        int max = Integer.MIN_VALUE;

        for (int x : sum_num_arr) {
            max = Math.max(max, x);
        }

        int[] ch = new int[max + 1];
        for (int i = 2; i < ch.length; i++) {
            for (int j = i; j < ch.length; j++) {
                if (j % i == 0) {
                    ch[j] = 1;
                }
            }
        }
*/
        for (int x : sum_num_arr) {
            if (isPrime(x)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void combination(int[] nums, int cnt, int start) {
        if (cnt == 3) {
            comb_count++;
            sum_num_arr.add(comb);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int n = nums[i];
            comb += n;
            combination(nums,cnt + 1, i + 1);
            comb -= n;
        }
    }

    public static void main(String[] args) throws IOException {
        MakingDecimal main = new MakingDecimal();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nums = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int answer = main.solution(nums);
        bf.write(String.valueOf(answer));
        bf.flush();
    }

}
