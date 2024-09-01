package similar_questions.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dermatology_4강 {

    private int solution(int[] laser, List<int[]> arr) {

        // 고객이 도착한 시간
        int arriveTime = arr.get(0)[0];

//        int arriveTime = time + laser[arr.get(0)[1]];
        int answer = 0;

        // 피부과의 대기실
        Queue<Integer> Q = new LinkedList<>();
        // 첫번째 레이저 번호 입력
        Q.offer(arr.get(0)[1]);
        int pos = 1;

        // 623
        for (int t = arriveTime; t < 1200; t++) {

//            int end = arr.get(arr.size() - 1)[0];

            // 1.
            // 대기실에 넣어주기
            // 입력값 끝까지 갔는지 && 입력값에 있는 애의 입장 시간이 지금 시간과 같은게 있는지(대기실 들어갈 애 있는지)
            if(pos < arr.size() && t == arr.get(pos)[0]){

                // 대기실로 들어오자마자 레이저실로 들어갈 수 있도록
                // 다음 고객의 도착시간(이자 현재시간t)이 지금 설정된 finishTime보다 크면 도착을 했고 진료실이 비어 있는데 2를 못해준다.
                // t : 910, fT : 708
                if (Q.isEmpty() && t > arriveTime) {
                    arriveTime = arr.get(pos)[0];
//                    arriveTime = t; 와 같다.
                }
                Q.offer(arr.get(pos)[1]);
                pos++;
            }

            // 2.
            // 진료실에 넣어주기
            // 진료실이 비었는지 확인 && 대기실에 사람 있는지 확인
            // t : 910, fT : 910
            if (t == arriveTime && !Q.isEmpty()){
                int idx = Q.poll();
                // 방금 진료실에 넣은 사람이 끝나는 시간 업데이트
                arriveTime += laser[idx];
            }
                answer = Math.max(answer, Q.size());
//            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Dermatology_4강 main = new Dermatology_4강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] laserS = br.readLine().split(" ");
        int[] laser = new int[laserS.length];
        for (int i = 0; i < laser.length; i++) {
            laser[i] = Integer.parseInt(laserS[i]);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> arr = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int[] inArr = new int[2];
            String[] inArrS = st.nextToken().split(" ");
            String[] inArrT = inArrS[0].split(":");
            inArrT[0] = inArrT[0].substring(1);
            inArr[0] = Integer.parseInt(inArrT[0]) * 60 + Integer.parseInt(inArrT[1]);
            inArr[1] = Integer.parseInt(st.nextToken().substring(0, 1));
            arr.add(inArr);
        }
        int answer = main.solution(laser, arr);
        System.out.println(answer);
    }
}
