package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Anagram {

    public String solution(String inputA, String inputB) {

        // AbaAeCe
        // baeeACA

        // 1. 갖고있는 문자들을 수집해서 캐릭터-개수 쌍으로 저장
        // 2. 둘이 같은지 비교?
        // 3. 아니면 다르게 할수 있는 방법이 있으려나?

        Map<Character, Integer> mapA = new TreeMap<>();
        Map<Character, Integer> mapB = new TreeMap<>();

        for (char a : inputA.toCharArray()) {
            mapA.put(a, mapA.getOrDefault(a, 0) + 1);
        }

        for (char b : inputB.toCharArray()) {
            mapB.put(b, mapB.getOrDefault(b, 0) + 1);
        }

        if (mapA.equals(mapB)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public String teacherSolution(String inputA, String inputB) {
        // HashMap 하나만 사용
        Map<Character, Integer> map = new HashMap<>();

        for (char a : inputA.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        char[] chars = inputB.toCharArray();

        // 1. Map의 value가 모두 0이 되면 YES
        // 2. NO가 되는 경우
        // 1) 기존 숫자에서 빼려고 하는데 이미 0인 경우 -> -가 나온 경우로 봐야할지 / 0일때 제외시킬지
        // 2) 없는 문자일 경우
        // 3) 기존 숫자에서 다 뺐는데 0이 아닌 경우
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                return "NO";
            }
            if (map.get(chars[i]) == 0) {
                return "NO";
            }
            map.put(chars[i], map.get(chars[i]) - 1);
        }
        for (char c : chars) {
            if (map.get(c) != 0) {
                return "NO";
            }
        }
        return "YES";
    }

    public String realTeacherSolution(String inputA, String inputB) {
        // HashMap 하나만 사용
        Map<Character, Integer> map = new HashMap<>();

        for (char a : inputA.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // ABACC
        // CCCBA

        // 1. Map의 value가 모두 0이 되면 YES
        // 2. NO가 되는 경우
        // 1) 기존 숫자에서 빼려고 하는데 이미 0인 경우 -> -가 나온 경우로 봐야할지 / 0일때 제외시킬지
        // 2) 없는 문자일 경우
        // 3) 기존 숫자에서 다 뺐는데 0이 아닌 경우 -> 1과 3은 사실상 같은 내용, 한쪽이 해당되면 다른 한쪽도 해당되기 때문에 둘 다 볼 필요X
        for (char b : inputB.toCharArray()) {
            if (!map.containsKey(b)) {
                return "NO";
            }
            if (map.get(b) == 0) {
                return "NO";
            }
            map.put(b, map.get(b) - 1);
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Anagram main = new Anagram();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputA = br.readLine();
        String inputB = br.readLine();
        String answer = main.teacherSolution(inputA, inputB);
        System.out.println(answer);
    }

}
