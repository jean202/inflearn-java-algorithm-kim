package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ClassPresident {

    public char solution(int n, String input) {
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        char answer = ' ';

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        ClassPresident main = new ClassPresident();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char answer = main.solution(n, input);
        System.out.println(answer);
    }
}
