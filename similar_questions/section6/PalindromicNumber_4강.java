package similar_questions.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class PalindromicNumber_4강 {

    List<String> list = new ArrayList<>();
    Deque<Character> tmp = new ArrayDeque<>();
    int len = 0;
    HashMap<Character, Integer> sH = new HashMap<>();

    private void DFS() {
        if (tmp.size() == len){
            String Ts = "";
            for(char x : tmp) Ts += x;
            list.add(Ts);
        } else {
            for(char key : sH.keySet()){
                if(sH.get(key) == 0) continue;
                tmp.addFirst(key);
                tmp.addLast(key);
                sH.put(key, sH.get(key) - 2);
                DFS();
                tmp.pollFirst();
                tmp.pollLast();
                sH.put(key, sH.get(key) + 2);
            }
        }
    }

    private String[] solution(String input) {

        len = input.length();

        char mid = '#';
        int noAnswer = 0;

        for (char c : input.toCharArray()) {
            sH.put(c, sH.getOrDefault(c, 0) + 1);
        }

        for (Character c : sH.keySet()) {
            if (sH.get(c) % 2 == 1) {
                mid = c;
                noAnswer++;
            }
        }

        if (noAnswer > 1) {
            return new String[]{};
        }

        if(mid != '#'){
            tmp.add(mid);
            sH.put(mid, sH.get(mid) - 1);
        }

        DFS();
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        PalindromicNumber_4강 main = new PalindromicNumber_4강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] answer = main.solution(s);
        System.out.println(Arrays.toString(answer));
    }


}
