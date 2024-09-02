package programmers.codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class AlienSpeciesTypes_0902 {
    public int[] solution(int n, int m) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        AlienSpeciesTypes_0902 main = new AlienSpeciesTypes_0902();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] answer = main.solution(n, m);
        bf.write(Arrays.toString(answer));
        bf.write("");
        bf.flush();
    }
}
