package similar_questions.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FirstCharacter {

    public int solution(String input) {
        int answer = 0;
        char[] inputC = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : inputC) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < inputC.length; i++) {
            if (map.get(inputC[i]) == 1) {
                answer = i + 1;
                break;
            } else {
                answer = -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        FirstCharacter main = new FirstCharacter();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
