package similar_questions.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NearestBigNumber_1강 {

    int answer;
    int target;
    int m;
    int[] ch;
    boolean flag;
    ArrayList<Integer> nums;

    private void dfs(int level, int number) {
        // 강사님 코드(20573, 20735기준) : level은 0, number는 0, ch는 0 0 0 0 0 인 상태로 리턴(number는 level1 3 5 7 까지 가다가)
//                if (flag) return;
        if (level == m) {
            if (target < number) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(level + 1, number * 10 + nums.get(i));
                    // 여기다 두면 빠져 나올 때도 이 코드를 m번 반복한다, ch는 1 1 1 1 1 상태, 20735나오자마자 다른 숫자 더 안만듦
                    if (flag) return;
                    ch[i] = 0;
                }
            }
        }
    }

    private int solution(int n) {
        flag = false;
        target = n;
        int tmp = n;
        nums = new ArrayList<>();
        while (tmp > 0) {
            nums.add(tmp % 10);
            tmp = tmp / 10;
        }
        nums.sort((a, b) -> (a - b));
//        이렇게도 오름차순으로 만들수 있다고 알려주네 인텔리제이가
//        nums.sort(Comparator.comparingInt(a -> a));

        m = nums.size();

        // !! 오답 발생 이유 이것때문에 -> 이걸 dfs안에 넣으면 절대안됨 dfs재귀 될때마다 초기화 되어버림
        ch = new int[m];

        dfs(0, 0);

        if (flag) {
            return answer;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        NearestBigNumber_1강 main = new NearestBigNumber_1강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(main.solution(n));
    }
}
