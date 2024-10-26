package programmers.codingTest.aivleschool.entrance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlienSpeciesTypes_MJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> numList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (i * (i - 1) / 2 <= m) {
                numList.add(i * (i - 1) / 2);
            }
        }

        final double[] tmpMin = {Double.POSITIVE_INFINITY};
        final double[] tmpMax = {Double.NEGATIVE_INFINITY};

        for (int i = 1; i <= n / 2 + 1; i++) {
            combinationsWithReplacement(numList, i).forEach(j -> {
                if (m == j.stream().mapToInt(Integer::intValue).sum()) {
                    double num = 0;
                    for (int k : j) {
                        num += (2 * k + 1 / 4.0) * Math.sqrt(0.5) + 1 / 2.0;
                    }
                    if (num >= 0) {
                        tmpMin[0] = Math.min(tmpMin[0], n - num + j.size());
                        tmpMax[0] = Math.max(tmpMax[0], n - num + j.size());
                    }
                }
            });
        }

        if (m == 0) {
            System.out.println(n + " " + n);
        } else {
            System.out.println((int) tmpMin[0] + " " + (int) tmpMax[0]);
        }
    }

    public static List<List<Integer>> combinationsWithReplacement(List<Integer> elements, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(combinations, new ArrayList<>(), elements, 0, k);
        return combinations;
    }

    private static void generateCombinations(List<List<Integer>> combinations, List<Integer> currentCombination,
        List<Integer> elements, int start, int k) {
        if (currentCombination.size() == k) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < elements.size(); i++) {
            currentCombination.add(elements.get(i));
            generateCombinations(combinations, currentCombination, elements, i, k);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
