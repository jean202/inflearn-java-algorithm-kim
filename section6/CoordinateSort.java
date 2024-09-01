package section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 좌표를 저장하는 클래스
// 해당 클래스(Point)의 객체를 정렬하겠다
class Point implements Comparable<Point> {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 정렬하는 기준이 되어주는 메서드
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            // 빼기가 들어가 있는 이유
            // 오름차순이냐 내림차순이냐의 기준 :
            // 앞 뒤 이렇게 정렬이 되기 위해서는 음수값이 return되도록 해야 한다

            // 오름차순을 만들고 싶다면
            // 10 , 20 2, 3
            // 10 - 20 : 음수
            // [메서드를 호출한 객체 this] [매개변수로 넘어온 객체 object]

            // 내림차순을 만들고 싶다면
            // 20, 10
            // [메서드를 호출한 객체 this] [매개변수로 넘어온 객체 object]
            // o - this
            // 10 - 20
            // 결과가 음수가 되도록??

            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}

public class CoordinateSort {

//5
//2 7
//1 3
//1 2
//2 5
//3 6

    private int[][] solution(int[][] input) {
        return null;
    }
    public static void main(String[] args) throws IOException {
        CoordinateSort main = new CoordinateSort();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x, y));
        }

//        int[][] input = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            input[i][0] = Integer.parseInt(st.nextToken());
//            input[i][1] = Integer.parseInt(st.nextToken());
//        }

        // Collection의 sort를 호출하면 Comparable인터페이스를 통해서 정의해놓은 방식대로 정렬이 된다
        Collections.sort(arr);
        for (Point point : arr) {
            System.out.println(point.x + " " + point.y);
        }

//        int[][] answer = main.solution(input);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }

    }


}
