package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SavetheCalfBfs {

    int answer = 0;
    int[] distance = {-1, 1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    private int bfs(int s, int e) {
        int level = 0;
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        while (!Q.isEmpty()) {
            int length = Q.size();
            for (int i = 0; i < length; i++) {
                int cur = Q.poll();
//                if (cur == e) {
//                    return level;
//                }
                for (int j = 0; j < 3; j++) {
                    int ax = cur + distance[j];
                    // 여기서 바로 e인지 아닌지 검사하면 안되나??
                    // 안됨! 현재 노드 아래 레벨에 넣어주는거고, 레벨 올리는 로직은 이 for문 밖에(i for문보다도 밖에) 있음

                    // 근데 return level + 1해서 리턴하면 되잖아!
                    // -> 된다
                    if (ax == e) {
                        return level + 1;
                    }

                    if (ax >= 1 && ax <= 10000 && ch[ax] == 0) {
                        ch[ax] = 1;
                        Q.offer(ax);
                    }
                }
            }
            level++;
        }
        return level; // return 0; 이니까 뭘로 해도 될거같아서
    }

    public static void main(String[] args) throws IOException {
        SavetheCalfBfs main = new SavetheCalfBfs();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer se = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(se.nextToken());
        int e = Integer.parseInt(se.nextToken());
        int answer = main.bfs(s, e);
        System.out.println(answer);
    }

}
