package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Postfix {

    private int solution(String input) {

        Stack<Integer> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (c == '+') {
                    stack.push(lt + rt);
                } else if (c == '-') {
                    stack.push(lt - rt);
                } else if (c == '*') {
                    stack.push(lt * rt);
                } else if (c == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        Postfix main = new Postfix();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = main.solution(input);
        System.out.println(answer);
    }

}
