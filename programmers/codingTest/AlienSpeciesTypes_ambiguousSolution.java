package programmers.codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienSpeciesTypes_ambiguousSolution {

    public int[] solution(int n, int m) {
        int answer[] = new int[2];

        int maxSpecies = Integer.MIN_VALUE;
        int minSpecies = Integer.MAX_VALUE;
        int species = 0;
        int firstFight = 0;
        int secondFight = 0;
        int fight = 0;
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
        for (int i = firstSpeciesAlien; i > 1; i--) {
            int remainFight = m;
            int remainAlien = n;

            firstFight = getInFight(i);

            // while문으로 고치는거 생각해보기
            for (int j = i; j >= 0; j--) {

                // TODO 필요 코드인지 확인하고 삭제
                if (remainAlien <= 0) {
                    break;
                }

                if (count > beforeNumberOfCase) {
                    species = 0;
                    beforeNumberOfCase++;
                }

                secondFight = getInFight(j);

                fight = firstFight + secondFight;

                if (fight > m) {
                    continue;
                }

                remainFight = m - fight;

                if (j == 1) {
                    j = 0;
                }

                remainAlien = n - (i + j);

                if (remainFight == 0) {
                    spicesCount++;

                    species = spicesCount + remainAlien;

                    beforeNumberOfCase = nCase[0];

                    nCase[0]++;
                    nCase[1] = species;
                    nCase[1] = spicesCount + remainAlien;

                    numberOfCase.get(count)[0] = beforeNumberOfCase + 1;
                    numberOfCase.get(count)[1] = species;
                    count++;

                    minSpecies = Math.min(minSpecies, species);
                    maxSpecies = Math.max(maxSpecies, species);

                    // TODO 꼭 필요한 코드인지 모르겠다
//                    remainAlien = n;
//                    remainFight = m;

//                    TODO 이렇게 하는게 나을거 같은데 : 뭐가 낫다는거지...? : species위에서 if문으로 보지 말고 여기서
//                    species = 0;
                    fight = 0;

                }
            }
        }

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
        AlienSpeciesTypes_ambiguousSolution main = new AlienSpeciesTypes_ambiguousSolution();
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
