package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class TimeAndState implements Comparable<TimeAndState> {
    public int time;
    public char state;

    TimeAndState(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(TimeAndState o) {
        if (this.time == o.time) {
            return this.state - o.state;
        } else {
            return this.time - o.time;
        }
    }
}
public class WeddingHall {

    private int solution(ArrayList<TimeAndState> arr) {
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(arr);
        for (TimeAndState ts : arr) {
            if (ts.state == 'e') {
                cnt--;
            } else {
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        WeddingHall main = new WeddingHall();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<TimeAndState> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer se = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(se.nextToken());
            int e = Integer.parseInt(se.nextToken());
            arr.add(new TimeAndState(s, 's'));
            arr.add(new TimeAndState(e, 'e'));
        }
        int answer = main.solution(arr);
        System.out.println(answer);
    }
}
