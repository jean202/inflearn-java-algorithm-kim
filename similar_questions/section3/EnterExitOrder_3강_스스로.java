package similar_questions.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EnterExitOrder_3강_스스로 {

    private int[] solution(int[] arrival, int[] state) {
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length;
        int prev = 1;
        int[] answer = new int[n];

        int cnt1 = 0;
        for (int t = 0; ; t++){
            if (cnt1 == n) break;
        }
        // 아니면 while(true)로?

        for (int t = 0, i = 0, cnt = 0; ; t++){
            if (enter.isEmpty() && exit.isEmpty() && i < n){
                if (t < arrival[i]){
                    t = arrival[i];
                    prev = 1;
                }
            }
            while (i < n && arrival[i] <= t) {
                if (state[i] == 0) {
                    enter.offer(i);
                } else {
                    exit.offer(i);
                }
                i++;
            }
            if (prev == 1) {
                if (!exit.isEmpty()){
                    answer[exit.poll()] = t;
                    prev = 1;
                } else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if (prev == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if (cnt == n) break;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        EnterExitOrder_3강_스스로 main = new EnterExitOrder_3강_스스로();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputA = br.readLine().split(" ");
        int[] arrival = new int[inputA.length];
        for (int i = 0; i < inputA.length; i++) {
            arrival[i] = Integer.parseInt(inputA[i]);
        }
        String[] inputB = br.readLine().split(" ");
        int[] state = new int[inputB.length];
        for (int i = 0; i < inputB.length; i++) {
            state[i] = Integer.parseInt(inputB[i]);
        }
        System.out.println(Arrays.toString(main.solution(arrival, state)));
    }
}
