package similar_questions.section6;

import java.util.Stack;

public class TugofWar_2강 {

    int[] ch;
    int[][] relation;
    int answer;
    Stack<Integer> pm;
    public void DFS(int L){
        if(L == 7) answer++;
        else{
            for(int i = 1; i < 8; i++){
                if(!pm.empty() && relation[pm.peek()][i] == 1) continue;
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm.push(i);
                    DFS(L + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    private int solution(int[][] inform) {
        answer = 0;
        pm = new Stack<>();
        relation = new int[8][8];
        for(int[] x : inform){
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        ch = new int[8];
        DFS(0);
        return answer;
    }

    public static void main(String[] args) {
        TugofWar_2강 main = new TugofWar_2강();
        int[][] inform1 = {{1, 3}, {5, 7}, {4, 2}};
        int[][] inform2 = {{3, 2}, {3, 5}, {5, 2}, {7, 3}};
        int[][] inform3 = {{1, 2}, {1, 5}, {1, 7}, {1, 3}};
        int[][] inform4 = {{1, 7}};
        int[][] inform5 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int answer1 = main.solution(inform1);
        int answer2 = main.solution(inform2);
        int answer3 = main.solution(inform3);
        int answer4 = main.solution(inform4);
        int answer5 = main.solution(inform5);
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
        System.out.println(answer5);
    }
}
