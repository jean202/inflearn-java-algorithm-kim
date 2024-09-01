package section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReversePrimeNumber {

    public int[] solution1(int[] input) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            int reverseNumber = 0;
            while (number != 0) {
                reverseNumber = reverseNumber * 10 + number % 10;
                number = number / 10;
            }
            boolean divided = false;
            for (int j = 2; j < reverseNumber; j++) {
                if (reverseNumber % j == 0) {
                    divided = true;
                    break;
                }
                divided = false;
            }
            if (!divided && reverseNumber != 1) {
                answer.add(reverseNumber);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int[] input) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> answerMap = new HashMap<>();
        int[] reverseNumberList = new int[input.length];
        int bigNumber = 0;

        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            int reverseNumber = 0;
            while (number != 0) {
                reverseNumber = reverseNumber * 10 + number % 10;
                number = number / 10;
            }
            if (bigNumber < reverseNumber) {
                bigNumber = reverseNumber;
            }
            reverseNumberList[i] = reverseNumber;
        }
        int[] primeNumberList = new int[bigNumber];

        for (int i = 1; i < bigNumber; i++) {
            for (int j = 0; i + ((i + 1) * j) < bigNumber; j++) {
                primeNumberList[i + ((i + 1) * j)]++;
            }
        }

        for (int i = 1; i < bigNumber; i++) {
//            System.out.println("primeNumberList[" + i + "] : " + primeNumberList[i]);
            List<Integer> reverseIntegerNumberList = Arrays.stream(reverseNumberList)
                .boxed()
                .collect(Collectors.toList());
            boolean contains = Arrays.asList(reverseNumberList).contains(i + 1);
//            System.out.println("contains : " + contains);
            if ((primeNumberList[i] == 1) && (reverseIntegerNumberList.contains(i + 1))) {
                int target = i + 1;

                List<Integer> indexes = IntStream.range(0, reverseNumberList.length)
                    .filter(x -> target == reverseNumberList[x])
                    .boxed()
                    .collect(Collectors.toList());

                for (int j = 0; j < indexes.size(); j++) {
                    answerMap.put(indexes.get(j), i + 1);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> tmpList = new ArrayList<>(answerMap.entrySet());

        Collections.sort(tmpList, new Comparator<Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Entry<Integer, Integer> entry : tmpList) {
            answer.add(entry.getValue());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

   public boolean isPrimeNumber(int number) {
        boolean isPrimeNumber = true;
        if (number == 1) {
            isPrimeNumber = false;
        }
        for(int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrimeNumber = false;
            }
        }
        return isPrimeNumber;
   }

    public List<Integer> teacherSolution(int[] input) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            int given = input[i];
            int number = 0;
            while(given > 0) {
                int tmp = given % 10;
                number = number * 10 + tmp;
                given = given / 10;
            }
            if (isPrimeNumber(number)) {
                answer.add(number);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        ReversePrimeNumber main = new ReversePrimeNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberSize = Integer.parseInt(br.readLine());
        int[] input = new int[numberSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberSize; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = main.solution2(input);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
