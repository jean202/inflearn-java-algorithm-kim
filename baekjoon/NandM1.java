package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NandM1 {

    public List<List<Integer>> solution(int n, int m) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(n, m, answer, tmp);
        return answer;
    }

    public void backtrack(int n, int m, List<List<Integer>> answer, List<Integer> tmp) {
        if (tmp.size() == m) {
            answer.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (tmp.contains(i)) continue;
            tmp.add(i);
            backtrack(n, m, answer, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        NandM1 main = new NandM1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> answerList = main.solution(n, m);

        for (int i = 0; i < answerList.size(); i++) {
            for (int j = 0; j < answerList.get(i).size(); j++) {
                System.out.print(answerList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
