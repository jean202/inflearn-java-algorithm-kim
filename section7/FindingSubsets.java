package section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingSubsets {

    // static으로 선언한 이유 : static 메소드(psvm)가 접근해야 하므로
    static int n;
    static int[] ch;
    public void dfs(int l) {
        if (l == n + 1) {
            // 1로 체크되어 있는(사용한다고 표시한)배열 요소의 인덱스 번호를 출력
            StringBuilder element = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    element.append(i + " ");
                }
            }
            // 공집합(x x x 나온 경우)은 출력하지 말아야 하니까
            // -> 근데 element를 append로 이어붙이는 거니까 상관없지 않나??
            // 그리고 애초에 ch가 셋 다 0일때는 이어붙여지는게 아무것도 없을텐데..
            // 실험해보자
            if (element.toString().length() > 0) {
                System.out.println(element);
            }
        } else {
            ch[l] = 1;
            // 해당 숫자를 사용하는 경우
            dfs(l + 1);

            ch[l] = 0;
            // 숫자를 사용하지 않는 경우
            dfs(l + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        FindingSubsets main = new FindingSubsets();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n + 1];
        main.dfs(1);
    }
}
