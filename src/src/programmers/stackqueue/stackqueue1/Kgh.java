package src.programmers.stackqueue.stackqueue1;

import java.util.*;

public class Kgh {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
    
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        answer.add(arr[0]);
        for(int i= 1; i< arr.length; i++){
            if(arr[i] != arr[i-1]){
                answer.add(arr[i]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
