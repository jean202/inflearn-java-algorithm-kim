    package section1;

    import java.util.Scanner;

    public class SpecificStringReverse {

        public String solution(String given) {
            String answer;
            char[] c = given.toCharArray();

            int lt = 0;
            int rt = c.length - 1;

            while (lt < rt) {
                if (!Character.isAlphabetic(c[lt])) {
                    lt++;
                } else if (!Character.isAlphabetic(c[rt])) {
                    rt--;
                } else {
                    char tmp = c[lt];
                    c[lt] = c[rt];
                    c[rt] = tmp;
                    lt++;
                    rt--;
                }
            }
            answer = String.valueOf(c);
            return answer;
        }

        public static void main(String[] args) {

            SpecificStringReverse main = new SpecificStringReverse();
            Scanner sc = new Scanner(System.in);
            String given = sc.next();
            String answer = main.solution(given);
            main.solution(answer);
            System.out.println(answer);
        }

    }
