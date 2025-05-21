package programmers.입문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class SeparatebySpaces2 {

    public String[] solution0(String my_string) {
        return my_string.split(" ");
    }

    public String[] solution1(String my_string) {
        return my_string.trim().split("[ ]+");
    }

    public String[] solution(String my_string) {
        ArrayList<String> answerList = new ArrayList();
        String word = "";
        for(int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) != ' ') {
                word += Character.toString(my_string.charAt(i));
            } else {
                if (!word.equals("")) {
                    answerList.add(word);
                    word = "";
                }
            }
        }
        if (!word.equals("")) {
            answerList.add(word);
        }
        String[] answer = new String[answerList.size()];
        answerList.toArray(answer);
        return answer;
    }


    public static void main(String[] args) throws IOException {
        SeparatebySpaces2 main = new SeparatebySpaces2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] answer = main.solution1(br.readLine());
        for (String s : answer) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
