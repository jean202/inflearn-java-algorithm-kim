package programmers.codingTest.aivleschool.codingmasters.test1;

public class MinimumDominoInstability {
    // 각 도미노 블록이 넘어질 때 영향을 미치는 범위를 계산하는 메서드
    private static int[] calculateImpactRange(int[] position, int[] height) {
        int n = position.length;
        int[] reach = new int[n];
        for (int i = 0; i < n; i++) {
            reach[i] = i;
            int rangeEnd = position[i] + height[i];
            for (int j = i + 1; j < n; j++) {
                if (position[j] <= rangeEnd) {
                    reach[i] = j;
                    rangeEnd = Math.max(rangeEnd, position[j] + height[j]);
                } else {
                    break;
                }
            }
        }
        return reach;
    }

    // 특정 블록이 넘어졌을 때 추가로 넘어지는 블록 개수를 계산하는 메서드
    private static int calculateUnstability(int start, int[] reach, boolean[] removed) {
        int maxReach = reach[start];
        int count = 0;

        for (int i = start; i <= maxReach; i++) {
            if (!removed[i]) {
                count++;
                maxReach = Math.max(maxReach, reach[i]);
            }
        }
        return count - 1;  // 자기 자신을 제외한 추가적으로 넘어지는 블록 개수
    }

    // 재귀 백트래킹을 통해 최적의 제거 조합을 찾는 메서드
    private static int backtrack(int[] reach, boolean[] removed, int m, int index) {
        if (m == 0) {
            int maxUnstability = 0;
            for (int i = 0; i < reach.length; i++) {
                if (!removed[i]) {
                    maxUnstability = Math.max(maxUnstability, calculateUnstability(i, reach, removed));
                }
            }
            return maxUnstability;
        }

        int minUnstability = Integer.MAX_VALUE;
        for (int i = index; i < reach.length; i++) {
            removed[i] = true;
            minUnstability = Math.min(minUnstability, backtrack(reach, removed, m - 1, i + 1));
            removed[i] = false;
        }
        return minUnstability;
    }

    // 최소 불안정도를 찾는 메인 메서드
    public static int findMinimumUnstability(int[] position, int[] height, int m) {
        int n = position.length;
        int[] reach = calculateImpactRange(position, height);
        boolean[] removed = new boolean[n];
        return backtrack(reach, removed, m, 0);
    }

    // 테스트 케이스
    public static void main(String[] args) {
        int[] position1 = {1, 3, 4, 5, 9, 10};
        int[] height1 = {1, 2, 5, 2, 2, 4};
        int m1 = 1;
        System.out.println("Minimum instability: " + findMinimumUnstability(position1, height1, m1)); // 기대 결과: 1

        int[] position2 = {1, 3, 4, 5, 9, 10};
        int[] height2 = {1, 2, 5, 2, 2, 4};
        int m2 = 0;
        System.out.println("Minimum instability: " + findMinimumUnstability(position2, height2, m2)); // 기대 결과: 4

        int[] position3 = {1, 2, 5, 6, 8, 9, 10};
        int[] height3 = {2, 2, 2, 5, 2, 2, 2};
        int m3 = 1;
        System.out.println("Minimum instability: " + findMinimumUnstability(position3, height3, m3)); // 기대 결과: 2

        int[] position4 = {1, 2, 5, 6, 8, 9, 10};
        int[] height4 = {2, 2, 2, 5, 2, 2, 2};
        int m4 = 3;
        System.out.println("Minimum instability: " + findMinimumUnstability(position4, height4, m4)); // 기대 결과: 1

        int[] position5 = {1, 2, 3, 4, 5, 6};
        int[] height5 = {5, 4, 3, 2, 1, 1};
        int m5 = 2;
        System.out.println("Minimum instability: " + findMinimumUnstability(position5, height5, m5)); // 기대 결과: 3
    }
}