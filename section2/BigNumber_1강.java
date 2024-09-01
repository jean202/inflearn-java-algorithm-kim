package section2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//입력받은 첫번째 줄의 숫자 만큼의 길이를 가진 숫자 배열 선언
//
//    답이 될 Integer형 배열 선언
//
//    입력받은 두번째 줄의 숫자들을 int형 배열 안에 넣기
//
//    int배열의 첫번째 요소를 답 배열에 넣기
//
//    i-1과 i를 비교하는 반복문 만들기
//
//    int 배열의 길이만큼 진행
public class BigNumber_1강 {

    // 강사님 하신 거랑 같음
    public List<Integer> solution(int[] input) {
        List<Integer> answer = new ArrayList<>();
        answer.add(input[0]);
        for(int i = 1; i < input.length; i++) {
            if (input[i] > input[i-1]) {
                answer.add(input[i]);
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        BigNumber_1강 main = new BigNumber_1강();
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int listSize = sc.nextInt();
        int listSize = Integer.parseInt(br.readLine());
        int[] input = new int[listSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < input.length; i++) {
//            input[i] = sc.nextInt();
            input[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = main.solution(input);
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }

    public List<Integer> review(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] < arr[i]) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }

}
