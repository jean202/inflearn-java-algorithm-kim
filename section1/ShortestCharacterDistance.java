package section1;

import java.util.Scanner;

public class ShortestCharacterDistance {

    public int[] solution(String s, Character t) {

        int [] answer = new int[s.length()];
        int p = 1000;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t) {
                p = 0;
            }
            answer[i] = p;
            p++;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == t) {
                p = 0;
            }
            // 1
            if(p < answer[i]) {
                answer[i] = p;
            }
            // 2
            answer[i] = Math.min(answer[i], p);
            p++;
        }
        return answer;
    }


    public static void main(String[] args) {
        ShortestCharacterDistance main = new ShortestCharacterDistance();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Character t = sc.next().charAt(0);
        int[] solution = main.solution(s, t);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }
}
