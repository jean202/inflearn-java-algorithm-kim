package similar_questions.section7;

import java.util.LinkedList;
import java.util.Queue;

public class ToHome_2강 {

    public int solution(int[] pool, int a, int b, int home){
        int[][] ch = new int[2][10001];
        // 웅덩이 처리
        for(int x : pool){
            ch[0][x] = 1;
            ch[1][x] = 1;
        }
        Queue<int[]> Q = new LinkedList<>();
        // 0까지 온 방법 처리
        ch[0][0] = 1;
        ch[1][0] = 1;
        Q.offer(new int[]{0, 0});
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] cur = Q.poll();
                if(cur[1] == home) return L;

                // 이동 처리
                // 앞으로 이동할 수 있고
                int nx = cur[1] + a;
                if(nx <= 10000 && ch[0][nx] == 0){
                    ch[0][nx] = 1;
                    Q.offer(new int[]{0, nx});
                }

                // 뒤로 이동할 수 있다
                nx = cur[1] - b;
                if(nx >= 0 && ch[1][nx] == 0 && cur[0] == 0){
                    ch[1][nx] = 1;
                    Q.offer(new int[]{1, nx});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ToHome_2강 main = new ToHome_2강();
        System.out.println(main.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(main.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(main.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(main.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(main.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }

}
