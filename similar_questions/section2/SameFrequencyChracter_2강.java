package similar_questions.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class SameFrequencyChracter_2강 {

    private int[] solution(String s) { // aaabc
        int[] answer = new int[5];
        HashMap<Character, Integer> sH = new HashMap<>();
        for(char c : s.toCharArray()) {
            sH.put(c, sH.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        String target = "abcde";
        for (char x : target.toCharArray()) {
            if (max < sH.getOrDefault(x, 0)) {
                max = sH.getOrDefault(x, 0);
            }
        }
        for (int i = 0; i < target.length(); i++) {
            answer[i] = max - sH.getOrDefault(target.charAt(i), 0);
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        SameFrequencyChracter_2강 main = new SameFrequencyChracter_2강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] answer = main.solution(s);
        System.out.println(Arrays.toString(answer));
    }

    

}
