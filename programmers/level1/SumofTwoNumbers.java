package programmers.level1;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.Set;

/*
    TreeSet을 쓴 이유는 중복 제거뿐만 아니라 자동 오름차순 정렬까지 한 번에 처리해 주기 때문입니다:

    중복 제거
    – HashSet·TreeSet 모두 컬렉션에 같은 값을 두 번 넣지 않습니다.

    정렬
    – HashSet은 내부적으로 해시 테이블을 쓰기 때문에 순서를 보장하지 않습니다.
    – 반면 TreeSet은 이진 검색 트리(Red–Black Tree)를 기반으로 구현된 SortedSet이어서, 삽입과 동시에 자연스러운 오름차순을 유지합니다.

    그 결과,

    코드가 더 간결해집니다. (TreeSet → 바로 toArray() → 정렬된 int[])

    별도의 정렬 작업이 필요 없습니다. (HashSet을 써서 List로 만든 뒤 Collections.sort() 하는 과정을 생략)

    성능 면에서 TreeSet의 삽입·탐색·삭제는 O(log n)이고, HashSet은 평균 O(1)입니다.
    하지만 이 문제의 n≤100 (최대 ⌊100×99/2⌋=4,950개의 합)에서는

    O(n²) 합산 비용이 지배적이므로

    O(log n) vs. O(1)의 차이는 거의 체감되지 않고,

    가독성과 간결성이 더 중요해 TreeSet을 선택하는 편이 유리합니다.
 */

public class SumofTwoNumbers {

    Set<Integer> sums = new TreeSet<>();
    static int[] nums;
    static int[] picked = new int[2];  // 고른 숫자를 저장할 임시 배열;
    static int end;

    public int[] solution(int[] numbers) {

        Set<Integer> answer = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();

    }

    public int[] mySolution(int[] numbers) {

        end = numbers.length;
        nums = numbers;
        dfs(0, 0);

        return sums.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(int start, int level) {
        if (level == 2) {
            sums.add(picked[0] + picked[1]);
            return;
        } else {
            for (int i = start; i < end; i++) {
                picked[level] = nums[i];
                dfs(i + 1, level + 1);
            }

        }
    }

    public static void main(String[] args) {
        SumofTwoNumbers main = new SumofTwoNumbers();
        int[] answer = main.mySolution(new int[]{2,1,3,4,1});
        System.out.println(Arrays.toString(answer));
    }
}
