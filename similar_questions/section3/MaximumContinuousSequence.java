package similar_questions.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class MaximumContinuousSequence {

    private int solution(List<Integer> list) {

        int answer = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();
        set.addAll(list);

        for (int x : set) {
            int count = 0;
            if (set.contains(x - 1)) {
                continue;
            } else {
                while(set.contains(x)) {
                    count++;
                    x++;
                }
            }
            answer = Math.max(answer , count);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        MaximumContinuousSequence main = new MaximumContinuousSequence();
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
