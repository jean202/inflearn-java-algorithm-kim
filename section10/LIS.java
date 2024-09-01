package section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {

    static int[] dy;

    public int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--){
                // 현재 숫자 앞에 있는 숫자들을 탐색하면서 최대길이값 찾기
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
                // 앞 숫자 중의 최대길이에 1을 더해서 현재 숫자의 최대길이를 구함
                dy[i] = max + 1;
                // 최대길이값 배열 중 가장 큰 값으로 answer를 업데이트
                answer = Math.max(answer, dy[i]);
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        LIS main = new LIS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = main.solution(arr);
        System.out.println(answer);
    }
}
