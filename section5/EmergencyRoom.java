package section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class Patient {
    int queueNumber;
    int risk;

//    public Patient(int queueNumber, int risk) {
//        this.queueNumber = queueNumber;
//        this.risk = risk;
//    }

    public void setQueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }
}
public class EmergencyRoom {

    public int solution (int m, List<Patient> patients) {
        int answer = 1;
        // m이 몇번째로 진료받는지?
        Queue<Patient> Q = new LinkedList<>();

        for (int i = 0; i < patients.size(); i++) {
            Q.offer(patients.get(i));
        }

//        5 2
//        0,60 1,50 2,70 80 90

        // 50 70 80 90 60
        // 70 80 90 60 50
        // 80 90 60 50 70
        // 90 60 50 70 80
        // 60 50 70 80 , answer = 1

        // 50 70 80 60
        // 70 80 60 50
        // 80 60 50 70
        // 60 50 70 , answer = 2

        // 50 70 60
        // 70 60 50 , 뽑혀나갈 때 answer는 2
        // 60 50

        // 50
        while (!Q.isEmpty()) {
            Patient patient = Q.poll();
            for (Patient p : Q) {
                if (p.risk > patient.risk) {
                    Q.offer(patient);
                    patient = null;
                    break;
                }
            }
            if(patient != null) {
                if(patient.queueNumber == m) {
                    return answer;
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        EmergencyRoom main = new EmergencyRoom();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());

        List<Patient> patients = new ArrayList<>();
        StringTokenizer r = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Patient patient = new Patient();
            patient.setQueNumber(i);
            patient.setRisk(Integer.parseInt(r.nextToken()));
            patients.add(patient);
        }
        int answer = main.solution(m, patients);
        System.out.println(answer);
    }
}
