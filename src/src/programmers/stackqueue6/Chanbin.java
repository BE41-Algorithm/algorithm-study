package src.programmers.stackqueue6;

import java.util.*;

class Chanbin {
    public int[] solution(int[] prices) {
        /* prices 길이만큼의 int 배열 선언 */
        int[] answer = new int[prices.length];

        /* list 선언 */
        List<Integer> list = new ArrayList<>();

        /* pricese를 Queue로 변환 */
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }

        /* 가격을 담을 price */
        int price;

        /* 시간을 담을 second */
        int second = 0;

        while (!queue.isEmpty()) {
            /* 첫 번째 price를 꺼냄 */
            price = queue.poll();

            /* 나머지 queue와 비교 한다 */
            for (Integer next : queue) {
                /* 1개 비교마다 1초 + */
                second++;

                /* 비교한 값이 price보다 작으면 반복문 중단 */
                if (price > next) {
                    break;
                }
            }

            /* second를 list에 담는다 */
            list.add(second);

            /* second를 0으로 초기호ㅑ */
            second = 0;
        }

        /* list를 배열로 변환 */
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}