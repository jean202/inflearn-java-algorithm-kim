package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExhaustiveSearch {
    public int[] mySolution(int[] answers) {
        int[] answer;
        int fcnt = 0;
        int scnt = 0;
        int tcnt = 0;
        for (int i = 0; i < answers.length; i++) {
            // 첫번째 수포자
            switch (i % 5) {
                case 0:
                    if (1 == answers[i]) {
                        fcnt++;
                    }
                    break;
                case 1:
                    if (2 == answers[i]) {
                        fcnt++;
                    }
                    break;
                case 2:
                    if (3 == answers[i]) {
                        fcnt++;
                    }
                    break;
                case 3:
                    if (4 == answers[i]) {
                        fcnt++;
                    }
                    break;
                case 4:
                    if (5 == answers[i]) {
                        fcnt++;
                    }
                    break;
            }
            // 두번째 수포자
            if (i % 2 == 0) {
                if (2 == answers[i]) {
                    scnt++;
                }
            }
            if (i % 8 == 1) {
                if (1 == answers[i]) {
                    scnt++;
                }
            }
            if (i % 8 == 3) {
                if (3 == answers[i]) {
                    scnt++;
                }
            }
            if (i % 8 == 5) {
                if (4 == answers[i]) {
                    scnt++;
                }
            }
            if (i % 8 == 7) {
                if (5 == answers[i]) {
                    scnt++;
                }
            }
            // 세번째 수포자
            switch (i % 10) {
                case 0: case 1:
                    if (3 == answers[i]) {
                        tcnt++;
                    }
                    break;
                case 2: case 3:
                    if (1 == answers[i]) {
                        tcnt++;
                    }
                    break;
                case 4: case 5:
                    if (2 == answers[i]) {
                        tcnt++;
                    }
                    break;
                case 6: case 7:
                    if (4 == answers[i]) {
                        tcnt++;
                    }
                    break;
                case 8: case 9:
                    if (5 == answers[i]) {
                        tcnt++;
                    }
                    break;
            }
        }

        if (fcnt > scnt) {
            if (fcnt > tcnt) {
                answer = new int[1];
                answer[0] = 1;
            } else if (fcnt < tcnt) {
                answer = new int[1];
                answer[0] = 3;
            } else { // 첫번째랑 세번째랑 같은 경우
                answer = new int[2];
                answer[0] = 1;
                answer[1] = 3;
            }
        } else if (fcnt < scnt) {
            if (scnt > tcnt) {
                answer = new int[1];
                answer[0] = 2;
            } else if (scnt < tcnt) {
                answer = new int[1];
                answer[0] = 3;
            } else { // 두번째랑 세번째랑 같은 경우
                answer = new int[2];
                answer[0] = 2;
                answer[1] = 3;
            }
        } else { // 첫번째 두번째 같은 경우
            if (fcnt > tcnt) {
                answer = new int[2];
                answer[0] = 1;
                answer[1] = 2;
            } else if (fcnt < tcnt) {
                answer = new int[1];
                answer[0] = 3;
            } else { // 셋 다 같은 경우
                answer = new int[3];
                answer[0] = 1;
                answer[1] = 2;
                answer[2] = 3;
            }
        }
        return answer;
    }

    public int[] pSolution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

        public int[] solution(int[] answers) {
            // 1. 찍기 패턴 정의
            int[][] patterns = {
                {1, 2, 3, 4, 5},             // 1번 수포자
                {2, 1, 2, 3, 2, 4, 2, 5},    // 2번 수포자
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 3번 수포자
            };
            int[] scores = new int[3];

            // 2. 모든 문제에 대해 각 수포자 채점
            for (int i = 0; i < answers.length; i++) {
                for (int s = 0; s < 3; s++) {
                    if (answers[i] == patterns[s][i % patterns[s].length]) {
                        scores[s]++;
                    }
                }
            }

            // 3. 최고 점수 찾기
            int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

            // 4. 최고 점수를 받은 사람(들)을 오름차순으로 수집
            List<Integer> winners = new ArrayList<>();
            for (int s = 0; s < 3; s++) {
                if (scores[s] == max) {
                    winners.add(s + 1);  // 수포자 번호는 1,2,3
                }
            }

            // 5. 결과를 int[]로 변환하여 반환
            return winners.stream().mapToInt(Integer::intValue).toArray();
        }


    public static void main(String[] args) {
        ExhaustiveSearch exhaustiveSearch = new ExhaustiveSearch();
        long start = System.nanoTime();
        int[] answers = exhaustiveSearch.mySolution(new int[]{1, 3, 2, 4, 2});
        long end = System.nanoTime();
        System.out.println("실행 시간: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println(Arrays.toString(answers));
    }
}
