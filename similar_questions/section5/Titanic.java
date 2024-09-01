package similar_questions.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Titanic {

    public int solution(List<Integer> nums, int m){
        int answer = 0;
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        while(left <= right){
            if(nums.get(left) + nums.get(right) <= m){
                answer++;
                left++;
                right--;
            }
            else{
                answer++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Titanic main = new Titanic();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        int answer = main.solution(list, m);
        System.out.println(answer);
    }
}
