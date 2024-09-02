package similar_questions.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CPUscheduling_5강 {

    public int[] solution(List<int[]> list){
        int n = list.size();
        int[] answer = new int[n];
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++){
            programs.add(new int[]{list.get(i)[0], list.get(i)[1], i});
        }
        programs.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] -
            b[0]);
        int fT = 0, idx = 0;
        while(!programs.isEmpty() || !pq.isEmpty()){
            if(pq.isEmpty()) fT = Math.max(fT, programs.peek()[0]);
            while(!programs.isEmpty() && programs.peek()[0] <= fT){
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] ex = pq.poll();
            fT = fT + ex[0];
            answer[idx++] = ex[1];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        CPUscheduling_5강 main = new CPUscheduling_5강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();

        String input = "";
        while(!(input = br.readLine()).equals("")) {
            String work[] = input.split(" ");
            int[] arr = new int[work.length];
            for (int i = 0; i < work.length; i++) {
                arr[i] = Integer.parseInt(work[i]);
            }
            list.add(arr);
        }

        int[] answer = main.solution(list);
        System.out.println(Arrays.toString(answer));
    }
}
