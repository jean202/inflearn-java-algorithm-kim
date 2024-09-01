package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortExercise_Duplication {

    public String solution(int[] input) {
        Arrays.sort(input);
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == input[i + 1]) {
                return "D";
            }
        }
        return "U";
    }

    public static void main(String[] args) throws IOException {
        SortExercise_Duplication main = new SortExercise_Duplication();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        String answer = main.solution(input);
        System.out.println(answer);
    }
}
