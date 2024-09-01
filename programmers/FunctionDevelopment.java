package programmers;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelopment {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            System.out.println("i = " + i);
            double day = (double) (100 - progresses[i]) / (double) speeds[i];
            int coverDay = (int) Math.ceil(day);
            int j = i + 1;
            for (; j < progresses.length; j++) {
                if (progresses[j] + coverDay * speeds[j] < 100) {
                    break;
                }
            }
            answer.add(j - i);
            i = j - 1;
        }
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        FunctionDevelopment main = new FunctionDevelopment();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] solution = main.solution(progresses, speeds);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
