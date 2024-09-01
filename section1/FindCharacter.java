package section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindCharacter  {

    public int solution(String str, char c) {
        int count = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        // 방법 1.
        /*
        char[] chars = str.toCharArray();
        for (char x : chars) {
            if(x == c) {
                count++;
            }
        }
         */

        // 방법 2.
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) count++;
        }

        return count;
    }






    public static void main(String[] args) throws IOException {
        FindCharacter main = new FindCharacter();
//        Scanner sc = new Scanner(System.in);
//        String inputS = sc.next();
//        char inputC = sc.next().charAt(0);
//        int answer = main.solution(inputS, inputC);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        char ch = br.readLine().charAt(0);
        int answer = main.review(string, ch);
        System.out.println(answer);
    }

    public int review(String string, char ch) {
        int answer = 0;
        for (char c : string.toCharArray()) {
            if (Character.toUpperCase(c) == Character.toUpperCase(ch)) {
                answer++;
            }
        }
        return answer;
    }
}
