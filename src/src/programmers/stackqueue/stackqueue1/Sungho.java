package src.programmers.stackqueue.stackqueue1;

import java.util.Stack;

// 스택을 활용할 경우 : Title: 같은 숫자는 싫어, Time: 55.30 ms, Memory: 118 MB
// 리스트를 활용할 경우 : Title: 같은 숫자는 싫어, Time: 35.40 ms, Memory: 112 MB
// 문제의 의도는 스택을 활용하는 것 같으나, 코드 자체는 리스트가 효율적임
public class Sungho {
    public int[] solution(int[] arr) {
        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // arr 순회
        for (int i : arr) {
            // 스택이 비어있거나 i가 직전에 담긴 값과 다를 경우 스택에 i 넣기
            if (stack.empty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }

        // stack to array
        return stack.stream().mapToInt(i -> i).toArray();
    }

//    public int[] solution(int[] arr) {
//        // list 생성
//        ArrayList<Integer> list = new ArrayList<>();
//        // arr의 첫 번째 요소 담기
//        list.add(arr[0]);
//
//        // arr 순회
//        for (int i = 1; i < arr.length; i++) {
//            // arr의 현재 값이 직전 값과 같으면 무시
//            if (arr[i - 1] == arr[i]) {
//                 continue;
//            } else { // 다를 경우 list에 추가
//                 list.add(arr[i]);
//            }
//        }
//
//        // list to array
//        return list.stream().mapToInt(i -> i).toArray();
//    }
}
