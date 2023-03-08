package src.programmers.sort.sort2;

import java.util.Arrays;

/*
* Level 2 : 가장 큰 수
* */
public class Jaehyeok {
    public static void main(String[] args) {
        Jaehyeok example = new Jaehyeok();
        System.out.println(example.solution(new int[]{6, 10, 2})); // expect : 6210
        System.out.println(example.solution(new int[]{3, 30, 34, 5, 9})); // expect : 9534330
        System.out.println(example.solution(new int[]{0,0,0,0})); // expect : 0
    }

    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];

        // int로 생성된 값을 String으로 저장
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 가장 큰값 순서대로 정렬
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 정렬시 모든 요소가 0일 경우에는 첫번째 배열에 "0"값이 오므로 "0"으로 반환
        if (arr[0].equals("0")) {
            return "0";
        }

        // 정렬된 값을 붙여서 반환
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }
        return answer.toString();
    }
}
