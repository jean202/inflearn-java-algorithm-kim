package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OXscoring {

    private int solution(int[] input) {

        int answer = 0;
        int repeatCnt = 0;

        int[] answerList = new int[input.length];

        for (int i = 0; i < answerList.length; i++) {
            answerList[i] = input[i];
        }

        for(int i = 1; i < input.length; i++) {
            if(input[i] == input[i - 1] && input[i] == 1) {
                // 1
                repeatCnt++;
                // 2
                answerList[i] = answerList[i - repeatCnt] + repeatCnt;
            } else {
                repeatCnt = 0;
            }
        }

        for (int i : answerList) {
//            System.out.println("i = " + i);
            answer += i;
        }

        return answer;
    }

    public int teacherSolution(int[] input) {
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                cnt++;
                answer += cnt;
            } else {
                cnt = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        OXscoring main = new OXscoring();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberSize = Integer.parseInt(br.readLine());
        int[] input = new int[numberSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberSize; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int answer = main.solution(input);
        System.out.println(answer);
    }

}
