package similar_questions.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class MinimumAirfare_1강 {

    public int solution(int n, List<List<int[]>> list, int s, int e, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});
        int level = 0;
        // todo 내가 짤 때 빠뜨렸던 부분
        costs[s] = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();

            // 큐 길이 1만큼만 동작
            for (int i = 0; i < length; i++) {

                // queue 내용 : 도시, 레벨을 거치면서 계산된 해당 도시까지 최소비용
                // [0, 0] / [1, 0]
                int[] poll = queue.poll();
                int nowCity = poll[0];
                int nowCost = poll[1];

                // list 내용 : 인덱스에 해당되는 도시로부터 특정 도시까지 가는데 드는 비용
                // 0에서 {[1, 10], [3, 100], [2, 70]}
                List<int[]> destinationCitytoCost = list.get(nowCity);

                // 3번 동작
                for (int j = 0; j < destinationCitytoCost.size(); j++) {

                    // destinationCitytoCost.get(i) : [1, 10]
                    int destinationCity = destinationCitytoCost.get(j)[0];
                    int toCost = destinationCitytoCost.get(j)[1];

                    // todo 내가 짤 때 빠뜨렸던 부분
                    // 0에서 출발해서 1까지 가는데 0 + 10 해서 10 들었다.
                    int totalCost = nowCost + toCost;

                    if (totalCost < costs[destinationCity]) {
                        costs[destinationCity] = totalCost;
                        queue.offer(new int[] {destinationCity, totalCost});
                    }
                }
            }
            // 도착 도시의 레벨값
            level++;
            // level 1만큼의 값은 이동 한번을 의미, 1번 이동 -> 0번 환승, 2번 이동 -> 1번 환승
            // todo 이거 >= 이어야 하지 않을지? : 아니다! if (level == k + 1) 이랑 같은거고, level값이 올라가고 있기 때문에 level > k 로 표현 가능
            if (level > k) {
//                return costs[e];
                // break를 해 주는 이유는 답은 나왔는데 불필요한 계산을 막기 위해서가 아니고 환승 기회가 끝났기 때문에
                break;
            }
        }
        if (costs[e] != Integer.MAX_VALUE) {
            return costs[e];
        } else {
            return -1;
        }
    }

    // todo 지난 그래프 관련 강의들은 어떻게 초기화 했는지 : 정해진 크기만큼 인덱스로 가져올 수 있게 반복문으로 빈객체 생성해 붙여 놓기
    public static void main(String[] args) throws IOException {
        MinimumAirfare_1강 main = new MinimumAirfare_1강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<List<int[]>> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        while (st.hasMoreTokens()) {
//            main에서 처리하려고 했을 때
//            int[] arr = new int[3];
//            for (int i = 0; i < 3; i++) {
//                arr[i] = Integer.parseInt(st.nextToken());
//            }
//            list.add(arr);

                int index = Integer.parseInt(st.nextToken());
                int[] tmp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                list.get(index).add(tmp);

        }

        int s = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int answer = main.solution(n, list, s, e, k);

        System.out.println(answer);
    }
}
