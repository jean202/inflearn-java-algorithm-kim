package section2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TemporaryChief2 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N+1];

        for (int y = 1; y <= N; y++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            students[y] = new Student();
            for (int x = 0; x < arr.length; x++) {
                students[y].number = y; // 학생 번호
                students[y].level[x+1] = arr[x]; // n학년 때 속한 반
            }
        }

        Student student = students[1];
        for (int i = 2; i <= N; i++) {
            if (student.getEqualsStudent(students) < students[i].getEqualsStudent(students)) {
                student = students[i];
            }
        }

        System.out.println(student.number);

    }

    static class Student {
        // 1학년~5학년 까지.
        int number;
        int[] level = new int[6];


        int getEqualsStudent(Student[] students) {
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (i == this.number) {
                    continue;
                }

                for (int j = 1; j <= 5; j++) {
                    if (students[this.number].level[j] == students[i].level[j]) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
