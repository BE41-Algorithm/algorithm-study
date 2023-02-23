package src.programmers.stackqueue.stackqueue4;

import java.util.*;

class Chanbin {
    public int solution(int[] priorities, int location) {
        /**
         * 1. 대기목록 맨 앞에 있는 문서를 꺼냅니다.
         * 2. 꺼낸 문서보다 대기 목록의 문서가 중요도가 더 높다면 꺼낸 문서를 마지막에 넣습니다.
         * 3. 그렇지 않으면 꺼낸 문서를 출력한다
         */
        /* 우선순위 큐 사용 */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        /* 배열 순회 */
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        /* 큐가 비어있지 않으면 */
        while (!pq.isEmpty()) {
            /* 대기열 순회 */
            for (int i = 0; i < priorities.length; i++) {
                /* 대기열 i번째 문서의 중요도와 큐 첫 번째 문서의 중요도가 같으면 */
                if (priorities[i] == pq.peek()) {
                    /* i와 location이 같으면 */
                    if (i == location) {
                        /* 출력 순서 +1 */
                        answer++;
                        return answer;
                    }
                    /* 큐 첫 번째 문서 삭제 */
                    pq.poll();

                    /* 출력 순서 +1 */
                    answer++;
                }
            }
        }
        return -1;
    }
}