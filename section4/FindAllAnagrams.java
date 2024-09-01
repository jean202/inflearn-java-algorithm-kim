package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FindAllAnagrams {

    public int solution(String inputA, String inputB) {

//        bacaAacba
//        abc

        // 어떻게 해야 같은 녀석을 가져올 수 있을까?
        // 반대로 B에 대해서 가져와야 할까?
        // B에 대해서 가져오고 A를 슬라이딩 도어 한다.
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : inputB.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

//        char[] charsB = inputA.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < inputB.length(); i++) {
//            char[] tmp = new char[inputB.length()];
            str.append(inputA.charAt(i));
        }
        String sw = str.toString();

        for (int i = inputB.length(); i < inputA.length() + 1; i++) {
            boolean isAnagram = true;
            Map<Character, Integer> copyMap = new HashMap<>(map);

            for (char c : sw.toCharArray()) {
                if (!copyMap.containsKey(c) || copyMap.get(c) == 0) {
                    isAnagram = false;
                    break;
                }
                copyMap.put(c, copyMap.get(c) - 1);
            }

            if (isAnagram) {
                answer++;
            }
//            acaAacba
//acb
            // cb
            // cba
            if (i != inputA.length()) {
                str.deleteCharAt(0);
                str.append(inputA.charAt(i));
                sw = str.toString();
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        FindAllAnagrams main = new FindAllAnagrams();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputA = br.readLine();
        String inputB = br.readLine();
        int answer = main.solution(inputA, inputB);
        System.out.println(answer);
    }
}
