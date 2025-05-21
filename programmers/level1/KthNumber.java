package programmers.level1;

import java.util.Arrays;

public class KthNumber {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            int[] newArray = new int[end - start + 1];
            for (int a = 0; a < end - start + 1; a++) {
                newArray[a] = array[a + start - 1];
            }
            Arrays.sort(newArray);
            answer[i] = newArray[k - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        KthNumber main = new KthNumber();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = main.solution(array, commands);
        for (int x : answer) {
            System.out.println(x + " ");
        }
    }

}
