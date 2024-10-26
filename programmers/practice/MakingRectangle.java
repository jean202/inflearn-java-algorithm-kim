package programmers.practice;

import java.util.Arrays;

public class MakingRectangle {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        int upperSide_x1 = v[0][0];
        int upperSide_y = v[0][1];

        int[] v1 = new int[] {v[1][0], v[1][1]};
        int[] v2 = new int[] {v[2][0], v[2][1]};

        // (1, 1) (2, 2)면 if문 둘다 안탐

        if (upperSide_x1 == v1[0]) {
            int lowerSide_y = v1[1];
            int lowerSide_x2 = v2[0];
            answer[0] = lowerSide_x2;
            if (upperSide_y == v2[1]) {
                answer[1] = lowerSide_y;
            } else if (lowerSide_y == v2[1]) {
                answer[1] = v2[1];
            }
        } else if (upperSide_y == v1[1]) {
            int upperSide_x2 = v1[0];
            int lowerSide_y = v2[1];
            answer[0] = upperSide_x1;
            answer[1] = lowerSide_y;
        } else { // (1,1) (2,2) 였을 경우 (1,2)를 봐야 함
            int upperSide_x2 = v2[0];
            int lowerSide_y = v2[1];
            answer[0] = v1[0];
            answer[1] = upperSide_y;
        }


//        System.out.println("[" + answer[0] +  ", " + answer[1] + "]");
        return answer;
    }

    public static void main(String[] args) {
        MakingRectangle main = new MakingRectangle();
//        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
//        int[][] v = {{1, 4}, {1, 12}, {5, 4}};
        int[] answer = main.solution(v);
        System.out.println(Arrays.toString(answer));
    }
}