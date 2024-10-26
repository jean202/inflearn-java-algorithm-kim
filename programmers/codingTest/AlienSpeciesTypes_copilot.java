package programmers.codingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlienSpeciesTypes_copilot {
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

        double tmpMin = Double.MAX_VALUE;
        double tmpMax = Double.MIN_VALUE;

        for (int i = 1; i <= n / 2 + 1; i++) {
            List<List<Integer>> combinations = combinationsWithReplacement(numList, i);
            for (List<Integer> combination : combinations) {
                int sum = 0;
                for (int num : combination) {
                    sum += num;
                }
                if (m == sum) {
                    double num = 0;
                    for (int k : combination) {
                        num += (2 * k + 1 / 4.0) * Math.sqrt(0.5) + 1 / 2.0;
                    }
                    if (num >= 0) {
                        tmpMin = Math.min(tmpMin, n - num + combination.size());
                        tmpMax = Math.max(tmpMax, n - num + combination.size());
                    }
                }
            }
        }

        if (m == 0) {
            System.out.println(n + " " + n);
        } else {
            System.out.println((int) tmpMin + " " + (int) tmpMax);
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

