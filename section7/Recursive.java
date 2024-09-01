package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive {

    public void recursive(int n) {
        if (n == 0) {
//            return;
        } else {
            recursive(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        Recursive main = new Recursive();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        main.recursive(n);
    }
}
