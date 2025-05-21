package programmers.level1;

public class FindKimseobang {

    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        FindKimseobang main = new FindKimseobang();
        String[] seoul = {"Jane", "Kim"};
        String answer = main.solution(seoul);
        System.out.println(answer);
    }

}
