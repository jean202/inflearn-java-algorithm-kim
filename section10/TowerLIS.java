package section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Brick implements Comparable<Brick> {
    public int s, h, w;
    Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}

public class TowerLIS {

    static int[] dy;

    public int solution(ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        answer = dy[0];
        for(int i = 1; i < arr.size(); i++) {
            int max_h = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        TowerLIS main = new TowerLIS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Brick> arr = new ArrayList<Brick>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Brick(s, h, w));
        }
        int answer = main.solution(arr);
        System.out.println(answer);
    }
}
