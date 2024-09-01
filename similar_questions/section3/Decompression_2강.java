package similar_questions.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Decompression_2강 {

    private String solution(String s) {
        String answer = "";
        Stack<String> st = new Stack<>();
        for (Character x : s.toCharArray()){
            if (x == ')'){
                String tmp = "";
                while (!st.empty()){
                    String popped = st.pop();

                    if (popped.equals("(")) {
                        String num = "";

                        while (!st.empty() && Character.isDigit(st.peek().charAt(0))){
                            num = st.pop() + num;
                        }

                        String res = "";
                        int cnt = 0;

                        if (num.equals("")) {
                            cnt = 1;
                        } else {
                            cnt = Integer.parseInt(num);
                        }

                        for (int i = 0; i < cnt; i++) {
                            res += tmp;
                        }

                        st.push(res);
                        break;
                    }
                    tmp = popped + tmp;
                }
            } else {
                st.push(String.valueOf(x));
            }
        }
        for(String x : st) {
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Decompression_2강 main = new Decompression_2강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer = main.solution(s);
        System.out.println(answer);
    }


}
