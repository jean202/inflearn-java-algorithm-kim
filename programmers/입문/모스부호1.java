package programmers.입문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 모스부호1 {
    public String solution(String letter) {
        String[] letters = letter.split(" ");
        // [.-],[-...],[-.-.],"-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}

        // 배열 두개를 어떻게 비교해?

        // .... 차례인데 이게

        // 입력 모스부호 함수 ????? 출력 해당 배열의 몇번째 인덱스인지 : https://technote-mezza.tistory.com/99 indexOf

        // 1. 모스 부호 배열을 저장해서 인덱스 화 한다.
        // 0 1 2 3 4 5 6 7 8 9 10

        // 2. letters를 반복문에 돌리면서 매칭시켜서 인덱스를 받는다(숫자화)
        // 1 4 6 9 0

        // 3. 98 ...
        // 97씩 더한다

        // 4. 더한 값을 캐릭터 형으로 만든다
        // 5. 캐릭터 붙여서 문자열로 만든다.
        StringBuilder builder = new StringBuilder();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        List<String> morseString = Arrays.asList(morse);
        for (String s : letters) {
            builder.append((char) (morseString.indexOf(s) + 97));
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        모스부호1 main = new 모스부호1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(main.solution(input));
    }
}
