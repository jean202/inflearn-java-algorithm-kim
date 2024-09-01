package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//5 6 8 12 14
//
//    5(3) 8(4) 12
//    5~14 사이에서만 찾으려고 하면, 답은 3인데 답을 찾지 못한다
//
//    ep => 바로 전에 말을 배치한 마구간
//
//    지금 정한 거리로 배치할 수 있는 말의 마리수를 리턴하는 메서드
//    : C보다 크거나 같은 값이어야 함
//    마리수를 리턴받았는데 C보다 작으면 거리를 줄여야 하는것, 정답이 될수 없음
//    C보다 크면 거리를 늘려야 하는것, 정답이 될 수 있을수도 있고 없을수도 있음 (1 1 5 이런식으로 남게 해서 배치할수도 있으므로, 어쨌든 C를 수용할수 있음, 그런데 마구간 좌표랑 다를수도 있어서 답이 안될수도 있음)

public class StableDecision {

    public int horseCount(int[] input, int distance) {
        int cnt = 1;
        int ep = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] - ep >= distance) {
                ep = input[i];
                cnt++;
            }
        }
        return cnt;
    }
    //1 2 4 8 9
    private int solution(int[] input, int n, int c) {
        int answer = 0;
        Arrays.sort(input);
        int lt = input[1] - input[0];
        int rt = input[n - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (horseCount(input, mid) >= c) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        StableDecision main = new StableDecision();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int c = Integer.parseInt(nm.nextToken());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int answer = main.solution(input, n, c);
        System.out.println(answer);
    }



}
