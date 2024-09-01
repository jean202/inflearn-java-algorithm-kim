package section1;

import java.util.Scanner;

public class PalindromeString {

    /**
     * 나의 풀이법 a b c d e a  |  c d a d c
     */
    public String mySolution(String input) {
        input = input.toLowerCase();
        char[] s = input.toCharArray();

        for (int i = 0; i < s.length / 2; i++) {
            if (!(s[i] == s[s.length - i - 1])) {
                return "NO";
            }
        }
        return "YES";
    }

    /**
     * 강사님 풀이법 1)
     */
    public String solution(String str) {
        String answer = "YES";
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if(str.charAt(i) != str.charAt(len -i -1)) return "NO";
        }
        return answer;
    }

    /**
     * 강사님 풀이법 2) StringBuilder와 eqaulsIgnoreCase활용
     */
    public String solution2(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp))  answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        PalindromeString main = new PalindromeString();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = main.solution(input);
        System.out.println(answer);
    }

}
