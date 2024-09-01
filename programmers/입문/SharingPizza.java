package programmers.입문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SharingPizza {

    public int solution(int n) {
        int answer = 0;
        // 피자 하나에 7조각
        // 모든 사람이 한조각씩 먹으려면

        int quotient = 0;
        int remainder = 0;

        quotient = n / 7;
        remainder = n % 7;

        if (remainder != 0) {
            answer++;
        }
        answer += quotient;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        SharingPizza main = new SharingPizza();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = main.solution(n);
        bf.write(String.valueOf(answer));
        bf.flush();
    }

}
