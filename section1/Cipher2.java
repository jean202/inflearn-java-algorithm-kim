package section1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cipher2 {
    // #****###**#####**#####**##** -> COOL
    // 7개씩 자름
    // 자른 단위를 10진수로 변환
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String str = br.readLine().replaceAll("\\#", "1").replaceAll("\\*", "0");

        for (int i = 0; i < str.length(); i++) {
            String cut = str.substring(i, i + 7);
            i += 6;

            int v = 1;
            int num = 0;
            for (int j = 6; j >= 0; j--) {
                num += Character.getNumericValue(cut.charAt(j)) * v;
                v *= 2;
            }
            System.out.print((char)num);
        }

        System.out.println();
    }
}