package similar_questions.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BinarySorting {

    public int[] solution(List<Integer> list) {
        int[] answer = new int[list.size()];
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            int cnt = 0;
            int tmp = list.get(i);
            while (tmp > 0) {
                cnt += (tmp % 2);
                tmp = tmp / 2;
            }
            res[i][0] = list.get(i);
            res[i][1] = cnt;
        }
        Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int i = 0; i < res.length; i++){
            answer[i] = res[i][0];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BinarySorting main = new BinarySorting();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int[] answer = main.solution(list);
        for(int x : answer) {
            System.out.print(x + " ");
        }
    }
}
