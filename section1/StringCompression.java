package section1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StringCompression {

    /*
    문제를 잘못 이해해서 만든 오답
     */
    public String wrongComprehensionSolution(String input) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> cMap = new LinkedHashMap<>();

        for(int i = 0; i < input.length(); i++) {
            if(cMap.get(input.charAt(i)) != null) {
                cMap.put(input.charAt(i), cMap.get(input.charAt(i)) + 1);
            } else {
                cMap.put(input.charAt(i), 1);
            }
        }

        for(Entry<Character, Integer> entrySet : cMap.entrySet()) {
            if(entrySet.getValue() == 1) {
                answer.append(entrySet.getKey());
            } else {
                answer.append(entrySet.getKey()).append(entrySet.getValue());
            }
        }
        return answer.toString();
    }

    public String solution0(String input) {
        StringBuilder answer = new StringBuilder();
        int n = 1;

        char before = 0;
        char it = input.charAt(0);
        char after = input.charAt(1);

        for(int i = 0; i < input.length(); i++) {
            if (i > 0 && i < input.length() - 1){
                it = after;
                after = input.charAt(i + 1);
            } else if (i == input.length() - 1) {
                after = 0;
            }
            if (before != it && it == after) {
                   n++;
                   continue;
            } else {
                if (n != 1) {
                    answer.append(it).append(n);
                } else {
                    answer.append(it);
                }
            }
            n = 1;
            before = it;
        }
        return answer.toString();
    }

    public String solution1(String input) {
        StringBuilder answer = new StringBuilder();
        int n = 1;

        char before = 0;
        char it = input.charAt(0);
        char after = input.charAt(1);

        for(int i = 0; i < input.length(); i++) {
            if (i != 0){
                it = after;
                 if (i != input.length() - 1) {
                    after = input.charAt(i + 1);
                } else {
                    after = 0;
                }
            }
            if (before != it && it == after) {
                n++;
                continue;
            } else {
                if (n != 1) {
                    answer.append(it).append(n);
                } else {
                    answer.append(it);
                }
            }
            n = 1;
            before = it;
        }
        return answer.toString();
    }

    public String solution2(String input) {
        StringBuilder answer = new StringBuilder();
        int n = 1;

        char it = input.charAt(0);
        char after = input.charAt(1);

        for(int i = 0; i < input.length(); i++) {
            if (i != 0){
                it = after;
                if (i != input.length() - 1) {
                    after = input.charAt(i + 1);
                } else {
                    after = 0;
                }
            }
            if (it == after) {
                n++;
                continue;
            } else {
                if (n != 1) {
                    answer.append(it).append(n);
                } else {
                    answer.append(it);
                }
            }
            n = 1;
        }
        return answer.toString();
    }

    public String teacherSolution(String input) {
        StringBuilder answer = new StringBuilder();
        input = input + "";
        int cnt = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                cnt++;
            } else {
                answer.append(input.charAt(i));
                if (cnt > 1) {
                    answer.append(cnt);
                }
                cnt = 1;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        StringCompression main = new StringCompression();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = main.solution1(input);
//        String answer = main.teacherSolution(input);
        System.out.println(answer);
    }
}
