package similar_questions.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Subsequence_4강_Boj1182 {

    private int solution(int[] nums, int m) {
        int answer = 0;
        HashMap<Integer, Integer> nH = new HashMap<>();
        int sum = 0;
        nH.put(0, 1);
        for(int x : nums){
            sum += x;
            if(nH.containsKey(sum - m)) {
                answer += nH.get(sum - m);
            }
            nH.put(sum, nH.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Subsequence_4강_Boj1182 main = new Subsequence_4강_Boj1182();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println(main.solution(nums, m));
    }

}
