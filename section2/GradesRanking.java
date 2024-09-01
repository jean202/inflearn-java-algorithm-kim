package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GradesRanking {

    public int[] solution(int[] input) {

        List<Integer> answerList = Arrays.stream(input)
            .boxed()
            .collect(Collectors.toList());

        Map<Integer, Integer> answerMap = new HashMap<>();

        int[] answer = new int[input.length];

        answerList.sort(Comparator.reverseOrder());

        for (int i = 0; i < input.length; i++) {
            int target = input[i];

            int index = IntStream.range(0, answerList.size())
                .filter(x -> target == answerList.get(x))
                .findFirst()
                .orElse(-1);

            int i1 = answerList.indexOf(target);

            answerMap.put(input[i], index + 1);
        }


        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerMap.get(input[i]);
        }

        return answer;
    }

    public int[] teacherSolution(int[] input) {
        int[] answer = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int cnt = 1;
            for (int j = 0; j < input.length; j++) {
                if (input[i] < input[j]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        GradesRanking main = new GradesRanking();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberSize = Integer.parseInt(br.readLine());
        int[] input = new int[numberSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberSize; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = main.solution(input);
            for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
