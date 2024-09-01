package similar_questions.section2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ThanksPresent_5강 {
        public String solution(String[] votes, int k){
            String answer = " ";
            HashMap<String, HashSet<String>> voteHash = new HashMap<>();
            HashMap<String, Integer> candidate = new HashMap<>();
            HashMap<String, Integer> present = new HashMap<>();
            for(String x : votes){
                // 추천 한 학생
                String a = x.split(" ")[0];
                // 추천 받은 학생
                String b = x.split(" ")[1];
                voteHash.putIfAbsent(a, new HashSet<String>());
                // 추천 한 학생, 추천 받은 학생
                voteHash.get(a).add(b);

                // 추천 받은 학생 몇번 추천받았는지 빈도수 카운팅
                candidate.put(b, candidate.getOrDefault(b, 0) + 1);
            }
            int max=Integer.MIN_VALUE;

            // a : 추천을 한 학생
            for(String a : voteHash.keySet()){
                int cnt = 0;
                // 추천 받은 학생  b
                for(String b : voteHash.get(a)){
                    // 총 몇번 추천 받았는지
                    if(candidate.get(b) >= k) cnt++;
                }
                present.put(a, cnt);
                max = Math.max(max, cnt);
            }
            ArrayList<String> tmp = new ArrayList<>();
            for(String name : present.keySet()){
                if(present.get(name) == max) tmp.add(name);
            }
            tmp.sort((a, b) -> a.compareTo(b));
            answer = tmp.get(0);
            return answer;
        }


    public static void main(String[] args) {
        ThanksPresent_5강 main = new ThanksPresent_5강();
        System.out.println(main.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom",
            "daniel tom", "luis john"}, 2));
    }
}
