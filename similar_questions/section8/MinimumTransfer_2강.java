package similar_questions.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumTransfer_2강 {

    // 처음 시도
    private int mySolution(List<int[]> list, int s, int e) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= 1000000; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                int point = list.get(i)[j];
                graph.get(point).add(i);
            }
        }

        // BFS
        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[list.size()];
        Q.offer(s);
        int level = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int station = Q.poll();
                List<Integer> transferLines = graph.get(station);
                for (int j = 0; j < transferLines.size(); j++) {
                    int line = transferLines.get(j);
                    if (ch[line] == 0) {
                        ch[line] = 1;
                        for (int k = 0; k < list.get(line).length; k++) {
                            int destination = list.get(line)[k];
                            if (destination == e) {
                                return level;
                            }
                            Q.offer(list.get(line)[k]);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
    private int solution(List<int[]> list, int s, int e) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        for(int i = 0; i < list.size(); i++) {
            int[] sameLineStations = list.get(i);
            for (int j = 0; j < sameLineStations.length; j++) {
                int station = sameLineStations[j];
                graph.putIfAbsent(station, new HashSet<Integer>());
                graph.get(station).add(i);
            }
        }

        // BFS
        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[list.size()];
        Q.offer(s);
        int level = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int curStation = Q.poll();
                HashSet<Integer> transferLines = graph.get(curStation);
                for (int line : transferLines) {
                    if (ch[line] == 0) {
                        ch[line] = 1;
                        for (int destination : list.get(line)) {
                            if (destination == e) {
                                return level;
                            }
                            Q.offer(destination);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        MinimumTransfer_2강 main = new MinimumTransfer_2강();
        List<int[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        String input = "";
        while(!(input = br.readLine()).equals("")) {
            String token[] = input.split(" ");
            int[] arr = new int[token.length];
            for (int i = 0; i < token.length; i++) {
                arr[i] = Integer.parseInt(token[i]);
            }
            list.add(arr);
        }

        int answer = main.solution(list, s, e);
        System.out.println(answer);

    }
}
