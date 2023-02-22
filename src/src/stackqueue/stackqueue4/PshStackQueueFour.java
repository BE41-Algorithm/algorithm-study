package src.stackqueue.stackqueue4;


import java.util.*;

public class PshStackQueueFour {
    public int solution(int[] priorities, int location) {
        // 우선순위 큐 선언(내림 차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        // 우선순위 큐에 값 추가
        for (int priority : priorities) {
            pq.offer(priority);
        }

        // 큐가 빌때까지 순회
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // 큐 다음 값이 priorities 배열과 같으면 꺼내기
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;

                    // 내가 요청한 문서
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
