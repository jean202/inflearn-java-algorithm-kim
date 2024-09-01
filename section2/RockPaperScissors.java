package section2;

import java.util.Scanner;

public class RockPaperScissors {

    public char[] solution(int listSize, int[] aInput, int[] bInput) {
        char[] answer = new char[listSize];
        // 1 가위 2 바위 3 보
        // A B

        // 가위 1 바위 2 -> B
        // 가위 1  보 3 -> A

        // 바위 2 가위 1 -> A
        // 바위 2  보 3 -> B

        // 보 3 가위 1 -> B
        // 보 3 바위 2 -> A

        // 1이랑 2랑 만나면 2쪽이 이김
        // 1이랑 3이랑 만나면 1이 이김
        // 2랑 3이랑 만나면 3이 이김
        // [ 1 2 ] = 2
        // [ 1 3 ] = 1
        // [ 2 3 ] = 3
        // 같으면 비김

        for(int i = 0; i < listSize; i++) {
            if (aInput[i] == bInput[i]) {
                answer[i] = 'D';
            } else {
                if (aInput[i] == 1) {
                    answer[i] = (bInput[i] == 2) ? 'B' : 'A';
                } else if (aInput[i] == 2) {
                    answer[i] = (bInput[i] == 1) ? 'A' : 'B';
                } else {
                    answer[i] = (bInput[i] == 1) ? 'B' : 'A';
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        RockPaperScissors main = new RockPaperScissors();
        Scanner sc = new Scanner(System.in);
        int listSize = sc.nextInt();
        int[] aInput = new int[listSize];
        int[] bInput = new int[listSize];
        for (int i = 0; i < aInput.length; i++) {
            aInput[i] = sc.nextInt();
        }
        for (int i = 0; i < bInput.length; i++) {
            bInput[i] = sc.nextInt();
        }
        char[] answer = main.solution(listSize, aInput, bInput);
        for (char c : answer) {
            System.out.println(c);
        }
    }
}
