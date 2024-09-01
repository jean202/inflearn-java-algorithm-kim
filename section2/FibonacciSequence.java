package section2;

import java.util.Scanner;

public class FibonacciSequence {

    public int[] solution(int input) {

        int[] answer = new int[input];

//        int n1 = 1;
//        int n2 = 1;
//        int n3 = n1 + n2;
//        int n4 = n2 + n3;
//        ...
//        int ninput = n input-1 + n input -2;
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < input; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;

    }

    public static void main(String[] args) {
        FibonacciSequence main = new FibonacciSequence();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] answer = main.solution(input);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
