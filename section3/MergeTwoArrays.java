package section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MergeTwoArrays {



    public int[] solution(int[] inputA, int[] inputB) {
        int[] answer = new int[inputA.length + inputB.length];
        int pA = 0;
        int pB = 0;
        int i = 0;
        while (pA < inputA.length && pB < inputB.length) {
            if (inputA[pA] < inputB[pB]) {
                answer[i] = inputA[pA++];
            } else {
                answer[i] = inputB[pB++];
            }
            i++;
        }
        if (inputA.length < inputB.length) {
            for (i = pA + pB; i < answer.length; i++) {
                answer[i] = inputB[pB++];
            }
        } else {
            for (i = pA + pB; i < answer.length; i++) {
                answer[i] = inputA[pA++];
            }
        }
        return answer;
    }

    //3
    //1 3 5
    //5
    //2 3 6 7 9
    // 1 2 3 3 5 6 7 9

    // pB = 2
    // 6 7 9
    public List<Integer> teacherSolution(int[] inputA, int[] inputB) {
        List<Integer> answer = new ArrayList<>();
        int pA = 0;
        int pB = 0;
        while (pA < inputA.length && pB < inputB.length) {
            if (inputA[pA] < inputB[pB]) {
                answer.add(inputA[pA++]);
            } else {
                answer.add(inputB[pB++]);
            }
        }
        while (pA < inputA.length) {
            answer.add(inputA[pA++]);
        }
        while (pB < inputB.length) {
            answer.add(inputB[pB++]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        MergeTwoArrays main = new MergeTwoArrays();
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

        int[] answer = main.solution(inputA, inputB);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
