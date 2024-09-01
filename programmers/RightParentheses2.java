package programmers;

import java.util.Stack;

public class RightParentheses2 {

    public static boolean solution(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            }else {
                if (stack.size() == 0 || stack.pop() == c) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {

        System.out.println(solution("()()")); // t
        System.out.println(solution("(())()")); // t
        System.out.println(solution(")()(")); // f
        System.out.println(solution("(()(")); // f
        System.out.println(solution(")))")); // f
        System.out.println(solution("((())")); // f
        System.out.println(solution("(((")); // f

    }
}
