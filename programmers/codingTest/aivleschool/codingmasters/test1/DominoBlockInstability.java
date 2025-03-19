package programmers.codingTest.aivleschool.codingmasters.test1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DominoBlockInstability {

    public int solution(int[] position, int[] height, int m) {
        int n = position.length;
        int minInstability = Integer.MAX_VALUE;

        // m개의 블록을 제거하는 모든 조합을 생성
        List<List<Integer>> removalCombinations = getCombinations(n, m);

        for (List<Integer> removalSet : removalCombinations) {
            // 블록을 제거한 후의 coll apsible 배열 생성
            List<Integer>[] collapsible = buildCollapsible(position, height, removalSet, n);

            // 새로운 instability 계산
            int instability = calculateInstability(collapsible, n, removalSet);

            // 최솟값 갱신
            minInstability = Math.min(minInstability, instability);
        }

        return minInstability;
    }

    // 모든 m개의 블록을 제거하는 조합 생성 (nCm)
    private List<List<Integer>> getCombinations(int n, int m) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, m, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int n, int m, int start) {
        if (temp.size() == m) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < n; i++) {
            temp.add(i);
            backtrack(result, temp, n, m, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    // 어떤 블록 i가 쓰러질 때, 그 범위에 들어가는 j를 연결리스트에 추가
    private List<Integer>[] buildCollapsible(int[] position, int[] height, List<Integer> removalSet, int n) {
        @SuppressWarnings("unchecked")
        List<Integer>[] collapsible = (List<Integer>[]) new ArrayList[n];

        // 초기화
        for (int i = 0; i < n; i++) {
            collapsible[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            // 선택된 블록을 제거한 후 collapsible 배열 생성
            if (removalSet.contains(i)) continue; // 제거된 블록은 무시
            int domino = position[i] + height[i];
            for (int j = i + 1; j < n; j++) {
                if (removalSet.contains(j)) continue; // 제거된 블록은 무시
                if (position[j] <= domino) {
                    collapsible[i].add(j);
                } else {
                    break;
                }
            }
        }
        return collapsible;
    }

    // 불안정도 계산 : i를 넘어뜨렸을 때 연쇄적으로 쓰러지는 블록 수를 구함
    private int calculateInstability(List<Integer>[] collapsible, int n, List<Integer> removalSet) {
        int maxInstability = 0;
        // 모든 블록 i를 대상
        for (int i = 0; i < n; i++) {
            if (removalSet.contains(i)) continue; // 제거된 블록은 무시(무시하지 않으면 실제로 제거된 블록 i도 BFS를 돌게 됨)
            int toppled = toppleCount(i, collapsible);
            maxInstability = Math.max(maxInstability, toppled);
        }
        return maxInstability;
    }

    // BFS를 사용하여 도미노 연쇄 반응을 계산
    private int toppleCount(int start, List<Integer>[] collapsible) {
        boolean[] visited = new boolean[collapsible.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : collapsible[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DominoBlockInstability main = new DominoBlockInstability();
        int[] position = {1, 3, 4, 5, 9, 10};
        int[] height = {1, 2, 5, 2, 2, 4};
        int m = 1;
        System.out.println(main.solution(position, height, m)); // 최소 불안정도 출력
    }
}