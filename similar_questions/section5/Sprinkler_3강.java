package similar_questions.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sprinkler_3강 {

    private int solution(int n, int[] nums) {
        int[][] line = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            line[i][0] = i - nums[i];
            if (line[i][0] < 0) {
                line[i][0] = 0;
            }
            line[i][1] = i + nums[i];
            if (line[i][1] > n + 1) {
                line[i][1] = n;
            }
        }
        Arrays.sort(line, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int s = 0, e = 0, answer = 0;
        s = line[0][0];
        e = line[0][1];
        for (int i = 1; i < n + 1; i++) {
            if (s < line[i][0]) {
                answer++;
                s = e;
            }
            if (e == n) {
                return answer;
            }
            if (s >= line[i][0])   {
                if (e < line[i][1]) {
                    e = line[i][1];
                }
            }
        }
        if (s == e) {
            return -1;
        }
        return 0;
    }

    private int Tsolution(int n, int[] nums) {
        int answer = 0;
        int[][] line = new int[nums.length + 1][2];
        for(int i = 0; i <= n; i++){
            line[i][0] = Math.max(0, i - nums[i]);
            line[i][1] = Math.min(n, i + nums[i]);
        }
        Arrays.sort(line, (a, b) -> a[0] - b[0]);
        int start = 0, end = 0, i = 0;
        while(i < line.length){
            while(i < line.length && line[i][0] <= start){
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++;
            if(end == n) return answer;
            if(start == end) return -1;
            start = end;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Sprinkler_3강 main = new Sprinkler_3강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution(n, nums));
    }

}
