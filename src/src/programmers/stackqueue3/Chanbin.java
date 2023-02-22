package src.programmers.stackqueue3;

import java.util.Stack;

class Chanbin {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.isEmpty()) stack.pop();
            else return false;
        }

        return stack.isEmpty();
    }
}