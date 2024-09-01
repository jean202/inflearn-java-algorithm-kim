package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubsetswithSamesum {

    static String answer = "NO";
    static int n;
    static int total;
    boolean flag = false;

    public void dfs(int level, int sum, int[] input) {
        if (flag | (sum > total / 2)) {
            return;
        }
        if (level == n) {
            if (total / 2 == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(level + 1, sum + input[level], input);
            dfs(level + 1, sum, input);
        }
    }

    public static void main(String[] args) throws IOException {
        SubsetswithSamesum main = new SubsetswithSamesum();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
           input[i] = Integer.parseInt(st.nextToken());
           total += input[i];
        }
        main.dfs(0, 0, input);
        System.out.println(answer);
    }
}
