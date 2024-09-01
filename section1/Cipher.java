package section1;

import java.util.Scanner;

public class Cipher {

    public String solution(String input, int inputNumber) {
        int fixLength = 7;
        String[] inputList = input.split("(?<=\\G.{" + fixLength + "})");
        char[] answer = new char[inputNumber];

        for (int i = 0; i < inputList.length; i++) {
            char[] chars = inputList[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '#') {
                    chars[j] = '1';
                } else {
                    chars[j] = '0';
                }
            }
            String binary = String.valueOf(chars);
            int decimal = Integer.parseInt(binary, 2);
            answer[i] = (char) decimal;
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        Cipher main = new Cipher();
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        String input = sc.next();
        String answer = main.solution(input, inputNumber);
        System.out.println(answer);
    }
}
