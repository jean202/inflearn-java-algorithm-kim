package baekjoon.B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IntelligentTrain {

    public int solution(int[][] input) {
        int answer = 0;
        int curPeople = input[0][1];
        int putPeople;

        for (int i = 1; i < 9; i++) {
            putPeople = input[i][1] - input[i][0];
            curPeople += putPeople;
            if (answer < curPeople) {
                answer = curPeople;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        IntelligentTrain main = new IntelligentTrain();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] input = new int[10][2];
        for (int i = 0; i < 10; i++) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(nm.nextToken());
            input[i][1] = Integer.parseInt(nm.nextToken());
        }
        bw.write(String.valueOf(main.solution(input)));
        bw.flush();
        br.close();
    }

}
