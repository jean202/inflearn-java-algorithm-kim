package similar_questions.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class FindingSequence_2강 {

    public int[] solution(List<Integer> nums){
        int[] answer = new int[nums.size() / 2];
        HashMap<Integer, Integer> nH = new HashMap<>();
        for (int x : nums) {
            nH.put(x, nH.getOrDefault(x, 0) + 1);
        }
        Collections.sort(nums);
        int idx = 0;
        for (int x : nums) {
            if (nH.get(x) == 0) continue;
            answer[idx] = x;
            idx++;
            nH.put(x, nH.get(x) - 1);
            nH.put(x * 2, nH.get(x * 2) - 1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        FindingSequence_2강 main = new FindingSequence_2강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int[] answer = main.solution(list);
        System.out.println(Arrays.toString(answer));
    }

}
