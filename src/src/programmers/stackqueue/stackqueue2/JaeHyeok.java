package src.programmers.stackqueue.stackqueue2;

import java.util.*;

/*
* LEVEL 2 스택/큐 : 기능개발
* */
public class JaeHyeok {
    public static void main(String[] args) {
        JaeHyeok example = new JaeHyeok();
        System.out.println(Arrays.toString(example.solution(
                new int[]{93, 30, 55},
                new int[]{1, 30, 5}
                ))); // expect : [2, 1]
        System.out.println(Arrays.toString(example.solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        ))); // expect : [1, 3, 2]

    }

    private int[] solution(int[] progresses, int[] speeds) {
        // 기능개발 속도에 따른 진행률 관리 값을 Queue에 저장
        // 저장된 값을 for문으로 비교해 리턴 배열 완성
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;

        for(int i=0; i<progresses.length; i++){
            queue.add((int) Math.ceil((double) (100-progresses[i]) / speeds[i]));
        }
        int buff = queue.poll();
        while (true){
            int progress = queue.poll();
            if(progress>buff) {
                arrayList.add(cnt);
                cnt = 0;
                buff = progress;
            }
            cnt++;
            if(queue.size()==0) {
                arrayList.add(cnt);
                break;
            }
        }

        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
