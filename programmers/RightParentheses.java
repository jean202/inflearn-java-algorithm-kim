package programmers;

import java.util.Scanner;
import java.util.Stack;

public class RightParentheses {
    boolean solution(String s) {
        boolean answer = true;

        char[] c = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (Character character : c) {
            if (character.equals('(')) {
                stack.push(character);
            } else if (character.equals(')')) {
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    stack.push(character);
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
        // )
        // ()(
    }

    public static void main(String[] args) {
        RightParentheses rightParentheses = new RightParentheses();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        boolean answer = rightParentheses.solution(input);
        System.out.println("answer = " + answer);
    }
}
