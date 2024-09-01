package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacciSequence {

    // 1 1 2 3 4 8 13 21 34 55

    // rec(1) = 1
    // rec(2) = 1
    // rec(3) = rec(1) + rec(2) = 2
    // rec(4) = rec(2) + rec(3) = 3
    // rec(5) = rec(3) + rec(4) = 5
    // rec(6) = rec(4) + rec(5) = 8
    // rec(7) = rec(5) + rec(6) = 13
    // rec(8) = rec(6) + rec(7) = 21
    // rec(9) = rec(7) + rec(8) = 34
    // rec(10) = rec(8) + rec(9) = 55
    private int recursive(int n) {
        if (n < 3) {
            return 1;
        } else {
            return recursive(n - 2) + recursive(n - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        RecursiveFibonacciSequence main = new RecursiveFibonacciSequence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.print(main.recursive(i + 1) + " ");
        }
    }
}
