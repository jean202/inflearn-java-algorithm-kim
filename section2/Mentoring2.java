package section2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Mentoring2 {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]); // 학생 수
        M = Integer.parseInt(s[1]); // 테스트 수

        LowRank[] lowRanks = new LowRank[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lowRanks[i] = new LowRank();
        }

        for (int i = 0; i < M; i++) {

            // 학생번호
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


            for (int j = 0; j < arr.length - 1; j++) {
                int studentNumber = arr[j];

                //M번째 테스트에서 studentNumber 보다 시험을 못본 학생들이 있다면 등장횟수 증가
                for (int k = j + 1; k < arr.length; k++) {
                    lowRanks[studentNumber].showCount[arr[k]]++;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                // 멘토 조건 : 테스트 본 횟수와, 학생번호 N보다 시험을 못본 학생의 등장 횟수가 같아야함
                if (lowRanks[i].showCount[j] == M) {
                    count++;
//                    System.out.println(i + " / " + j);
                }
            }
        }

        System.out.println(count);
    }

    // N등 보다 테스트를 못본 학생들
    static class LowRank {
        // 특정 학생 번호 등장 횟수
        int[] showCount = new int[N+1];
    }

}
