package similar_questions.section1;

import java.io.IOException;

public class ClimbingLadder_1강 {

    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (i + 65);
        }
        for (int[] length : ladder) {
         for (int width : length) {
             char tmp = answer[width];
             answer[width] = answer[width - 1];
             answer[width - 1] = tmp;
         }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        ClimbingLadder_1강 main = new ClimbingLadder_1강();
        char[] ex1 = main.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}});
        char[] ex2 = main.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}});
        char[] ex3 = main.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}});
        char[] ex4 = main.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}});
        System.out.println(ex1);
        System.out.println(ex2);
        System.out.println(ex3);
        System.out.println(ex4);
    }
}
