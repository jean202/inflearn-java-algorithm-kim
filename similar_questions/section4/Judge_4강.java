package similar_questions.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Judge_4강 {

    private int mySolution(int[] input, int k) {
        int answer = 0;
        Arrays.sort(input);

        int sum = 0;

        for (int i = 0; i < input.length - k + 1; i++) {

            //        int[] window = new int[k];
            // 슬라이딩 윈도우 만들기 : 숫자를 k개 만큼 만든다 -> k개의 숫자를 갖는 배열을 만든다
            // => 배열을 만들 필요 없음, 주어진 배열 내에서 이동하면서 무헝의 슬라이딩 윈도우를 만들면 됨

            if ((input[i + k - 1] - input[i]) <= 10) {

                for (int j = i; j < k; j++) {
                    sum += input[j];
                }
                answer = (int) Math.floor(sum / k);
            }
        }
        return answer;
    }

    public int getAve(int[] score, int s, int e){
        int sum = 0;
        for(int i = s; i <= e; i++){
            sum += score[i];
        }
        return (int) Math.floor((sum / (e - s + 1)));
    }

    private int solution(int[] input, int k) {
        int n = input.length;
        Arrays.sort(input);
        for(int i = 0; i < n - k + 1; i++){
            if(input[i + k - 1] - input[i] <= 10)
                return getAve(input, i, i + k - 1);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Judge_4강 main = new Judge_4강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(br.readLine());
        System.out.println(main.mySolution(input, k));
    }

}
