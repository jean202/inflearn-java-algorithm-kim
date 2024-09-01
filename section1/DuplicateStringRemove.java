package section1;

import java.util.Scanner;

public class DuplicateStringRemove {

    public String solution(String input) {
        String answer = "";

        // ksekkset

        // k

        for(int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i) + " " + i + " " + input.indexOf(input.charAt(i)));
            if(input.indexOf(input.charAt(i)) == i) {
                answer += input.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        DuplicateStringRemove main = new DuplicateStringRemove();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(main.solution(input));
    }

}
