package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class CraneDollDraw {

    public int solution(int[][] board, int[] moves) {
        
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        // 2차원 배열 : 앞이 행, 뒤가 열
        // 한 열이 몇개의 행으로 이루어져 있는지 보려면 : 행의 개수를 세야 -> 앞에껄 세야

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    int tmp = board[j][moves[i] - 1];
                    board[j][moves[i] - 1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }
    return answer;
    }

//    5
//        0 0 0 0 0
//        0 0 1 0 3
//        0 2 5 0 1
//        4 2 4 4 2
//        3 5 1 3 1
//        8
//        1 5 3 5 1 2 1 4
    public static void main(String[] args) throws IOException {
        CraneDollDraw main = new CraneDollDraw();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        int answer = main.solution(board, moves);
        System.out.println(answer);
    }
}
