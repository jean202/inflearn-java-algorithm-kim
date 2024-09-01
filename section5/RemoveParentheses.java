package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RemoveParentheses {

    public String solution(String input) {
        // (A(BC)D)EF(G(H)(IJ)K)LM(N)
        char[] paranthesesAndChars = input.toCharArray();
//        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        int lCount = 0;
        int rCount = 0;

        for (char paranthesesAndChar : paranthesesAndChars) {

            if (paranthesesAndChar == '(') {
//                stack.push(paranthesesAndChar);
                lCount++;
            }
//            if (stack.peek() == '(') {
//                stack.push(paranthesesAndChar);
//            }
            if (paranthesesAndChar == ')') {
//                stack.push(paranthesesAndChar);
                rCount++;
            }
            if ((lCount == rCount) && paranthesesAndChar != ')') {
                answer.append(paranthesesAndChar);
            }
        }
        return answer.toString();
    }
    // (A(BC)D)EF(G(H)(IJ)K)LM(N)
    // 하나의 괄호 묶음 단위로 지워버리고 마지막에 스택에 살아 남은것들을 답으로
    public String teacherSolution(String input) {

        char[] paranthesesAndChars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (char paranthesesAndChar : paranthesesAndChars) {

//            if (Character.isAlphabetic(paranthesesAndChar) && (stack.isEmpty() || Character.isAlphabetic(stack.peek()))) {
//                answer.append(paranthesesAndChar);
//            }
            // 닫는 괄호를 만나면 알파벳부터 그 전 여는 괄호까지 스택에서 팝 시켜버린다
            if (paranthesesAndChar == ')') {
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                // 여는 괄호나 알파벳을 스택에 push
                stack.push(paranthesesAndChar);
            }
        }

        for (Character character : stack) {
            answer.append(character);
        }

        return answer.toString();
    }

    // while문에서 조건문 안의 문장을 먼저 수행하고 후에 리턴받는 값으로 조건을 체크하는 방법이 있다는 것을 항상 기억하자!!
    public String teacherCode(String input) {
        char[] paranthesesAndChars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        // 그리고 while문 안에서 아무것도 안해도 된다!
        for (char paranthesesAndChar : paranthesesAndChars) {
            if (paranthesesAndChar == ')') {
                while (stack.pop() != '(') {
                }
            } else {
                stack.push(paranthesesAndChar);
            }
        }

        for (Character character : stack) {
            answer.append(character);
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        RemoveParentheses main = new RemoveParentheses();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
//        String answer = main.solution(input);
//        String answer = main.teacherSolution(input);
        String answer = main.teacherCode(input);
        System.out.println(answer);
    }
}
