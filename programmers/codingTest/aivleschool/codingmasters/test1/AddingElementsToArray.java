package programmers.codingTest.aivleschool.codingmasters.test1;

import java.util.HashMap;
import java.util.Map;

public class AddingElementsToArray {
    /* 초안
        // 2, 5
        // 2가 기존에 있는지 검사
        int[] findThings = map.getOrDefault(2, new int[]{0, 0});
        // 있으면
        int 늘어난원소개수 = findThings[1] + 7;
        int 차지해야할공간 = nextPowerByLog(늘어난원소개수);
        if (차지해야할공간 > findThings[0]) {
            int 새차지공간 = nextPowerByLog(늘어난원소개수);
            map.put(queries[0][0], new int[]{새차지공간, 늘어난원소개수});
            answer = answer + findThings[1];
        }
 */
//[[2, 10], [7, 1], [2, 5], [2, 9], ...]
    public static int solution(int[][] queries) {
        int answer = 0;
        // 2 : {0, 0}
        // 2 : {16, 10}
        // 해당 값, 차지하고 있는 공간, 그 안 원소의 수
        // 값 : {차지하고 있는 공간: 그 안 원소의 수}

        Map<Integer, int[]> map = new HashMap<>();
//        특정 값보다 큰 가장 작은 2의 거듭제곱값 구하는 두가지 방법

        // 1. 로그 함수 사용
        // 처음 2 : [16, 10]
        // 두번째 7 :  [1, 1]
        // 세번째 2 : [16, 15]
        for (int[] query : queries) {
            int[] findExists = map.get(query[0]);
            if (findExists == null) {
                map.put(query[0], new int[]{nextPowerByLog(query[1]), query[1]});
            } else {
                // 늘어난 원소 개수
                int expandValueCount = findExists[1] + query[1];
                // 새로 차지해야 할 공간
                int newSpaceCount = nextPowerByLog(expandValueCount);
                if (newSpaceCount > findExists[0]) {
                    map.put(query[0], new int[]{newSpaceCount, expandValueCount});
                    answer += findExists[1];
                } else {
                    // 2, 16, 15
                    map.put(query[0], new int[]{findExists[0], expandValueCount});
                }
            }
        }

        /*
        // 2. 비트 연산
        for (int[] query : queries) {
            int[] findExists = map.get(query[0]);
            if (findExists == null) {
                map.put(query[0], new int[]{nextPowerByBit(query[1]), query[1]});
            } else {
                // 늘어난 원소 개수
                int expandValueCount = findExists[1] + query[1];
                // 새로 차지해야 할 공간
                int newSpaceCount = nextPowerByBit(expandValueCount);
                if (newSpaceCount > findExists[0]) {
                    map.put(query[0], new int[]{newSpaceCount, expandValueCount});
                    answer += findExists[1];
                } else {
                    // 2, 16, 15
                    map.put(query[0], new int[]{findExists[0], expandValueCount});
                }
            }
        }
         */

        // getOrDefault활용
        for (int[] query : queries) {
            int[] findExists = map.getOrDefault(query[0], new int[]{0, 0});
//            int currentSpaceCount = findExists[0];
//            int currentValueCount = findExists[1];
            // 늘어난 원소 개수
            // 0
            // 16, 10
            // [2, 5]
            // 15
            int expandValueCount = findExists[1] + query[1];
            // 새로 차지해야 할 공간
            // 16
            int newSpaceCount = nextPowerByBit(expandValueCount);
            if (newSpaceCount > findExists[0]) {
                map.put(query[0], new int[]{newSpaceCount, expandValueCount});
                answer += findExists[1];
            } else {
                // 2, 16, 15
                map.put(query[0], new int[]{findExists[0], expandValueCount});
            }
        }
        return answer;
}

// 1. 로그 함수 사용
public static int nextPowerByLog(int n) {
    double nextNum = Math.ceil(Math.log(n) / Math.log(2));
    return (int) Math.pow(2, nextNum);
}

// 2. 비트 연산
public static int nextPowerByBit(int n) {
    int bit = 1;
    // 1 = 1, 2의 0거듭제곱
    // 10 = 2, 2의 1거듭제곱
    // 100 = 4, 2의 2거듭제곱
    // 1000 = 8, 2의 3거듭제곱

    // 1 <= 7
    // 4 <= 7
    // 8 > 7
    while (bit <= n) {
        bit = bit << 1;
    }
    return bit;
}


public static void main(String[] args) {
    int[][] queries1 = {{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}};
    System.out.println(solution(queries1)); // Output: 16

    int[][] queries2 = {{1, 1}, {1, 2}, {1, 4}, {1, 8}};
    System.out.println(solution(queries2)); // Output: 11
}
}
