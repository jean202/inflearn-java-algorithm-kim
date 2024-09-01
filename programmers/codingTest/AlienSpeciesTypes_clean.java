package programmers.codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienSpeciesTypes_clean {

    public int[] solution(int n, int m) {
        int answer[] = new int[2];

        int a = 0;
        int maxSpecies = Integer.MIN_VALUE;
        int minSpecies = Integer.MAX_VALUE;
        int oneSpeciesMaxFight = 0;

        // 0. if else문으로 마리수가 더 많은지 싸움이 더 많은지 체크
        // 마리수 > 싸움수
        if (n > m) {
            // 최대값 구하기
            // 3 -> 3
            oneSpeciesMaxFight = getInFight(m);
            // 6마리 - 3 + 1 = 4 예시1
            maxSpecies = n - oneSpeciesMaxFight + 1;

            // 최소값 구하기
            // 각 종족에서 싸움이 한번씩 일어난다고 가정
            minSpecies = m;
        } else { // 마리수 < 싸움수
            // 1) 한 종족에 싸울애들 다 몰아넣고 나머지 종족에는 한마리씩만 넣기
            int factNum = getFactNum(n, m);
            int oneSpeciesMaxFightSpecies = 0;

            // 21 = getInfignt(7)
            oneSpeciesMaxFight = getInFight(factNum);
            if (oneSpeciesMaxFight == m) {
                // (12 - 7) + 1 = 6
                oneSpeciesMaxFightSpecies = n - factNum + 1;
            }

            // 이 값은 numberofcase리스트에 안들어가도 되나?

            minSpecies = Math.min(minSpecies, oneSpeciesMaxFightSpecies);
            maxSpecies = Math.max(maxSpecies, oneSpeciesMaxFightSpecies);

            // 2) 다양한 경우의 수 구하기
            // 21번 싸우는데 최소가 되려면 -> 싸움수를 분산시켜야
            int remainFight = m;
            int remainAlien = n;

            // 하나씩 낮춰가면서 탐색
            int i = factNum - 1;
            int species = 0;
            // index0에는 몇번째 경우의 수인지, 1에는 몇개의 종류인지
            int[] nCase = new int[2];
            List<int[]> numberOfCase = new ArrayList<>();
            int count = 0;


            // c의 조건 기준 다시 생각해봐야  (for문만큼 돌도록 했구나)
            for (int c = 0; c < factNum; c++) {
                numberOfCase.add(new int[]{0, 0});
            }

            int beforeNumberOfCase = 0;
            for (; i > 1; i--) {
                if (count > beforeNumberOfCase) {
                    species = 0;
                    beforeNumberOfCase++;
                }

                species++;

                int x = 0;
                // count1인 상태로 여기 오면 rf6 ra1이고 이제 3 3 요렇게 따져야 한다
                if (remainAlien >= remainFight && count == beforeNumberOfCase) {
                    // 근데 이대로 하면 계속 x를 4로만 반환하지 3이 안나옴
                    // 3을 나오게 하려면?? 맨 위 for문으로 돌아가서 -1 하게 해야 한다
                    int tmp = 0;
                    tmp = i;

                    x = getFactNum(remainAlien, remainFight);
                    i = x;

                    // 3일 경우 안하게 하도록 if문에 넣어야 하고
                    if (count == 1) {
                        i = tmp;
                    }
                }

                // 3이 여기서 계산되겠지
                remainFight = m - getInFight(i);
                remainAlien = n - i;

                m = remainFight;
                n = remainAlien;

                if (remainFight <= 0) {
                    if (remainAlien > 0) {
                        // [1, 4]
                        beforeNumberOfCase = nCase[0];
                        nCase[0]++;
                        nCase[1] = species + remainAlien;

                        numberOfCase.get(count)[0] = beforeNumberOfCase + 1;
                        numberOfCase.get(count)[1] = species + remainAlien;
                        count++;
                        // TODO
                        // remainAlien > 0 이 조건에서만 1, 4를 만들고 집어넣게 하고
                        // remainAlien이 -가 되도 문제는 풀 수 있는 거니까 그다음 처리해서 case로 넣어줄 수 있도록 하기
                        // case 무뭐 있었는지 노션 가서 보면서 다 따져보기
                        remainAlien = m + getInFight(i);
                        remainFight = n + i;
//                        beforeNumberOfCase = nCase[0]--;

                        minSpecies = Math.min(minSpecies, species);
                        maxSpecies = Math.max(maxSpecies, species);
                    }
                }
            }
            minSpecies = Math.min(oneSpeciesMaxFightSpecies, species);
            maxSpecies = Math.max(oneSpeciesMaxFightSpecies, species);

        }

        // 3. 둘 중에 최소값 구하기? 아님 무조건 둘중하나는 최소값이 되었었나
        answer[0] = minSpecies;
        answer[1] = maxSpecies;
        return answer;
    }

    public int getFactNum(int n, int m) {
        int oneSpeciesMaxFight = 0;
        int factNum = 0;

        for (int i = 2; i < n; i++) {
            oneSpeciesMaxFight = getInFight(i);
            if (oneSpeciesMaxFight > m) {
                factNum = i - 1;
                break;
            }
        }
        return factNum;
    }

    public int getInFight(int n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) throws IOException {
        AlienSpeciesTypes_clean main = new AlienSpeciesTypes_clean();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] answer = main.solution(n, m);
        bf.write(Arrays.toString(answer));
        bf.write("");
        bf.flush();
    }
}
