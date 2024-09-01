package section1;

import java.util.Scanner;

public class AlphabetPalindromeString {

    public String solution(String input) {
        String answer = "NO";
        input = input.toLowerCase().replaceAll("[^a-z]", "");
        String tmp = new StringBuilder(input).reverse().toString();
        if(input.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        AlphabetPalindromeString main = new AlphabetPalindromeString();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String answer = main.solution(input);
        System.out.println(answer);
    }
}
