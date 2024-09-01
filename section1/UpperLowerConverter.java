package section1;

import java.util.Scanner;

public class UpperLowerConverter {

    public String solution(String str) {
        char[] chars = str.toCharArray();

/*
//        String answer = ""; // for each문 안에서는 원본 변화가 불가능하기 때문에 답이 될 빈문자열에 이어붙여 준다
        for(char c : chars) {
            if(c >= 65 && c <= 90) {
                c = Character.toLowerCase(c); // 이쪽 내부에서는 c가 변화하는데(복사한 값으로 사용하니까) chars에는 아무 영향을 줄 수 없다
//                System.out.println(c); // S, D, Y 등의 대문자가 s, d, y등 소문자로 출력됨
                answer += Character.toLowerCase(c);
            } else if (c >= 97 && c <= 122) {
                c = Character.toUpperCase(c);
                answer += Character.toUpperCase(c);
            }
        }
*/

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] >= 65 && chars[i] <= 90) {
                chars[i] = Character.toLowerCase(chars[i]);
            } else if (chars[i] >= 97 && chars[i] <= 122) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        String answer = String.valueOf(chars);

        return answer;
    }
    public String review(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            if (Character.isUpperCase(chars[i]) { // 이렇게 하면 else는 자연스럽게 isLowerCase(chars[i])가 되서 else if필요x
            if (chars[i] >= 65 && chars[i] <= 90) {
//                chars[i] = Character.toLowerCase(input.charAt(i));
                chars[i] = (char) (chars[i] + 32);
            } else if (chars[i] >= 97 && chars[i] <= 122) {
//                chars[i] = Character.toUpperCase(input.charAt(i));
                chars[i] = (char) (chars[i] - 32);
            }
        }
        return String.valueOf(chars);
    }






    public static void main(String[] args) {
        UpperLowerConverter main = new UpperLowerConverter();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = main.solution(input);
//        String answer = main.review(input);
        System.out.println(answer);
    }


}
