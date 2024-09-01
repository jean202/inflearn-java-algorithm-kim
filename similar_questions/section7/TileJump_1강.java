package similar_questions.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TileJump_1강 {

    public int solution(List<Integer> nums) {
        int n = nums.size();
        int[] ch = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        ch[0] = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int position = queue.poll();
                int jump = nums.get(position);
                for (int j = 1; j <= jump; j++) {
                    int jumped = position + j;
                    if (jumped == n - 1) {
                        return level + 1;
                    }
                    if (jumped < n && ch[jumped] == 0) {
                        queue.offer(jumped);
                        ch[jumped] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        TileJump_1강 main = new TileJump_1강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int answer = main.solution(list);
        System.out.println(answer);
    }
}
