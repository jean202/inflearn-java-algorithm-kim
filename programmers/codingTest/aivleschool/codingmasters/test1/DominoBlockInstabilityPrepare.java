package programmers.codingTest.aivleschool.codingmasters.test1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DominoBlockInstabilityPrepare {

    public int solution(int[] position, int[] height, int m) {

        int previousInstability = 0;
        int domino = 0;
        int n = position.length;

        @SuppressWarnings("unchecked")
        List<Integer>[] collapsible = (List<Integer>[]) new ArrayList[n];
        // 0 1 2
        // [ {2}, {3,4}, {4, 5, 6}, {}    ]

        for (int i = 0; i < n; i++) {
            collapsible[i] = new ArrayList<>();
            domino = position[i] + height[i];
            // i 0 j 1
            // i 1 j 2 3 4 5 6
            for (int j = i + 1; j < n; j++) {
                if (position[j] <= domino) {
                    collapsible[i].add(j);
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            // 몇개 쓰러뜨리는지 반환
            int toppled = toppleCount(i, collapsible);
            previousInstability = Math.max(previousInstability, toppled);
        }


        return 0;
    }

    private int toppleCount(int start, List<Integer>[] collapsible) {
        boolean[] visited = new boolean[collapsible.length];
        Queue<Integer> queue = new LinkedList();

        visited[start] = true;
        queue.offer(start);

        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : collapsible[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        DominoBlockInstabilityPrepare main = new DominoBlockInstabilityPrepare();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] position = {1, 3, 4, 5, 9, 10};
        int[] height = {1, 2, 5, 2, 2, 4};
        int m = 1;
        bw.write(String.valueOf(main.solution(position, height, m)));
        bw.flush();
    }
}
