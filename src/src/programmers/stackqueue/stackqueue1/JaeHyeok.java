package src.programmers.stackqueue.stackqueue1;

import java.util.Arrays;
import java.util.Stack;

/*
* LEVEL 1 스택/큐 : 같은 숫자는 싫어
* */
public class JaeHyeok {
    public static void main(String[] args) {
        JaeHyeok example = new JaeHyeok();
        System.out.println(Arrays.toString(example.solution(new int[]{1,1,3,3,0,1,1}))); // expect : [1,3,0,1]
        System.out.println(Arrays.toString(example.solution(new int[]{4,4,4,3,3}))); // expect : [4,3]
    }

    private int[] solution(int []arr) {
        int temp = -1;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            if(temp != arr[i]){
                temp = arr[i];
                stack.push(temp);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
