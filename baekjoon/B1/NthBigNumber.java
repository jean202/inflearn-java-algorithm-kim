package baekjoon.B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthBigNumber {

    private int[] solution(List<int[]> input) {
        int[] answer = new int[input.size()];
        int N = 3;

        for (int i = 0; i < input.size(); i++) {
            int[] inputs = input.get(i);
            Arrays.sort(inputs);
            answer[i] = inputs[inputs.length - N];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        NthBigNumber main = new NthBigNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        List<int[]> input = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            input.add(Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray());
        }
        int[] answer = main.solution(input);
        for (int i : answer) {
            bw.write(i + "\n");
        }
        br.close();
        bw.close();
    }

}
