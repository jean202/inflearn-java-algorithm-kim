package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CorrectParentheses {

    public String solution(String input) {
        // (()(()))(()

        char[] parenthesesChars = input.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char parenthesesChar : parenthesesChars) {
            if (parenthesesChar == '(') {
                stack.push(parenthesesChar);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(parenthesesChar);
                }
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        CorrectParentheses main = new CorrectParentheses();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String answer = main.solution(input);
        System.out.println(answer);
    }
}
