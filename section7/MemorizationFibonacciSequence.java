package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemorizationFibonacciSequence {

    static int[] fibonacciSequence;

    private int recursive(int n) {
        if (fibonacciSequence[n - 1] != 0) {
            return fibonacciSequence[n - 1];
        }
        if (n < 3) {
            fibonacciSequence[n - 1] = 1;
            return 1;
        } else {
            return fibonacciSequence[n - 1] = recursive(n - 2) + recursive(n - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        MemorizationFibonacciSequence main = new MemorizationFibonacciSequence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibonacciSequence = new int[n];
        main.recursive(n);
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSequence[i] + " ");
        }
    }
}
