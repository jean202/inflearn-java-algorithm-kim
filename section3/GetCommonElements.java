package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class GetCommonElements {

    public List<Integer> solution(int[] inputA, int[] inputB) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(inputA);
        Arrays.sort(inputB);

        int pA = 0;
        int pB = 0;

        //5

        // 1 2 3 5 9
        //5

        // 1 3 6 7 8

        // 1 2 3

        while (pA < inputA.length && pB < inputB.length) {
            if (inputA[pA] < inputB[pB]) {
                pA++;
            } else if (inputB[pB] < inputA[pA]){
                pB++;
            } else {
                answer.add(inputA[pA]);
                pA++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        GetCommonElements main = new GetCommonElements();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputAlength = Integer.parseInt(br.readLine());
        int[] inputA = new int[inputAlength];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputAlength; i++) {
            inputA[i] = Integer.parseInt(stA.nextToken());
        }

        int inputBlength = Integer.parseInt(br.readLine());
        int[] inputB = new int[inputBlength];
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputBlength; i++) {
            inputB[i] = Integer.parseInt(stB.nextToken());
        }

        List<Integer> answer = main.solution(inputA, inputB);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
