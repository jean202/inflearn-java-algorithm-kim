package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
    public int pay;
    public int dayLimit;
    Lecture(int pay, int dayLimit) {
        this.pay = pay;
        this.dayLimit = dayLimit;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.dayLimit - this.dayLimit;
    }
}

public class MaximumIncomeSchedule {

    static int n;
    static int max = Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        // 저장하고 꺼내올 때 큰 값을 우선으로 한다
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j = 0;
        for(int i = max; i >=1; i--) {
            for(; j < n; j++) {
                if(arr.get(j).dayLimit < i) {
                    break;
                }
                pQ.offer(arr.get(j).pay);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        MaximumIncomeSchedule main = new MaximumIncomeSchedule();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer md = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(md.nextToken());
            int d = Integer.parseInt(md.nextToken());
            arr.add(new Lecture(m, d));
            if (d > max) {
                max = d;
            }
        }
        int answer = main.solution(arr);
        System.out.println(answer);
    }
}
