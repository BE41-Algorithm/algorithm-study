package src.programmers.heap.heap1;

import java.util.PriorityQueue;

/*
 * Level 2 : 더 맵게
 * */
public class Jaehyeok {
    public static void main(String[] args) {
        Jaehyeok example = new Jaehyeok();
        System.out.println(example.solution(new int[]{1, 2, 3, 9, 10, 12},7)); // expect : 2
    }
    public int solution(int[] scoville, int K) {

        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int mixedCount = 0;

        // 배열의 항목을 우선순위 큐에 담음
        for (int i : scoville) {
            heap.add(i);
        }

        while (heap.peek() < K) {
            if (heap.size() == 1) {
                return -1;
            }
                int first = heap.poll(); // 가장 덜매운 것
            int secound = heap.poll(); // 그다음 매운 것
            int mix = first + (secound * 2);
            mixedCount++;
            heap.offer(mix);
        }
        return mixedCount;
    }
}
