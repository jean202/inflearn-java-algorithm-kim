package programmers.codingTest.aivleschool.codingmasters.test1;

import java.util.HashMap;
import java.util.Map;

public class AddingElementsToArray {
    public static int solution(int[][] queries) {
        Map<Integer, int[]> arrays = new HashMap<>();
        int totalCopies = 0;

        for (int[] query : queries) {
            int arrayNumber = query[0];
            int addCount = query[1];

            int[] arrayInfo = arrays.getOrDefault(arrayNumber, new int[]{0, 0}); // {currentSize, currentCount}
            int currentSize = arrayInfo[0];
            int currentCount = arrayInfo[1];

            // Adding new elements
            int newCount = currentCount + addCount;

            // If currentCount exceeds currentSize, we need to resize
            if (newCount > currentSize) {
                // Calculate the new size (next power of 2)
                int newSize = 1;
                while (newSize < newCount) {
                    newSize *= 2;
                }

                // Copy elements if currentSize > 0
                totalCopies += currentCount;

                // Update the array information
                currentSize = newSize;
            }

            // Store the updated size and count
            arrays.put(arrayNumber, new int[]{currentSize, newCount});
        }

        return totalCopies;
    }

    public static void main(String[] args) {
        int[][] queries1 = {{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}};
        System.out.println(solution(queries1)); // Output: 16

        int[][] queries2 = {{1, 1}, {1, 2}, {1, 4}, {1, 8}};
        System.out.println(solution(queries2)); // Output: 11
    }
}
