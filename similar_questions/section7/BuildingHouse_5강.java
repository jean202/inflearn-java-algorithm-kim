package similar_questions.section7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildingHouse_5강 {

    // TODO 복붙코드임. 꼭 다시 해보기
    private int solution(List<int[]> mapInfo) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = mapInfo.size();
        int[][] dist = new int[n][n];
        Queue<int[]> Q = new LinkedList<>();
        int emptyLand = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mapInfo.get(i)[j] == 1){
                    answer = Integer.MAX_VALUE;
                    Q.offer(new int[]{i, j});
                    int L = 0;
                    while(!Q.isEmpty()){
                        L++;
                        int len = Q.size();
                        for(int r = 0; r < len; r++){
                            int[] cur = Q.poll();
                            for(int k = 0; k < 4; k++){
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && mapInfo.get(nx)[ny] == emptyLand){
                                    mapInfo.get(nx)[ny]--;
                                    dist[nx][ny] += L;
                                    Q.offer(new int[]{nx, ny});
                                    answer = Math.min(answer, dist[nx][ny]);
                                }
                            }
                        }
                    }
                    emptyLand--;
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) throws IOException {
        BuildingHouse_5강 main = new BuildingHouse_5강();
        List<int[]> mapInfo = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";

        while((str = br.readLine()) != null && !str.isEmpty()) {
            String[] lineS = str.split(" ");
            int[] line = new int[lineS.length];
            for (int i = 0; i < line.length; i++) {
                line[i] = Integer.parseInt(lineS[i]);
            }
            mapInfo.add(line);
        }
        int answer = main.solution(mapInfo);
        bf.write(String.valueOf(answer));
        bf.write("");
        bf.flush();
    }
}
