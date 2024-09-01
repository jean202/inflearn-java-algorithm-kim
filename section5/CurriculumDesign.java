package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CurriculumDesign {

    public String solution(String compulsory, String hyeonsus) {
        Queue<Character> Q = new LinkedList<>();

        for (int i = 0; i < compulsory.length(); i++) {
            Q.offer(compulsory.charAt(i));
        }

        for (int i = 0; i < hyeonsus.length(); i++) {
            if (Q.contains(hyeonsus.charAt(i)) && Q.peek() != hyeonsus.charAt(i)) {
                return "NO";
            };
        }

        if (!Q.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        CurriculumDesign main = new CurriculumDesign();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String compulsory = br.readLine();
        String hyeonsus = br.readLine();
        String answer = main.solution(compulsory, hyeonsus);
        System.out.println(answer);
    }
}
