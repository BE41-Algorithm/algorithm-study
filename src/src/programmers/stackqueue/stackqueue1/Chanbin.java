package src.programmers.stackqueue.stackqueue1;

import java.util.*;

public class Chanbin {
    public int[] solution(int []arr) {
        /**
         * 1. 배열에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거해야 합니다.
         * 2. 제거된 후 남은 수들은 배열의 원소 순서를 유지해야 합니다.
         */

        /* Stack 생성 */
        Stack stack = new Stack<>();

        /* 비교를 위해 arr의 첫 번째 인덱스 삽입 */
        stack.add(arr[0]);


        for (int i = 1; i < arr.length; i++) {
            /* 새로 들어갈 숫자 */
            int newNum = arr[i];

            /* 가장 최근에 Stack에 저장된 값 */
            int lastNum = (int) stack.peek();

            /* 새로 들어간 값과 Stack의 마지막 값이 같지 않으면 Stack에 저장 */
            if (lastNum != newNum) stack.push(newNum);
        }

        /* stack 값을 int로 변환한 후 배열로 변환 */
        return stack.stream().mapToInt(i -> (int) i).toArray();
    }
}