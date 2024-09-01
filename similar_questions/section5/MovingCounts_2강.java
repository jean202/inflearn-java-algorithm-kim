package similar_questions.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MovingCounts_2강 {

    public int solution(List<Integer> nums){
        int answer = 0;
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right){
            if (nums.get(left) + nums.get(right) <= 5){
                answer++;
                left++;
                right--;
            }
            else {
                answer++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        MovingCounts_2강 main = new MovingCounts_2강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int answer = main.solution(list);
        System.out.println(answer);
    }

}

