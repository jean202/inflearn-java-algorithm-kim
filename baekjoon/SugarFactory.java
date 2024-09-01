package baekjoon;

import java.util.Scanner;

public class SugarFactory {

    public int solution(int kg) {

        int count = 0;

        if (kg % 5 == 0) {
            count = kg / 5;
//            return count;
//        } else if (kg % 3 == 0) {
//            count = kg / 3;
//            return count;
//        } else if (kg % 5 > 0){
        } else {

            count = (int) (kg / 5);

            // 19가 있다고 쳤을 때
            // 4/3 = 1.33

            // 17이 있다고 쳤을때
            // 2/3 = 0.66

            // 16이 있다고 쳤을때

            // 17이 있다고 쳤을때 count 3인 상태
            // 17 - 15 = 2 -> dividend
            // 18이 있다고 쳤을 때 count가 3인 상태
            // 18 - 15 = 3
            // 19가 있다고 쳤을 때 dividend = 4
            // 4가 있다고 쳤을 때 dividend = 4 - 0 = 4
            // 7이 있다고 쳤을 때 dividend = 7 - 5 = 2

            double dividend = kg - (count * 5);
            double divisor = 3;
            // 2 / 3 = 0.666
            // 3 / 3 = 0
            // 4 / 3 = 1.33333
            double quotient = dividend / divisor;
//            double remainder = dividend % divisor;
            if (quotient == 1) {
                count += 1;
            } else {
                while (count > 0) {
                    count -= 1;
                    // 6 = 16 - 10
                    // 7 = 17 - 10
                    // 12 = 17 - 5
                    // 9 = 19 - 10
                    // 7 = 7 - 0
                    dividend = kg - (count * 5);
                    divisor = 3;
                    // 6 % 3 = 0
                    // 7 % 3 = 1
                    // 12 % 3 = 0
                    // 9 % 3 = 0
                    // 7 % 3
                    quotient = dividend % divisor;
                    if (quotient == 0) {
                        // 6 / 3 = 2
                        // 12 / 3 = 4
                        // 9 / 3 = 3

                        count += dividend / divisor;
                        return count;
                    }
                }
                if (count == 0) {
                    count = -1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SugarFactory sugarFactory = new SugarFactory();
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int answer = sugarFactory.solution(input);
        System.out.println(answer);
    }
}
