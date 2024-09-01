package section1;

import java.util.Scanner;

public class StringIndexOfSubString_3강 {

    public String solution(String str) {
        String answer = "";
        int maxWorld = Integer.MIN_VALUE;

        // 방법 1
        String[] s = str.split(" ");
        for (String x : s) {
            if (maxWorld < x.length()) {
                maxWorld = x.length();
                answer = x;
            }
        }

        // 방법 2
        int pos; //it there isssssss
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > maxWorld) {
                maxWorld = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        // 마지막 단어(==공백 없는 문장) 적용시키기
        if(str.length() > maxWorld) {
            answer = str;
        }
        return answer;
    }

    public static void main(String[] args){
        StringIndexOfSubString_3강 q = new StringIndexOfSubString_3강();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String answer = q.solution(str);
        System.out.println("The answer : " + answer);
    }

    public String review() {
        return "substring을 활용해서 해보기";
    }
}

