package programmers.입문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CombineBigger {

    public int solution(int a, int b) {
        int answer = 0;
        StringBuilder abString = new StringBuilder();
        StringBuilder baString = new StringBuilder();
        int a_b = Integer.parseInt(abString.append(a).append(b).toString());
        int b_a =Integer.parseInt(baString.append(b).append(a).toString());
        if (a_b > b_a) {
            answer = a_b;
        } else if (a_b < b_a) {
            answer = b_a;
        } else {
            answer = a_b;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        CombineBigger main = new CombineBigger();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int answer = main.solution(a, b);
        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
