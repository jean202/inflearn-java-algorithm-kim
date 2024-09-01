package similar_questions.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeedingFlower_5강 {

    private int solution(int[] plantTime, int[] growTime) {
        int answer = 0;
        int n = plantTime.length;
        int[][] list = new int[n][2];
        for(int i = 0; i < n; i++){
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }
        Arrays.sort(list, (a, b) -> b[1] - a[1]);
        int start = 0, end = 0;
        for(int[] x : list){
            end = start + x[0] + x[1];
            answer = Math.max(answer, end);
            // 자라는 꽃씨 기준 오름차순으로 정렬했기 때문에
            start += x[0];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        SeedingFlower_5강 main = new SeedingFlower_5강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] plantTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] growTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(main.solution(plantTime, growTime));
    }
}
