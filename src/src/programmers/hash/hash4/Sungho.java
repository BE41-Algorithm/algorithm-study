package src.programmers.hash.hash4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Sungho {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        // 의상 종류의 개수 담기
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        /**
         * 종류별 경우의 수
         * 상의와 하의가 있는 경우
         * 상의만 입거나 하의만 입을 수도 있음
         * 최소 1개 이상은 입어야 함 - 아무 것도 입지 않은 경우를 뺴야함
         * ((상의 + 1) * (하의 + 1)) - 1
         */
        Iterator<Integer> it = map.values().iterator();

        while (it.hasNext()) {
            answer *= it.next() + 1;
        }

        return answer - 1;
    }
}
