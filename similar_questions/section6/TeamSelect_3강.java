package similar_questions.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TeamSelect_3강 {

    static List<int[]> input;
    int n;
    int answer;
    int[] black;
    int[] white;
    int[] ch;

    private int solution(List<int[]> input) {

        answer = Integer.MAX_VALUE;
        n = input.size();
        ch = new int[n];
        // 방법 2 :
//        black = new int[n / 2];
//        white = new int[n / 2];

        DFS(0);

        return answer;
    }

    private void DFS(int level) {

        if (level == (n / 2)) {
            int blackA = 0;
            int whiteA = 0;
            for (int i = 0; i < n; i++) {
                // 검은돌팀 점수 합산
                if (ch[i] == 1) {
                    blackA += input.get(i)[1];
                    // 방법 2 : A팀 B팀 나누기
                    // black[i] = i;
                    // 흰돌팀 점수 합산
                } else {
                    whiteA += input.get(i)[0];
                    // white[i] = i;
                }
            }
            int diff = blackA > whiteA ? blackA - whiteA : whiteA - blackA;
            // Math.abs(blackA - whiteA)도 가능
            answer = Math.min(answer, diff);
        } else {
            for (int i = 0; i < n; i++) {
                // 검은돌 팀에 넣고 있다고 가정
                // 원래 조합은 이렇게 하면 안될거 같은데.. 지금 3까지만 고르고 다 찼으면 나머지 애들로 팀 짜서 가능한것인가
                if (ch[i] != 1) {
                    ch[i] = 1;
                    DFS(level + 1);
                    ch[i] = 0;
                }
            }
            // 방법 2 -> DFS(level, S)
//            for (int i = s; i < n; i++) {
//                ch[i] = 1;
//                DFS(level + 1, i + 1);
//                ch[i] = 0;
//            }
        }
    }


    public static void main(String[] args) throws IOException {
        TeamSelect_3강 main = new TeamSelect_3강();
        input = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int[] p = new int[2];
            p[0] = Integer.parseInt(st.nextToken());
            p[1] = Integer.parseInt(st.nextToken());
            input.add(p);
        }
        System.out.println(main.solution(input));
    }

}
