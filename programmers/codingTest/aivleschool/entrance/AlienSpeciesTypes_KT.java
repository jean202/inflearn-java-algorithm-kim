package programmers.codingTest.aivleschool.entrance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 복사해서 딴화면에 넣고 다시 분석하기
public class AlienSpeciesTypes_KT {

    public int[] solution(int n, int m) {
        int answer[] = new int[2];
        // 6 3으로 해보자 예시1
        // 12 21 예시2

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
//                int nowNumberofCase = numberOfCase.get(1)[0];
                // 6 5 4 3 2 1
                // i는 factNum - 1부터 줄어드니까, 이걸 0으로 만들려면
                // 0 1 2 3 4 5
                // i가 3인 상태에서 여기로 왔고, 그때 get(1)[0]값이 0이 아니고 1이어야 함
                // count가 몇인지 세자
                // count가 1이면
                // 비교해야 함
                // factNum - 1 - i
                if (count > beforeNumberOfCase) {
                    species = 0;
                    beforeNumberOfCase++;
                    // 3 이라는 숫자를 가진 채로
                }
                // 첫번째 for : 1 (a)
                // 두번째 for : 2 (a, b)

                // 세번째 for : 3 (a, b, c)

                species++;
                // 첫번째 for
                // 6
                // 6 * 5 / 2 = 15
                // 한 종족에 6마리 넣기 -> a종족에 6마리 넣었고 걔들끼리 15번 싸움
                // 21 - 15 = 6 만큼 싸움 남음

                // 6번싸움을 가능하게 하려면
                // b종족에 2마리 c종족에 2마리 d종족에 2마리 해서 3번 싸우도록 하거나
                // b종족에 3마리 c종족에 3마리 해서 3번 + 3번 -> 6번싸움
                // 이런 경우들이 있는데 다양하게 따져봐야 함

                // 2번째 for문 : 6마리 남았고 6번의 싸움을 b종족~~ 안에서 해야하는데
                // 그냥 i - 1 해서 5로 하면
                // 5 * 4 / 2 = 10번 싸움이라 6번의 싸움보다 커져버림
                // 이를 방지하기 위해서는 남은 마리수와 싸움수를 체크해서 처리해줘야
                int x = 0;
                // 6마리 남음 6번의 싸움
                // 1, 4를 한다음 다시 와서
                // factNum을 3을 가지고 진행하고 싶은거기 때문에 이 조건문 안으로 들어가면 안된다
                // count가 1일 경우 못들어가게 하거나
                // count가 0이 아니면서 beforeCount와 달라야 한다?
                // count는 1이고, 1과 1 같으니까
                if (remainAlien >= remainFight && count != 0 && count == beforeNumberOfCase) {
                    // 4 = getFactNum(6,6)
                    x = getFactNum(remainAlien, remainFight);
                    // 2번째 for문
                    // i는 4가 됨 : b종족에 4마리를 넣겠다는 뜻
                    i = x;
                }

//                int remainSecondForFight = 0;
//                int remainSecondForAlien = 0;
                // b종족에 4마리 넣고, 나머지종족들에 1 1
                // 그러고도 남은 싸움수는 = 6 - 6 = 0
//                remainSecondForFight = remainFight - getInFight(x);
                // 그러고도 남은 외계인 수는 = 6 - 4 = 2
//                remainSecondForAlien = remainAlien - x;
                // 그렇게 되면 가능한 최대 한종족에 몰아넣은 경우의 총 종족 종류 수는
                // 6 - 4 + 1 = 3, b4 c1 d1 -> 총 4종족

                // 핵심???
                // 첫번째 for문 i가 6일때
                // remainFight 6 = 21 - 15
                // remainAlien 6 = 12 - 6
                // 새로운 m = 6, 새로운 n = 6

                // 두번째 for문 i가 4일때
                // rf = 6 - 6 = 0
                // ra = 6 - 4 = 2
                // 새로운 m = 0, 새로운 n = 2
                remainFight = m - getInFight(i);
                remainAlien = n - i;

                m = remainFight;
                n = remainAlien;

                // 첫번째 for문 6 <= 0 이면 다시
                // 두번째 for문 rf 0 <= 0, ra 2 > 0

                // 근데 이거 말고 6 6을 b3 c3 하는 경우도 세야 해서...
                if (remainFight <= 0) {
                    if (remainAlien > 0) {
                        // 남은 외계인 수 만큼 종족 수가 추가된다.
                        // a6, b4, c1, d1
//                        species += remainAlien;
                        //

                        // [1, 4]
                        beforeNumberOfCase = nCase[0];
                        nCase[0]++;
                        nCase[1] = species;

                        numberOfCase.get(count)[0] = beforeNumberOfCase + 1;
                        numberOfCase.get(count)[1] = species + remainAlien;
                        count++;
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
//            oneSpeciesMaxFightSpecies 랑 ~~ 중에 더 작은걸 minSpecies로, 더 큰걸 maxSpecies로

        }

        // 3. 둘 중에 최소값 구하기? 아님 무조건 둘중하나는 최소값이 되었었나
        answer[0] = minSpecies;
        answer[1] = maxSpecies;
        return answer;
    }

    // 팩토리얼의 수를 찾는 메서드
    // 6 6을 넣었을때 3이 나올것으로 기대했는데 안나옴 -> 4가 나오는게 맞는가?? : 둘 다 나올수 있음
    // 단, getFactNum을 만든 의도는 더 큰 팩토리얼 넘버를 구하기 위해서 였으므로 4가 나오는게 맞음
    public int getFactNum(int n, int m) {
        int oneSpeciesMaxFight = 0;
        int factNum = 0;
        // n : 6, m : 6
        // 첫번째 for 2 oneSepciesMaxFight = 2
        // 두번째 for 3 oneSpeciesMaxFight = 3
        // 세번째 for 4 oneSpeciesMaxFight = 6
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
        AlienSpeciesTypes_KT main = new AlienSpeciesTypes_KT();
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
