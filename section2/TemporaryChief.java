package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO
/*
input[i][k] == input[j][k]를 할 때 꼭 i j 두개의 for문을 돌려야 하는지?
0부터 input.length까지 돌리는거 똑같은데 한번 돌리면서 그 안에서 i조절하면서 해결할수는 없을지 생각해보기
 */
public class TemporaryChief {

    public int solution(int[][] input) {
        // i번 학생과 같은 반을 했던 j번 학생은 몇명 있는지 카운팅
        // j번 학생과 i번 학생이 같은 반인지 확인하기 위한 3중 for문(1학년~5학년)
        // i번 학생의 k학년과 j번학생의 k학년의 반 값을 비교
        // 자기 자신과 자기 자신을 비교하는 것도 진행하도록 해도 된다
        // (모든 학생이 동등하게 자기 자신을 같은 학년 같은 반이었다고 카운팅 한다면 동등한 조건이니 상관 없다)
        // 각각의 횟수 자체가 의미 있는게 아니라 제일 큰 값이 중요한 거니까
        // 단, 같은 사람과 두번 세번 같은 반이 된 횟수는 의미가 없으므로 한 번 같은 반이었던게 확인되면 break해줘야

        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            int cnt = 0;
            for (int j = 0; j < input.length; j++) {
                for (int k = 0; k < 5; k++) {
                    if (input[i][k] == input[j][k]) {
                        cnt++;
                        break;
                    }
                }
                // i번 학생과 같은 반을 했던 학생수 cnt가 나온다.
                if (cnt > max) {
                    max = cnt;
                    answer = i + 1;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        TemporaryChief main = new TemporaryChief();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberSize = Integer.parseInt(br.readLine());
        int[][] input = new int[numberSize][5];

        for (int i = 0; i < numberSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
