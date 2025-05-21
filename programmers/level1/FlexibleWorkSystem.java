package programmers.level1;

public class FlexibleWorkSystem {

    public int mySolution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int people = schedules.length;
        for (int i = 0; i < people; i++) {
            boolean prize = true;
            for (int j = 0; j < 7; j++) {
                if (startday == 7) {
                    if (j == 0 || j == 6) {
                        continue;
                    }

                } else {
                    if (j == (6 - startday) || j == (7 - startday)) {
                        continue;
                    }
                }
                if (schedules[i] + 10 < timelogs[i][j]) {
                    prize = false;
                    break;
                }

            }
            if (prize) {
                answer++;
            }
        }
        return answer;
    }

    public int gptSolution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            // 1) 희망 시각을 총 분으로 바꿔서 +10분
            int sh = schedules[i] / 100;
            int sm = schedules[i] % 100;
            int allowedMin = sh * 60 + sm + 10;

            boolean prize = true;
            for (int j = 0; j < 7; j++) {
                // 2) j=0은 startday, j=1은 다음날, …, j=6은 마지막날
                int weekday = (startday + j - 1) % 7 + 1;  // 1=월 … 7=일
                if (weekday == 6 || weekday == 7)
                    continue;  // 토·일 제외

                // 3) 실제 출근 시각도 총 분으로
                int t = timelogs[i][j];
                int th = t / 100;
                int tm = t % 100;
                int tMin = th * 60 + tm;

                // 4) 허용 시각 초과하면 불합격
                if (tMin > allowedMin) {
                    prize = false;
                    break;
                }
            }
            if (prize) {
                answer++;
            }
        }
        return answer;
    }

}
