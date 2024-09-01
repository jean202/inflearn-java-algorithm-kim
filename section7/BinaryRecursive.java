package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryRecursive {
    // 11
    // => 1011
    // 1 * 8 + 0 * 4 + 1 * 2 + 1 * 1

    // 11 / 2 = 5 + 1
    // 5 / 2 = 2 + 1
    // 2 / 2 = 1 + 0
    // 1 / 2 = 0 + 1
    // -> 2로 나눈 값이 0이 되면 멈추고, 그 상태에서 나머지들을 역순으로 출력

    private void recursive(int n) {
        if (n == 0) {
            return;
        } else {
            recursive(n / 2);
            System.out.print(n % 2 + "");
        }
    }

//    public String solution(int n) {
//        StringBuilder answer = new StringBuilder();
//        answer.append();
//    }

    public static void main(String[] args) throws IOException {
        BinaryRecursive main = new BinaryRecursive();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        main.recursive(n);
    }


}
