package src.programmers.stackqueue3;

import java.util.Stack;

/*
* LEVEL 2 스택/큐 : 올바른 괄호
* */
public class JaeHyeok {
    public static void main(String[] args) {
        JaeHyeok example = new JaeHyeok();
        System.out.println(example.solution("()()")); // expect : true
        System.out.println(example.solution("(())()")); // expect : true
        System.out.println(example.solution(")()(")); // expect : false
        System.out.println(example.solution("(()(")); // expect : false
    }

    private boolean solution(String s) {
        // "("로 시작하면 push하여 Stack에 저장
        // ")"로 시작하면 pop 진행, 만약 pop했을때 데이터가 없다면 false 리턴
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push("(");
            else {
                if(stack.size()>0) stack.pop();
                else return false;
            }
        }
        if(stack.size()!=0) return false;

        return true;
    }
}
