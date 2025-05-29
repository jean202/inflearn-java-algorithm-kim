package programmers.level2;

public class nextLargeNumber {

    /*
    런타임 에러
    → substring, 인덱스 연산에서 범위를 벗어남
    → 일부 입력(n)이 1이거나, 2, 3 등 짧은 수에서 예외 발생
    → for문 내부에서 중간에 break가 빠져서 무한루프 가능

    효율성(시간 초과)
    → O(n)으로 충분한 문제인데, 복잡하게 여러 분기를 타면서 불필요하게 오래 걸림
    → 이진수로 직접 변환하면서 스트링 조작이 너무 많음

    정확성
    → n=1, n=2, n=3 등 예외 케이스가 전혀 반영 안 됨
    → 대부분의 중간 크기 입력에서 결과가 맞지 않음
     */
    public int mySolution(int n) {
        int answer = 0;
        String n2String = "";
        String answerString = "";
        int cnt1 = 0;
        int cnt0 = 0;
        while(n > 0) {
            n2String = (n % 2) + n2String;
            if (n % 2 == 1) {
                cnt1++;
            } else {
                cnt0++;
            }
            n /= 2;
        }

        if (cnt1 == 1) {
            n2String = n2String.substring(1, n2String.length() + 1);
            n2String = 0 + n2String;
            answerString = 1 + n2String;
        }

        if (cnt0 == 0) { // 전부 1이면 자릿수 높이기
            answerString = "10";
            for (int i = 0; i < cnt1 - 1; i++) {
                answerString = answerString + "1";
            }
        } else {
            if (n2String.charAt(n2String.length() - 1) == 1) {

                int next1 = 0;
                for (int i = 1; i < n2String.length(); i++) {
                    if (n2String.charAt(i) == 1) {
                        next1 = n2String.length() - i;

                    }
                }

                int n2decimal = bTod(n2String);
                answer = n2decimal - 1 + (int) Math.pow(2, next1);
                return answer;
            } else {
                int second1 = 0;
                int cnt = 0;
                for (int i = 1; i < n2String.length(); i++) {
                    if (n2String.charAt(i) == '1') {
                        // 1 0 1 0 -> 1 1 0 0
                        // 1 0 0 1 1 1 0 -> 1 0 1 0 0 1 1
                        second1 = i; // 3
                        // 1번째를 1로 바꿔야
                        // answerString = "1" -> "11"
                        // 0 ~ 1까지 : "1 0" -> "1 0 1"
                        answerString = n2String;
                        answerString = answerString.substring(0, i - 1) + 1;
                        // answerString = "110" / "1010"
                        answerString = answerString + 0;
                        if (cnt1 == 2) {
                            // answerString = "110" + "0" (1010)
                            answerString = answerString + n2String.substring(i + 1, n2String.length() + 1);
                            answer = bTod(answerString);
                            return answer;
                        }
                        cnt++;
                        if (cnt == 1) {
                            // n2String 1001 1110
                            // 최종 1010 + 0 1 1 1
                            // 5 부터
                            // 1010 0
                            answerString = answerString + 0;
                            // 1010 0 1 1
                            answerString = answerString + n2String.substring(answerString.length(), n2String.length() - 1);
                            answerString = answerString + 1;
                            answer = bTod(answerString);
                            return answer;
                        }
                    }
                }
            }
            n2String = n2String.substring(0, n2String.length() - 1);
            n2String = n2String + "1";

            answerString = n2String.substring(0, n2String.length() - 3);
            answerString = answerString + "011";
        }


        answer = bTod(answerString);
        System.out.println(cnt1);
        System.out.println(cnt0);
        System.out.println(answerString);
        System.out.println(answer);
        return answer;
    }

    public int bTod(String answerString) {
        int answer = 0;
    for (int i = 0; i < answerString.length(); i++) {
        if (answerString.charAt(i) == '1') {
            if (i == (answerString.length() - 1)) {
                answer += 1;
                break;
            }
            answer += Math.pow(2, answerString.length() - i - 1);
        }
    }
    return answer;
    }

    // 여기서부터 제대로 된 답
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int answer = n + 1;
        while (Integer.bitCount(answer) != cnt) {
            answer++;
        }
        return answer;
    }

    // 오른쪽에서 연속된 1의 뭉치 바로 앞의 0을 1로, 그 뒤를 0으로 바꾸고, 연속된 1들을 맨 뒤로 보내기
    public int pSolutionG(int n) {
        int c = n;
        int c0 = 0; // 0의 개수
        int c1 = 0; // 1의 개수

        // 1. 맨 오른쪽 0의 개수 세기 (맨 끝 1뭉치 앞 0)
        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }
        // 2. 그 뒤에 있는 1의 개수 세기 (연속된 1뭉치)
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        // 3. 자리를 바꿈
        // 78: c0=1, c1=3
        int p = c0 + c1; // 바꿀 자리
        n += (1 << c0); // 0을 1로 (2^c0 자리)
        n &= ~((1 << c0) - 1); // 그 오른쪽(작은 자리)은 모두 0
        n |= (1 << (c1 - 1)) - 1; // 끝에 1뭉치(2개) 붙이기
        return n;
    }

    public static void main(String[] args) {
        nextLargeNumber main = new nextLargeNumber();
        int answer = main.solution(78);
        System.out.println(answer);
    }

}
