package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridPeak {

    public int solution(int[][] input){
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                int nx = 0;
                int ny = 0;
                boolean isPeak = true;
                for (int k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if (nx < 0 || nx >= input.length || ny <0 || ny >= input.length) {
                        continue;
                    }
                    if (input[nx][ny] >= input[i][j]) {
                        isPeak = false;
                        break;
                    }
                }
                if (isPeak) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        GridPeak main = new GridPeak();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberSize = Integer.parseInt(br.readLine());
        int[][] input = new int[numberSize][numberSize];

        for (int i = 0; i < numberSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numberSize; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
