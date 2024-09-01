package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    public int s;
    public int e;

    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (this.e == o.e) {
            return this.s - o.s;
        } else {
            return this.e - o.e;
        }
    }
}
public class MeetingroomAssignment {

    private int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int endTime = 0;
        for (Time time : arr) {
            if (time.s >= endTime) {
                cnt++;
                endTime = time.e;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        MeetingroomAssignment main = new MeetingroomAssignment();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer se = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(se.nextToken());
            int e = Integer.parseInt(se.nextToken());
            arr.add(new Time(s, e));
        }
        int answer = main.solution(arr, n);
        System.out.println(answer);
    }
}
