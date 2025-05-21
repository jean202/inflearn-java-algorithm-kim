package programmers.입문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 숨어있는숫자의덧셈 {

    public int solution(String my_string) {
        int answer = 0;
        char[] charArray = my_string.toCharArray();
        int plusNumber = 0;
        for (int i = 0; i < my_string.length(); i++) {
            if (charArray[i] >= 65 && charArray[i] <= 122) {
                continue;
            }
            if ((i + 1) != my_string.length()) {
                if (charArray[i + 1] <= 64 || charArray[i + 1] >= 123) {
                    plusNumber += (int) charArray[i] - 48;
                    plusNumber *= 10;
                } else {
                    answer += plusNumber + (int) charArray[i] - 48;
                    plusNumber = 0;
                }
            }
            if (i == my_string.length() - 1) {
                answer += plusNumber + (int) charArray[i] - 48;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        숨어있는숫자의덧셈 main = new 숨어있는숫자의덧셈();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(main.solution(br.readLine())));
        bw.flush();
        bw.close();
        br.close();
    }
}
