package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisibleStudent {

    public int solution(int[] input) {
        List<Integer> answer = new ArrayList<>();
        int compare = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > compare) {
                answer.add(input[i]);
                compare = input[i];
            }
        }
        return answer.size();
    }

    public static void main(String[] args) {
        VisibleStudent main = new VisibleStudent();
        Scanner sc = new Scanner(System.in);
        int listSize = sc.nextInt();
        int[] input = new int[listSize];
        for (int i = 1; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
