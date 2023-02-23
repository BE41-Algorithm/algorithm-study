package src.programmers.stackqueue.stackqueue3;

import java.util.Stack;

public class Kgh {
    boolean solution(String s) {
        boolean answer = true;
        //스택 생성해서 (만 집어넣기
        // )가 나올 때마다 poll
        //스택이 비어있는지 확인 , 비어있는데 불러야 한다면 false
        //마지막까지 순회했지만 스택이 비어있지 않으면 false
        Stack<Integer> stack = new Stack<>();
        for(int i= 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add(1);
            }
            else{
                if(stack.size() ==0) return false;
                stack.pop();
            }
        }
        if(stack.size() >0){
            answer= false;
        }
        

        return answer;
    }
}
