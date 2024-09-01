package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 자기 자신을 비교하는 로직을 제외하지 않겠다
// -> 성적이 앞설때만 처리할 것인데 어차피 나와 나는 성적이 같고 처리되지 않음
public class Mentoring {

    // 입력
//        4 3
//        3 4 1 2
//        4 3 2 1
//        3 1 4 2

    public int solution(int[][] input) {
        int iANDj = input[0].length;
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < iANDj; i++) {
            // i가 0이고 j가 0일 때 : 1번 학생 vs 1번 학생
            for (int j = 0; j < iANDj; j++) {
                cnt = 0;
                // 1번 학생 vs 2번 학생
                for (int k = 0; k < input.length; k++) {
                    int is = 0;
                    int js = 0;

                    for (int s = 0; s < iANDj; s++) {
                        if (input[k][s] == (i + 1)) {
                            is = s;
                        }
                        if (input[k][s] == (j + 1)) {
                            js = s;
                        }
                    }
                    if (is < js) {
                        cnt++;
                    }
//                    0~k-1 회차 테스트를 돌면서
                    // 각 회차마다 i가 j보다 잘 했는지 아닌지 체크, 잘했으면 cnt++
                    // (k-1까지 했는데) 모든 테스트를 체크하며 등수비교를 했는데 cnt가 테스트 회수랑 같아져 있으면 answer++

                }

                if (cnt == input.length) {
                    answer++;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Mentoring main = new Mentoring();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        int[][] input = new int[m][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
