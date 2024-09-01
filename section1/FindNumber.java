package section1;

import java.util.Scanner;

public class FindNumber {

    public int solution(String str) {
        int n = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                // 01234 = 0*10000 + 1 * 1000 + 2 * 100 + 3*10 + 4*1
                // 0 * 10 + 0
                // 0 * 10 + 1 = 1
                // 1 * 10 + 2 = 12
                // 12 * 10 + 3 = 123
                // 123 * 10 + 4 = 1234
                // 기존값 * 10 + (i * 1)
                System.out.println("str.charAt(i) : " + str.charAt(i));
                int numericValue = Character.getNumericValue(str.charAt(i));
                n = (n * 10) + (str.charAt(i) - 48);
            }
        }
        /*
        String s = "";
        if 숫자 {
            s += char[i];
        }

        01234

        Integer.parseInt(01234)

         */

        return n;
    }


    public static void main(String[] args) {
        FindNumber main = new FindNumber();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int answer = main.solution(input);
        System.out.println(answer);
    }
}
