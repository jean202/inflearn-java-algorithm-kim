package section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringReverse {

    public List<String> solution(String[] str) {

        List<String> answer = new ArrayList<>();

        for (String s : str) {
            char[] c = s.toCharArray();
            int len = c.length;
            int lt = 0;
            int rt = len-1;
            for(int i = 0; lt < rt; i++) {
                char rtt = c[rt];
                c[rt] = c[lt];
                c[lt] = rtt;
                lt++;
                rt--;
            }
            String answerString = String.valueOf(c);
            answer.add(answerString);
        }
        return answer;
    }

    public static void main(String[] args) {
        StringReverse stringReverse = new StringReverse();
        Scanner in = new Scanner(System.in);
        int inputWordNumber = in.nextInt();
        String[] str = new String[inputWordNumber];
        for (int i = 0; i < inputWordNumber; i++) {
            str[i] = in.next();
        }

        for (String s : stringReverse.solution(str)) {
            System.out.println(s);
        }
    }

}
