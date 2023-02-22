package src.stackqueue.stackqueue5;

import java.util.LinkedList;
import java.util.Queue;

public class PshStackQueueFive {
    public static void main(String[] args) {
        PshStackQueueFive ex = new PshStackQueueFive();
        System.out.println(ex.solution(2, 10, new int[]{7, 4, 5, 6}));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /**
         * weight = 다리가 견딜 수 있는 무게
         * bridge_length = 다리에 올라갈 수 있는 트럭 수
         * truck_weights = 대기 중인 트럭의 무게 배열
         */
        Queue<Integer> queue = new LinkedList<>(); // 다리를 건너는 트럭을 담을 큐
        int time = 0; // 총 시간
        int curWeight = 0; // 다리를 건너는 트럭들의 무게

        // 대기중인 트럭 순회
        for (int truckWeight : truck_weights) {
            while (true) {
                // 다리를 건너는 트럭이 없으면(큐가 비어있는 경우)
                if (queue.isEmpty()) {
                    queue.offer(truckWeight); // 트럭 큐에 담기
                    curWeight += truckWeight; // 무게 추가
                    time++; // 시간 증가
                    break;
                // 다리의 길이만큼 트럭이 추가된 경우(큐가 꽉찬 경우)
                } else if (queue.size() == bridge_length) {
                    curWeight -= queue.poll(); // 큐에서 값을 빼면서 해당 무게만큼 감소
                // 트럭이 다리를 지나갈 수 있는 경우(큐가 꽉차지 않은 경우)
                } else {
                    // 현재 큐의 무게 + 다음 트럭의 무게 <= 다리가 견딜 수 있는 무게
                    if (curWeight + truckWeight <= weight) {
                        queue.offer(truckWeight); // 트럭 큐에 담기
                        curWeight += truckWeight; // 무게 추가
                        time++; // 시간 증가
                        break;
                    } else { // 다리가 견딜 수 있는 무게를 초과한 경우
                        queue.offer(0); // 무게가 0인 큐 담기
                        time++; // 시간 증가
                    }
                }
            }
        }

        // 마지막 트럭이 다리를 통과하는 시간
        return time + bridge_length;
    }
}
