package programmers.입문;

import java.util.Arrays;
import java.util.Stack;

public class CtrlZ {

    public int mySolution(String s) {
        int answer = 0;
        String[] sArr = s.split(" ");
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals("Z")) {
                answer -= Integer.parseInt(sArr[i - 1]);
                continue;
            }
            answer += Integer.parseInt(sArr[i]);
        }
        return answer;
    }

    public int pSolution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (String w : s.split(" ")) {
            if (w.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(w));
            }
        }
        for (int i : stack) {
            answer += i;
        }
        return answer;
    }

    public int reSolution(String s) {
        return Arrays.stream(s.replaceAll("[-0-9]{1,5} Z", "").split(" ")).filter(r -> !r.isEmpty()).mapToInt(Integer::parseInt).sum();
    }

    public static void main(String[] args) {
        CtrlZ ctrlZ = new CtrlZ();
        System.out.println(ctrlZ.mySolution("1 2 Z 3"));
        System.out.println(ctrlZ.mySolution("10 20 30 40"));
        System.out.println(ctrlZ.mySolution("10 Z 20 Z 1"));
        System.out.println(ctrlZ.mySolution("10 Z 20 Z"));
        System.out.println(ctrlZ.mySolution("-1 -2 -3 Z"));
    }
}
