package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Rascal {

    public List<Integer> solution(int[] input) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = input.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < input.length; i++) {
            if (input[i] != tmp[i]) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Rascal main = new Rascal();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> answer = main.solution(input);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
