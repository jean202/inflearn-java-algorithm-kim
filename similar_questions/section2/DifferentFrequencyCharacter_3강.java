package similar_questions.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DifferentFrequencyCharacter_3강 {

    private int solution(String s) {
        int answer = 0;

        HashMap<Character, Integer> sH = new HashMap<>();
        for (char c : s.toCharArray()) {
            sH.put(c, sH.getOrDefault(c, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        // aebbbbc
        for (char key : sH.keySet()) {
            // 문자 개수를 유니크하게 만들기
            while (set.contains(sH.get(key))) {
                answer++;
                sH.put(key, sH.get(key) - 1);
            }
            // 유니크해진 문자 개수가 만약 0이면 set에 넣지 않는다-> 0으로 while문 돌게 하지 않기 위해
            // while문에 포함시키면 다른 0들(그냥 없앤것 뿐임)이랑 겹쳐서 sH 밸류 값을 -1로 만들게 됨
            if (sH.get(key) == 0) continue;

            // 유니크해진 문자 개수를 set에 넣어서 다른 문자 개수의 비교 대상이 되도록 만듦
            set.add(sH.get(key));
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        DifferentFrequencyCharacter_3강 main = new DifferentFrequencyCharacter_3강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = main.solution(s);
        System.out.println(answer);
    }

}
