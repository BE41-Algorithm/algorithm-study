package src.programmers.stackqueue2;

import java.util.*;

class Chanbin {
    public int[] solution(int[] progresses, int[] speeds) {
        /**
         * progresses : 작업 진척도
         * speeds : 작업 속도
         */

        /* 남은 작업 일수를 비교할 Queue 생성 */
        Queue<Integer> queue = new LinkedList();

        /* 남은 작업 일수를 표시할 dDay 생성 */
        int dDay;

        /* 배포 개수를 체크할 배열 생성 */
        List<Integer> answer = new ArrayList<>();

        /* 각 기능별 남은 작업 일수를 계산 */
        for (int i = 0; i < progresses.length; i++) {
            int pr = progresses[i];
            int sp = speeds[i];

            /* 값이 딱 나눠지지 않으면 작업일 +1 */
            if ((100 - pr) % sp != 0) {
                dDay = (100 - pr) / sp + 1;
            }
            else dDay = (100 - pr) / sp;

            queue.add(dDay);
        }

        /* 한 번에 몇 개의 기능이 배포되는지 저장하는 funcCount 생성 */
        int funcCount = 1;

        /* 먼저 배포되는 기능의 작업일 */
        dDay = queue.poll();

        while (!queue.isEmpty()) {
            /* 앞에 있는 기능보다 뒤에 있는 기능의 작업일이 같거나 빠르면 */
            if (dDay >= queue.peek()) {
                /* 해당 기능을 queue에서 제거 후 배포되는 기능 개수 추가 */
                queue.poll();
                funcCount++;
                /* 앞에 있는 기능보다 뒤에 있는 기능의 작업일이 길면 */
            } else {
                /* deployCount에 배포되는 기능 개수 저장 */
                answer.add(funcCount);

                /* 비교할 기능 교체 */
                dDay = queue.poll();
                funcCount = 1;
            }

            /* Queue가 비었다면 funcCount 저장*/
            if (queue.isEmpty()) answer.add(funcCount);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}