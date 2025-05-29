package programmers.level1;

import java.util.Arrays;

public class Budget {


    static boolean[] visited;
    static int[] department;
    static int answer;

    public int solution(int[] d, int budget) {
        answer = 0;
        visited = new boolean[d.length];
        department = d;

        for (int i = 0; i < department.length; i++) {
            if (department[i] <= budget) {
                visited[i] = true;
                dfs(i,1, budget - department[i]);
                visited[i] = false;
            }
        }
        return answer;
    }

    public void dfs(int startIndex, int currentCount, int budgetLeft) {

        answer = Math.max(answer, currentCount);

        for (int i = startIndex + 1; i < department.length; i++) {
                if (!visited[i] && budgetLeft >= department[i]) {
                    visited[i] = true;
                    dfs(i, currentCount + 1, budgetLeft - department[i]);
                    visited[i] = false;
                }
            }
    }

    public int gSolution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) { // if (budget - d[i] >= 0)
                budget -= d[i];
                answer++;
            } else {
                break;
            }

        }
        return answer;
    }


    public static void main(String[] args) {
        Budget budget = new Budget();
        int[] d = { 1, 3, 2, 5, 4 };
//        int[] d = { 2, 2, 3, 3 };
        int answer = budget.gSolution(d, /*10*/ 9);
        System.out.println(answer);
    }
}
