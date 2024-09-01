package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumofConsecutiveNaturalNumbers {

    // 15
    // 1 2 3 4 5 6 7 8

    // 14
    // 1 2 3 4 5 6 7

    // 1 2 3 4 5 6 7 8

    public int solution(int input) {
        int lt = 0;
        int sum = 0;
        int answer = 0;

        double inputD = (double) input;

        int half = (int) Math.ceil(inputD / 2);

        int x = (input / 2) + 1;

        int[] elements = new int[half];
        for (int i = 0; i < half; i++) {
            elements[i] = i + 1;
        }

        for (int rt = 0; rt < half; rt++) {
            sum += elements[rt];
            if (sum == input) {
                answer++;
            }
            while (sum >= input) {
                sum -= elements[lt++];
                if (sum == input) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        SumofConsecutiveNaturalNumbers main = new SumofConsecutiveNaturalNumbers();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int answer = main.solution(input);
        System.out.println(answer);
    }
}
