package src.stackqueue.stackqueue3;

import java.util.Stack;

public class PshStackQueueThree {
    boolean solution(String s) {
        // stack 선언
        Stack<Character> stack = new Stack<>();

        // String 순회
        for (int i = 0; i < s.length(); i++) {
            // 스택이 비어있지 않으면서 i번째 문자가 ) 이면 스택에서 값 빼기
            if (!stack.empty() && s.charAt(i) == ')') {
                stack.pop();
            } else { // 그 외의 경우 스택에 담기
                stack.push(s.charAt(i));
            }
        }

        // 스택이 비어있으면 true, 아니면 false
        return stack.isEmpty();
    }

/**
 * 스택을 사용하지 않고 푸는 방법
 * Time: 8.19 ms, Memory: 52.3 MB
 * 훨씬 단순하고 시간도 적게 듦
 */
//    boolean solution(String s) {
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') count++;
//            if (s.charAt(i) == ')') count--;
//            if (count < 0) return false;
//        }
//
//        return count == 0 ? true : false;
//    }
}
