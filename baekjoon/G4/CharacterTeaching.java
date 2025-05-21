package baekjoon.G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class CharacterTeaching {

    static int max = 0;
    static boolean[] visited;
    static int Kminus;
    static String basic = "antic";
    static List<Character> toLearnList;
    static String[] words;

    public int solution(int N, int K, String[] arr) {
        if (K < 5) {
            return 0;
        } else if (K >= 26) {
            return N;
        } else {
            words = arr;
            // 배워야 하는 문자를 넣어두는 Set
            Set<Character> toLearn = new HashSet<Character>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length(); j++) {
                    char ch = arr[i].charAt(j);
                    if (basic.indexOf(ch) == -1) {
                        toLearn.add(ch);
                    }
                }
            }
            // 배워야 하는 문자 Set을 List로
            toLearnList = new ArrayList<Character>(toLearn);
            // 해당 문자로 조합 시켰는지 확인하기 위한 체크 배열
            visited = new boolean[toLearn.size()];

            // 배울 수 있는 문자 수
            Kminus = K - 5;

            // 후보 알파벳이 K-5 이하가 될 경우 : ex) 1개만 더 배우면 되는데 2개 가르치라고 주어졌을 때
            // -> DFS 할 필요 X
            if (toLearnList.size() <= Kminus) {
                // 배워야하는 문자 리스트에 a n t i c 추가 (사실 얘네는 이미 아는거지만... 변수 이름 잘못 지음)
                for(char c : basic.toCharArray()) {
                    toLearn.add(c);
                }
                // 읽을 수 있는 단어 세주는 함수 호출
                return countReadableWords(toLearn);
            }

            // 후보 알파벳이 K-5 이상일 경우
            combineAndCheckMaxWord(0, 0);
            return max;
        }
    }

    // DFS
    public void combineAndCheckMaxWord(int start, int depth) {
        // 조합 완성되면 몇개의 단어를 체크 할 수 있는지 확인하기
        if (depth == Kminus) {
            Set<Character> known = new HashSet<>();

            // 해당 단어에 기본 단어 넣고 지금 조합한 단어 넣어서 다 커버되는지 확인하기

            // 완성된 조합을 known에 추가하기 위해 방문 배열 탐색
            for (int i = 0; i < toLearnList.size(); i++) {
                if (visited[i]) {
                    // 배운 문자 리스트에 추가
                    known.add(toLearnList.get(i));
                }
            }

            // 배운 문자 리스트에 a n t i c 추가
            for (int i = 0; i < basic.length(); i++) {
                known.add(basic.charAt(i));
            }

            int count = countReadableWords(known);
            max = Math.max(max, count);
            return;
        } else {
            // 문자 K-5 개 가지고 조합 만들기
            for (int i = start; i < toLearnList.size(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    combineAndCheckMaxWord(i + 1, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public int countReadableWords(Set<Character> known) {
        int count = 0;

        // 입력받은 단어 순회하며 읽을수 있는지 확인
        for (String word : words) {
            boolean canRead = true;
            for (char c : word.toCharArray()) {
                if (!known.contains(c)) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        CharacterTeaching main = new CharacterTeaching();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int answer = main.solution(N, K, arr);
        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

}
