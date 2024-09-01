package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronRod {

    private int solution(String input) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                // c가 닫는 괄호이면 인덱스로 하나씩 계속 밀고 가야한다..?? 앞에꺼를 저장해야 한다?? -> 이제 이해됨
                if (stack.peek() == '(') { // 조건 자체가 잘못됨
                    stack.pop();
                    answer += stack.size();
                } else { // else일수가 없음. 애초에 스택에는 ( 이것만 들어감
                    // (((()(()()))(())()))(()())
                    // ) 탐색중인데
                    // 스택에 있는게 ) -> 막대기 끝

                    // ())) 이렇게 연속으로 있을 경우
                    // 끝인거니까 하나 잘리고()) 이렇게 남고
                    // 끝인거니까 또 하나 잘리고 () 이렇게 남고

                    // (((()(()() ))

                    // (((

                    // ((( ( (


                    // ) 들어갈 때

                    // ((( ( ( 가 스택에 있으니까

                    // -> 사이즈로 넣는게 아니라 +1 해야함

                    // ((( ( ( ))
                    // ((( ( ( )
                    //

                    // 이렇게 3개 연달아 있는 경우가 2번 있으니까 2가 더해져서 들어간 것

                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }

    public int teacherCode(String input) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else { // )

//                (((()(()()))

                // ((( () ( () () ) )
                // ((( ( () () ) )
                // ((( ( () ) ) *
                // ((( ( ) )

                // ())) 문제 : ((( ( () ) ) * 상황

                // () 없어졌고
                // ) 이게 새로 돌아오는 녀석이면

                // 스택 안에는
                // ((( ( 이렇게 남아있는데

                // 무조건 스택의 직전 애가 ( 이거라고 쌍으로 생각해서 없애려고 하면 안됨

                /// 이게 주어진 문자열에서도 지금거랑 쌍인지를 봐야 함
                // 문자열 앞에글자가 (가 아니라 )였다면 stack.size()를 더해주는게 아니라 1을 더해줘야 함

                // 근데 이렇든 저렇든 pop은 둘다 해줘야(이제 더 못 쓰는 녀석임)
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        IronRod main = new IronRod();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
//        int answer = main.solution(input);
        int answer = main.teacherCode(input);
        System.out.println(answer);
    }
}
