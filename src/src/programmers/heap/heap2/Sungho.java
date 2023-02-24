package src.programmers.heap.heap2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sungho {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        Sungho ex = new Sungho();

        System.out.println(ex.solution(jobs));
    }

    public int solution(int[][] jobs) {
        /**
         * [작업의 요청 시점, 작업의 소요 시간]
         * jobs = {{0, 3}, {1, 9}, {2, 6}
         */
        int answer = 0;
        int end = 0; // 작업의 수행 직후 시간
        int idx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 작업 개수

        // 우선순위 큐 : 작업의 소요 시간을 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // == new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        // jobs 배열 : 작업의 요청 시점을 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // == Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        // 작업이 끝날 때 까지 순회
        while (count < jobs.length) {

            // 작업 중 요청된 작업(end 보다 작은 요청 시점을 가진 것) pq에 담기
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.offer(jobs[idx++]);
            }

            // 요청된 작업이 없는 경우
            if (pq.isEmpty()) {
                 end = jobs[idx][0]; // 다음 작업의  요청 시점이 곧 작업의 수행 직후 시간
            } else { // 요청된 작업이 있는 경우
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0]; // 작업 요청부터 종료까지 걸린 시간 더하기
                end += temp[1]; // 작업의 처리 완료 시간
                count++; // 처리된 작업 개수 증가
            }
        }

        return answer / jobs.length;
    }
}
