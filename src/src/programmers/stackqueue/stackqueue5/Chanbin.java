package src.programmers.stackqueue.stackqueue5;

import java.util.LinkedList;
import java.util.Queue;

class Chanbin {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /**
         * bridge_length : 다리를 건너는데 걸리는 시간
         * weight : 다리를 건널 수 있는 무게
         * truck_weights : 다리를 건너는 트럭들의 무게
         */
        int answer = 0;

        /* truck_weights를 Queue로 변환 */
        Queue<Integer> trucks = new LinkedList<>();

        for (int truckWeight : truck_weights) {
            trucks.add(truckWeight);
        }

        /* 무게 합계 */
        int totalWeight = 0;

        /* 다리를 건너려는 트럭 무게 */
        int truckWeight = 0;

        /* 다리를 건너는 트럭들 */
        Queue<Integer> bridge = new LinkedList<>();

        /* 모든 트럭이 다리를 건널 때까지 반복 */
        while (!trucks.isEmpty()) {

            /* 무게 합계가 weight를 넘지 않고 다리에 오를 트럭 개수가 bridge_length보다 크지 않으면 */
            if (weight >= totalWeight + trucks.peek() && bridge_length >= bridge.size() + 1) {
                /* 맨 앞의 truck을 꺼낸다 */
                truckWeight = trucks.poll();

                /* 무게 합계에 더한다. */
                totalWeight += truckWeight;

                /* 트럭을 다리 위로 올린다 */
                bridge.add(truckWeight);
                /* 만약 조건에 맞지 않다면 다리에 0 값만 추가한다 */
            } else bridge.add(0);

            /**
             * bridge size가 bridge_length와 같으면 다리 위 첫 번째 트럭을 내보낸다. 
             * totalWeight에서 내보낸 트럭의 무게를 뺀다
             * */
            if (bridge.size() == bridge_length) totalWeight -= bridge.poll();

            /* 다리 위로 트럭이 올라가는데 걸리는 시간 +1초 */
            answer++;
        }

        return answer + bridge_length;
    }
}