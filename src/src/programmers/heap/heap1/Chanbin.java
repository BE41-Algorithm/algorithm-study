package src.programmers.heap.heap1;

import java.util.PriorityQueue;

class Chanbin {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        /* 우선순위 큐에 scoville을 담는다. */
        for (int sc : scoville) {
            pq.add(sc);
        }

        /* 섞은 음식의 스코빌 지수 */
        int mixedScoville;

        /* 섞은 횟수 */
        int mixedCount = 0;

        /* pq에서 가장 작은 값이 K보다 작으면 반복문 실행 */
        while (pq.peek() < K) {
            /* pq의 사이가 1일 때까지 반복되었다는건 K이상의 스코빌 지수를 낼 수 없다는 의미 */
            if (pq.size() == 1) return -1;

            /* 섞은 음식의 스코빌 지수 계산법 실행 */
            mixedScoville = pq.poll() + (pq.poll() * 2);

            /* pq에 섞은 음식의 스코빌 지수 추가 */
            pq.add(mixedScoville);

            /* 섞은 횟수 +1 */
            mixedCount++;
        }
        return mixedCount;
    }
}
