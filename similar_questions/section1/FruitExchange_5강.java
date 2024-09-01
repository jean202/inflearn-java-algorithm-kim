package similar_questions.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FruitExchange_5강 {

    private int mySolution(List<int[]> arr) {
        int[] a = arr.get(0); // 어떤 과일이 제일 작은지 찾아야
        boolean unique = true;
        if (a[0] == a[1] || a[1] == a[2] || a[0] == a[2]) {
            unique = false;
        }

        int aChange = 0; // 0이면 사과 1이면 배 2면 귤
        int am;
        if (a[0] > a[1]) {
            aChange = 1;
            am = a[1];
            if (a[1] > a[2]) {
                aChange = 2;
                am = a[2];
            }
        }
        if (a[0] > a[2]) {
            aChange = 2;
            am = a[2];
            if (a[2] > a[1]) {
                aChange = 1;
                am = a[1];
            }
        }
        if (a[1] > a[2]) {
            aChange = 2;
            am = a[2];
            if (a[2] > a[0]) {
                aChange = 0;
                am = a[0];
            }
        }


        int[] b = arr.get(1);
        int bm = Math.min(Math.min(b[0], b[1]), b[2]);
        int bChange = 0;

        if (aChange == bChange) {
//            continue;
        }



        return 0;
    }

    public int getMin(int[] fruit){
        int min = 100;
        for(int x : fruit){
            min = Math.min(min, x);
        }
        return min;
    }
    public Boolean isMinUnique(int[] fruit){
        int cnt = 0;
        int min = getMin(fruit);
        for(int x : fruit){
            if(x == min) cnt++;
        }
        return cnt == 1;
    }

    public int getMinIndex(int[] fruit){
        int min = getMin(fruit);
        for(int i = 0; i < 3; i++){
            if(fruit[i] == min) return i;
        }
        return 0;
    }

    public int solution(List<int[]> fruit) {
        int answer = 0;
        int n = fruit.size();
        int[] ch = new int[n];
        for(int i = 0; i < n; i++){
            if(ch[i] == 1) continue;
            if(isMinUnique(fruit.get(i)) == false) continue;
            for(int j = i + 1; j < n; j++){
                if(ch[j] == 1) continue;
                if(isMinUnique(fruit.get(j)) == false) continue;
                int a = getMinIndex(fruit.get(i));
                int b = getMinIndex(fruit.get(j));
                if(a != b && fruit.get(i)[b] > 0 && fruit.get(j)[a] > 0){
                    if(fruit.get(i)[a] + 1 <= fruit.get(i)[b] - 1 && fruit.get(j)[b] + 1 <= fruit.get(j)[a] - 1){
                        fruit.get(i)[a]++;
                        fruit.get(i)[b]--;
                        fruit.get(j)[b]++;
                        fruit.get(j)[a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for(int[] x : fruit){
            answer += getMin(x);
        }
        return answer;
    }



    public static void main(String[] args) throws IOException {
        FruitExchange_5강 main = new FruitExchange_5강();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> arr = new ArrayList<>();
        String input = "";
        while (!(input = br.readLine()).equals("")) {
            int[] in = new int[3];
            StringTokenizer st = new StringTokenizer(input);
            for (int i = 0; i < 3; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }
            arr.add(in);
        }
        int answer = main.solution(arr);
        System.out.println(answer);
    }

}
