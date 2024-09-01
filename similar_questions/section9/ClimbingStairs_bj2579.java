package similar_questions.section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs_bj2579 {

    private int solution(int[] input) {
        int[] dy = new int[input.length + 1];
        dy[0] = 0;
        dy[1] = input[0];
//        dy[2] = input[0] + input[1];
        // 강사님은 이것을
        if (input.length > 1) dy[2] = input[0] + input[1]; // 이렇게 표현하심
        // 만약 2개 값만 들어온다면 3일때 접근이 안될텐데 여기서 에러 안나는게 가능한가?
        // : dy.length에서 3보다 작은 조건이라 걸려서 실행을 안한다.
        for (int i = 3; i < dy.length; i++) {
            dy[i] = Math.max((dy[i - 2] + input[i - 1]), (dy[i - 3] + input[i - 2] + input[i - 1]));
            // 찾아본 코드들은 input[i - 1]이 겹치니까 이걸 밖으로 뺐다(그리고 대부분 i를 그대로 사용함-input배열 하나 더 써서
        }
        return dy[dy.length - 1];
    }

    public static void main(String[] args) throws IOException {
        ClimbingStairs_bj2579 main = new ClimbingStairs_bj2579();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        // 대부분 백준러들은 여기서 dp배열을 만들어서 진행한다.
        // bw BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 를 사용하기도
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
