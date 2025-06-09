package programmers.입문;

public class SumofSpecifiedTermsinnArithmeticSequence {

    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += a + i * d;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SumofSpecifiedTermsinnArithmeticSequence main = new SumofSpecifiedTermsinnArithmeticSequence();
        int answer = main.solution(3, 4, new boolean[]{true, false, false, true, true});
        int answer2 = main.solution(7, 1, new boolean[]{false, false, false, true, false, false, false});
        System.out.println("answer = " + answer2);
    }
}
