package src.programmers.sort.sort2;

import java.util.Arrays;

public class Chanbin {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers1 = {3, 30, 34, 5, 9};
        int[] numbers2 = {6, 10, 2};
        int[] numbers3 = {12, 1213};
        int[] numbers4 = {0, 0};
        int[] numbers5 = {212, 21};
        int[] numbers6 = {1, 10, 100, 1000, 818, 81, 898, 89, 0, 0};
        int[] numbers7 = {1000, 999};

        System.out.println(solution.solution(numbers1));
        System.out.println(solution.solution(numbers2));
        System.out.println(solution.solution(numbers3));
        System.out.println(solution.solution(numbers4));
        System.out.println(solution.solution(numbers5));
        System.out.println(solution.solution(numbers6));
        System.out.println(solution.solution(numbers7));
    }
}

class Solution {
    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];

        // String 배열로 변환
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // o1 - o2 == 오름차순, o2 - o1 == 내림차순
        // 반환값이 양수인 경우에는 두 객체의 자리가 바뀌고, 음수 또는 0이면 객체의 자리가 유지된다.
        Arrays.sort(arr, (o1, o2) -> {
            int num1 = Integer.parseInt(o1 + o2);
            int num2 = Integer.parseInt(o2 + o1);

            return num2 - num1;
        });

        // String을 합치기 위한 StringBuilder
        StringBuilder answer = new StringBuilder();

        for (String num : arr) {
            answer.append(num);
        }

        // 00인 결과값이 나올 수 있기 때문에 0으로 반환
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}
