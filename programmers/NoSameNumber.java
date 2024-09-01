package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoSameNumber {

    public int[] solution(int []arr) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            // 1 1 3 3 0 1 1
            // 4 4 4 3 3
            // 333 456
            // 1과 1
            if (arr[i] != arr[i - 1]){
                tmp.add(arr[i]);
            }
        }

        int[] answer = new int[tmp.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = tmp.get(i);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

}
