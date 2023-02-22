package src.stackqueue.stackqueue6;

import java.util.Arrays;
import java.util.Stack;

public class PshStackQueueSix {
    public static void main(String[] args) {
        PshStackQueueSix pshStackQueueSix = new PshStackQueueSix();
        System.out.println(Arrays.toString(pshStackQueueSix.solution(new int[]{1, 2, 3, 2, 3})));
    }

    public int[] solution(int[] prices) {
        // 결과를 담을 배열(prices의 길이)
        int[] answer = new int[prices.length];
        // 주식 가격의 idx를 담을 스택
        Stack<Integer> stack = new Stack<>();

        // prices 길이만큼 순회
        for (int i = 0; i < prices.length; i++) {
            // stack이 비어있지 않고, 주식의 가격이 떨어진 경우
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek(); // 마지막에 담긴 스택에 1
                stack.pop();
            }

            // 스택에 i 담기
            stack.push(i);
        }

        // 주식 가격이 떨어지지 않은 기간 계산
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}
