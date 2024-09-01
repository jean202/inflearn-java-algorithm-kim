package section2;

import java.util.Scanner;

public class SieveofEratosthenes {

    // 소수란 : 자기 자신과 1 외에 다른 수로 나뉘어지지 않는 수
    // 특정 수 나누기 2의 배수 3의 배수 4의 배수 5의 배수 6의 배수 ... input의 배수 == 0이면 제외
    // 이게 아니면 추가

    public int mySolution(int input) {
        int answer = 1;

        for (int i = 3; i <= input; i++) {
            boolean divded = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    divded = true;
                    break;
                }
            }
            if (!divded) {
                answer++;
            }
        }
        return answer;
    }

    public int solution(int input) {
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
        int[] inputList = new int[input];
        int answer = 0;
        /*
        inputList[1 + 2*0]++;
        inputList[1 + 2*1]++;
        inputList[1 + 2*2]++;
        inputList[1 + 2*3]++;
        inputList[1 + 2*4]++;
            ...
        inputList[1 + 2*n < input]++;

        for(int j = 0; 1 + (2 * j) < input; j++) {
            inputList[1 + (2 * j)]++;
        }

        inputList[2 + 3*0]++;
        inputList[2 + 3*1]++;
            ...
        inputList[2 + 3*n < input]++;

        for(int j = 0; 2 + (3 * j) < input; j++) {
            inputList[2 + (3 * j)]++;
        }

        inputList[3 + 4*0]++;
        inputList[3 + 4*1]++;
            ...
        inputList[3 + 4*n < input]++;

        for(int j = 0; 3 + (4 * j) < input; j++) {
            inputList[3 + (4 * j)]++;
        }
        ...
        inputList[19 + 20 * 0]++;
            ...
        inputList[19 + 20*n < input]++;
        for(int j = 0; 19 + (20 * j) < input; j++) {
            inputList[19 + (20 * j)]++;
        }

        for(int j = 0; 1 + (2 * j) < input; j++) {
            inputList[1 + (2 * j)]++;
        }
        for(int j = 0; 2 + (3 * j) < input; j++) {
            inputList[2 + (3 * j)]++;
        }
        for(int j = 0; 3 + (4 * j) < input; j++) {
            inputList[3 + (4 * j)]++;
        }
        ...
        for(int j = 0; 19 + (20 * j) < input; j++) {
            inputList[19 + (20 * j)]++;
        }
        */
        for(int i = 1; i < input; i++) {
//            for(int j = 0; i + ((i + 1) * j) < input; j++ ) {
//                inputList[i + ((i + 1) * j)]++;
//            }
            // 강사님 방법
            for(int k = i; k < input; k = k + i) {
                inputList[k]++;
            }
        }


        /*
        for(int i = 1, j = 0; i + ((j + 2) * j) < input; i++, j++) {
            inputList[(j + 1) + ((i + 1) * j)]++;
            /*
                        if(inputList[i] != 0) {
                answer++;
            }

        }  */

        for(int i = 1; i < input; i++) {
            if(inputList[i] == 1) {
                answer++;
            }
        }

/*
            inputList[1 + 2*0]++;
            inputList[1 + 2*1]++;
            inputList[1 + 2*2]++;
            inputList[1 + 2*3]++;
            inputList[1 + 2*4]++;
            ...
            inputList[1 + 2*n < input]++;

            inputList[2 + 3*0]++;
            inputList[2 + 3*1]++;
            inputList[2 + 3*2]++;
            inputList[2 + 3*3]++;
            ...
            inputList[2 + 3*n < input]++;

            inputList[3 + 4*0]++;
            inputList[3 + 4*1]++;
            ...
            inputList[3 + 4*n < input]++;

            ...
            inputList[19 + 20 * 0]++;
            ...
            inputList[19 + 20*n < input]++;

        }
        */
        return answer;
    }

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();
        SieveofEratosthenes main = new SieveofEratosthenes();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
//        int answer = main.mySolution(input);
        int answer = main.solution(input);
        System.out.println(answer);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("수행시간(ms) : " + secDiffTime);
    }
}
