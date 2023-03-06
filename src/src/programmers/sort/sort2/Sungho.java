package src.programmers.sort.sort2;

import java.util.Arrays;

public class Sungho {
    public String solution(int[] numbers) {
        // numbers의 길이만큼 배열 선언
        String[] answer = new String[numbers.length];

        // compareTo : 비교 메서드
        // 비교 후 정렬
        Arrays.sort(answer, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 첫 번쨰 요소가 0이면 이후에 모든 요소도 0임
        if (answer[0].equals("0")) {
            return "0";
        }

        return String.join("", answer);
    }
}
