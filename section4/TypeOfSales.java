package section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TypeOfSales {

    /*
        Set을 사용해 사이즈로 풀어낸 방식
     */
    // 시간 복잡도가 O((n-k+1) * k)로 큰 입력에 대해서는 효율적이지 않음
    // 문제에서 N의 값이 최대 100,000
    private int[] solution(int n, int k, int[] input) {
        int[] answer = new int[n - k + 1];

        Map<String, Set<Integer>> sets = new HashMap<>();

//        7 5
//        20 12 20 10 23 17 10

        // 20   10 23
        // 2    1  1

        // 7 - 5 + 1

        // 20 12 20 10 23
        // 12 20 10 23 17
        // 20 10 23 17 10

        // 0 1 2 3
        // 0 ~ 7 - 4 + 1 전까지

        for (int i = 0; i < n - k + 1; i++) {
            Set<Integer> set = new HashSet<>();
            sets.put("set" + i, set);
        }

        for (int i = 0; i < n - k + 1; i++) {
            Set<Integer> set = sets.get("set" + i);
            for (int j = i; j < k + i; j++) {
                set.add(input[j]);
            }
            answer[i] = set.size();
        }
        return answer;
    }

    /*
        슬라이딩 윈도우 기법과 HashSet을 사용하여 각 구간 내의 고유한 판매 유형을 추적
     */
//    7 4

//    20 12 20 10 23 17 10

    private int[] gptSolution(int n, int k, int[] input) {

        int[] answer = new int[n - k + 1];

        Set<Integer> salesSet = new HashSet<>();

//        사이즈 체크, answer[0]에 넣기
        for (int i = 0; i < k; i++) {
            salesSet.add(input[i]);
        }
        answer[0] = salesSet.size();

        // 주의할 것, 익숙해질 것, 혼자 짜볼 것
        // 4 - 4 = 0
        // 7 - 4 = 3

//        20 10
//        365 50 50 150 60 150 154 215 150 315 293 226 408 11 344 199 313 82 394 304
        for (int i = k; i < n; i++) {
            // 150 60 
            // 이제 봐야 하는 범위에 없는지 어떻게 따질것인가?
            // 아.. 그냥 인강볼까 ㅋㅋㅋㅋ

            List<Integer> checkList
                = Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList());

            List<Integer> targetList = new ArrayList<>();

            targetList.add(input[i - k + 1]);
            targetList.add(input[i - k + 2]);
            targetList.add(input[i - k + 3]);
            targetList.add(input[i - k + 4]);
            // ... 이걸 k만큼 하면 너무 많아진다

            checkList.remove(0);

            if (canRemove(input, input[i - k])) {
                salesSet.remove(input[i - k]);
            }
            salesSet.add(input[i]);
            answer[i - k + 1] = salesSet.size();
        }

        return answer;
    }

    //        input[3]~
    private boolean canRemove(int[] input, int target) {
        boolean canRemove = false;
        if (existCount(input, target) == 1) {
            return true;
        }
        if (existCount(input, target) > 1) {
            // 여기를 어떻게 처리해야 할지 모르겠다.. 인강 보자
        }
        return canRemove;
    }

    // 무작정 여러개인지 세는게 아니고 현재 슬라이딩 도어에 존재 해야 하는지 아닌지를 따져야
    private int existCount(int[] array, int target) {
        int existCount = 0;
        for (int num : array) {
            if (num == target) {
                existCount++;
            }
        }
        return existCount;
    }

    // gpt에게 사기당한 코드


    
//               20 4
//               365 50 50 150 60 150 154 215 150 315 293 226 408 11 344 199 313 82 394 304
    private int[] getSalesType(int n, int k, int[] sales) {
        int[] result = new int[n - k + 1];
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < k; i++) {
            window.add(sales[i]);
        }
        result[0] = window.size();
        for (int i = k; i < n; i++) {
            window.remove(sales[i - k]); // Remove the first
            window.add(sales[i]); // Add the current element to the current window
            result[i - k + 1] = window.size();
        }
        return result;
    }

//    7 4     n k
//    20 12 20 10 23 17 10
   // 20  0
    // 12 1
    // 10 1
    private List<Integer> teacherSolution(int n, int k, int[] input) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0  ; i < k; i++) {
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }
        answer.add(map.size());
        int rt = k;
        for (int lt = 0; lt < n - k; lt++) {
            map.put(input[lt], map.get(input[lt]) - 1);
            if (map.get(input[lt]) == 0) {
                map.remove(input[lt]);
            }
            map.put(input[rt], map.getOrDefault(input[rt], 0) + 1);
            rt++;
            answer.add(map.size());
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        TypeOfSales main = new TypeOfSales();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nk.nextToken());
        int k = Integer.parseInt(nk.nextToken());

        int[] input = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

//        int[] answer = main.getSalesType(n, k, input);
//        int[] answer = main.gptSolution(n, k, input);
        List<Integer> answer = main.teacherSolution(n, k, input);
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }
}
