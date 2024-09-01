package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Body implements Comparable<Body> {
    public int h;
    public int w;

    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}
public class Wrestler {

    private int solution(ArrayList<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for (Body body : arr) {
            if (body.w > max) {
                max = body.w;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Wrestler main = new Wrestler();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer hw = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(hw.nextToken());
            int w = Integer.parseInt(hw.nextToken());
            arr.add(new Body(h, w));
        }
        int answer = main.solution(arr, n);
        System.out.println(answer);
    }

}
