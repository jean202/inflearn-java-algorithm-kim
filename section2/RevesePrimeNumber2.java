package section2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RevesePrimeNumber2 {

    static boolean[] isPrime = new boolean[100000 + 1];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isPrimeOfEratosthenes(100000);

        br.readLine();
        String[] s = br.readLine().split(" ");

        int[] nums = Arrays.stream(s)
            .map(v -> {
                return new StringBuilder(v).reverse().toString();
            })
            .mapToInt(Integer::parseInt)
            .filter(v -> {
                return isPrime[v];
            })
            .toArray();

        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void isPrimeOfEratosthenes(int n) {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

    }

}

