package src.programmers.stackqueue6;

import java.util.Arrays;
import java.util.Stack;

/*
 * LEVEL 2 스택/큐 : 주식 가격
 * */
public class JaeHyeok {

    public static void main(String[] args) {
        JaeHyeok example = new JaeHyeok();
        System.out.println(Arrays.toString(example.solution(new int[]{1, 2, 3, 2, 3}))); // expect : [4, 3, 1, 1, 0]
    }

    private int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; // 반환할 배열
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // 값이 떨어지는 주식의 시간을 저장
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek(); // 반환배열에 떨어지는 시간 초 저장
                // System.out.println("i - stack.peek() = " + (i-stack.peek()));
                stack.pop(); // 값이 떨어진 초는 제거
            }
            stack.push(i); // 값이 떨어지지않은 주식의 시간초를 저장
            // System.out.println("i = "+ i + " / stack = " + stack);
        }

        while (!stack.isEmpty()) {
            // 값이 떨어지지않은 주식들, 마지막 인덱스부터 차례대로 빼오기
            Integer last = stack.pop();
            answer[last] = prices.length - last - 1;
        }
        return answer;
    }
}
