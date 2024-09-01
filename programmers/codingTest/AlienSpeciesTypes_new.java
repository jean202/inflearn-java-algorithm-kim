package programmers.codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienSpeciesTypes_new {

    public int[] solution(int n, int m) {
        int answer[] = new int[2];

        int a = 0;
        int maxSpecies = Integer.MIN_VALUE;
        int minSpecies = Integer.MAX_VALUE;
        int oneSpeciesMaxFight = 0;
        int species = 0;
        int firstFight = 0;
        int secondFight = 0;
        int someFight = 0;
        int beforeJFight = 0;
        int fight = 0;
        int alien = 0;
        int spicesCount = 0;
        int count = 0;
        // index0에는 몇번째 경우의 수인지, 1에는 몇개의 종류인지
        int[] nCase = new int[2];
        List<int[]> numberOfCase = new ArrayList<>();

        // 7이 구해지겠지
        int firstSpeciesAlien = getFactNum(n, m);
        // c의 조건 기준 다시 생각해봐야  (for문만큼 돌도록 했구나)

        for (int c = 0; c < firstSpeciesAlien; c++) {
            numberOfCase.add(new int[]{0, 0});
        }

        int beforeNumberOfCase = 0;

        // 2번째, 6

        // 두번째 for문의 j가 0에 도달 했을 때 더 다른 케이스를 볼지 생각해야
        // : 그냥 무지성으로 한번 더 올려????
        // TODO case 3을 구할 때 a6 b3 c3 15 3 3 이 되어야 하는데 a6 b4를 끝내고 나서 올라온 뒤 i가 5가 되기 때문에 이게 불가능

        // i가 6일때
        for (int i = firstSpeciesAlien; i > 1; i--) {
            int remainFight = m;
            int remainAlien = n;

            // i가 6일 때 15
            // TODO 이게 21이 된 상태로 계속 유지되야 하는데 어느 시점에 15로 바뀌는지 확인 : ?? 무슨 소리지
            firstFight = getInFight(i);

            // 줄여가면서 최대 최소값 찾고 명수보다 많아지면 break
            // 7 6 5 4 3 2
            // 2번째, 6을 한 다음 또 6 5 4 3 2
            // 6 6 도 가능해야

            // TODO 7을 하고 나서 6을 따지는건데 지금 코드로는 7을 다 하고 리셋시켜서 6을 본다
            // i7 j7 상태에서 j7을 다 했을때 0이 됐으면 j6은 안따지도록 해야

            // 6, 5, 4 하다가
            for (int j = i; j >= 0; j--) {

                // TODO 필요 코드인지 확인하고 삭제
                if (remainAlien <= 0) {
                    break;
                }

                if (count > beforeNumberOfCase) {
                    species = 0;
                    beforeNumberOfCase++;
                }

                // 첫번째 종족 한다 -> a 종족에 집어넣기

                // 두번째 i for / 두번째 : b 종족 한다

                // TODO 이 코드는 지금 세는게 확실히 종류가 될 수 있는 상태로 들어가야 할것같다
                // 7로 했는데 7 6 또 따질땐 들어가면 안됨
//                spicesCount++;

                // 7 * 6 / 2 * 1 = 21
                // 두번째 i for : 6 * 5 / 2 * 1 = 15
                // TODO 지금 6 5 이런 식으로 가는데 6 6 이렇게 가게 해야 함

                // j가 4일때 secondFight가 3으로 정해짐
                secondFight = getInFight(j);

                fight = firstFight + secondFight;

                if (fight > m) {
                    beforeJFight = secondFight;
//                    j--;
                    continue;
                }

//                someFight = firstFight + beforeJFight;
                // TODO 의도대로 되는지 보기
//                fight = someFight + secondFight;

                // 0 = 21 - 21
                // 6 = 21 - 15
                remainFight = m - fight;

                if (j == 1) {
                    j = 0;
                }

                // 5 = 12 - 7
                // 6 = 12 - 6
                remainAlien = n - (i + j);

                // TODO
                // 이거 다 돌고 어떻게 되는지 확인
                // 그래야 그다음 조건문을 뭘로 둘지 결정 가능
                // 여기서 남은 싸움이 0이거나 0이하로 만들어서(근데 0보다 작아지면 일단 안쓰는 걸로 하자)
                if (remainFight == 0) {
                    spicesCount++;
                    // 6 = 1 + 5

                    species = spicesCount + remainAlien;

//                    remainAlien = n;
                    // TODO ?????
//                    fight = m;

                    // ??
                    beforeNumberOfCase = nCase[0];

                    // 첫번째 케이스, 몇개의 종족
                    nCase[0]++;
                    nCase[1] = species;
                    nCase[1] = spicesCount + remainAlien;

                    numberOfCase.get(count)[0] = beforeNumberOfCase + 1;

                    // 중복 코드, 둘 중 하나만 쓸것
                    numberOfCase.get(count)[1] = species;
                    numberOfCase.get(count)[1] = spicesCount + remainAlien;
                    count++;

                    minSpecies = Math.min(minSpecies, species);
                    maxSpecies = Math.max(maxSpecies, species);

                    // TODO 꼭 필요한 코드인지 모르겠다
                    // 이걸 안해야 remainAlien 6 remainFight 6인 상태로 다시 반복문 돌 것 같음
//                    remainAlien = n;
//                    remainFight = m;
//                    TODO 이렇게 하는게 나을거 같은데 : 뭐가 낫다는거지...? : species위에서 if문으로 보지 말고 여기서
//                    species = 0;
                    // 복원시켜서 다시 한 번 돌게 하기
                    fight = 0;

                    // i를 6으로 만들 수 있도록
                    // TODO 필수인가?
//                    break;
                }


                if (remainFight < 0) {

                    if (remainAlien > 0) {
                        // [1, 4]

                        count++;

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


                // ra 6 rf 6일때 -> 남았잖아, 그러면 다시 위로 올라가야지

                // 6
                // 6

                // case3) a6 b3 c3 = 15 + 3 + 3 ⇒ 3 이걸 고려할지 말지 고민







            // 최대값 구하기
            // 3 -> 3
            oneSpeciesMaxFight = getInFight(m);
            // 6마리 - 3 + 1 = 4 예시1
            maxSpecies = n - oneSpeciesMaxFight + 1;

            // 최소값 구하기
            // 각 종족에서 싸움이 한번씩 일어난다고 가정
            minSpecies = m;

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
//            int remainFight = m;
//            int remainAlien = n;

            // 하나씩 낮춰가면서 탐색
//            int i = factNum - 1;


            // c의 조건 기준 다시 생각해봐야  (for문만큼 돌도록 했구나)
            for (int c = 0; c < factNum; c++) {
                numberOfCase.add(new int[]{0, 0});
            }


//        int beforeNumberOfCase = 0;

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
        AlienSpeciesTypes_new main = new AlienSpeciesTypes_new();
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
