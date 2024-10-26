package programmers.practice;

import java.util.Arrays;

public class MakingRectangle {
    public int[] mySolution(int[][] v) {
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
        return answer;
    }

    public int[] copilotSolution(int[][] v) {
        int[] answer = new int[2];

        // x 좌표와 y 좌표를 각각 저장할 배열
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            x[i] = v[i][0];
            y[i] = v[i][1];
        }

        // x 좌표 중에서 한 번만 나타나는 값을 찾기
        if (x[0] == x[1]) {
            answer[0] = x[2];
        } else if (x[0] == x[2]) {
            answer[0] = x[1];
        } else {
            answer[0] = x[0];
        }

        // y 좌표 중에서 한 번만 나타나는 값을 찾기
        if (y[0] == y[1]) {
            answer[1] = y[2];
        } else if (y[0] == y[2]) {
            answer[1] = y[1];
        } else {
            answer[1] = y[0];
        }

        return answer;
    }

    // 이건 틀렸음. 답 안나옴.
    // 입력된 3 개의 v값들 중
//    x좌표의 최솟값과 최댓값을 찾아 왼쪽 아래 꼭짓점의 x좌표와 오른쪽 위 꼭짓점의 x좌표를 결정한다.
//    y좌표의 최솟값과 최댓값을 찾아 왼쪽 아래 꼭짓점의 y좌표와 오른쪽 위 꼭짓점의 y좌표를 결정한다.
    public int[] geminiSolution(int[][] v) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int[] point : v) {
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
            maxX = Math.max(maxX, point[0]);
            maxY = Math.max(maxY, point[1]);
        }
        return new int[]{minX, maxY};
    }

    // Todo HashMap 으로 해보기!

    public static void main(String[] args) {
        MakingRectangle main = new MakingRectangle();
//        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
//        int[][] v = {{1, 4}, {1, 12}, {5, 4}};
        int[] answer = main.copilotSolution(v);
        System.out.println(Arrays.toString(answer));
    }
}