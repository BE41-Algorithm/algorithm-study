package src.programmers.heap.heap3;

import java.util.Collections;
import java.util.PriorityQueue;

class Chanbin {
    public int[] solution(String[] operations) {
        // 최솟값 삭제용 pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 최댓값 삭제용 reversePq
        PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());

        // 명령어 실행
        for (String operation : operations) {
            // 최솟값 삭제 명령
            if (operation.equals("D -1")) {
                // pq가 비어있지 않으면
                if (!pq.isEmpty()) {
                    // pq에서 가장 작은 값을 추출한 후 reverserPq에서도 동일한 값을 삭제한다.
                    Integer num = pq.poll();
                    reversePq.remove(num);
                }
                // 최댓값 삭제 명령
            } else if (operation.equals("D 1")) {
                // pq가 비어있지 않으면
                if (!pq.isEmpty()) {
                    // reversePq에서 최댓값을 추출한 후 pq에서도 동일한 값을 삭제한다.
                    Integer num = reversePq.poll();
                    pq.remove(num);
                }
                // 값을 추가하는 명령
            } else {
                // 문자열에서 "I "를 제거 후 Integer로 변환
                String s = operation.replace("I ", "");
                int num = Integer.parseInt(s);

                // pq와 reversePq에 값을 넣는다.
                pq.add(num);
                reversePq.add(num);
            }
        }

        // pq가 비어있다면 [0, 0]을 반환한다.
        if (pq.isEmpty()) {
            return new int[]{0, 0};
        }
        // 값이 있다면 [최댓값, 최솟값]을 반환한다.
        return new int[]{reversePq.poll(), pq.poll()};
    }
}