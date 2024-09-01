package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment2 {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();

        int[] days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                days[i]++;
            }

            queue.add(days[i]);
            System.out.println("i = " + days[i]);
        }

        int first = queue.poll();
        int d = 1;

        while (queue.size() > 0) {
            if (first >= queue.peek()) {
                queue.poll();
                d++;
            }else {
                res.add(d);


                d = 1;
                first = queue.poll();
            }
        }

        res.add(d);

        int[] ints = res.stream()
            .mapToInt(i -> i)
            .toArray();

        return ints;
    }

}
