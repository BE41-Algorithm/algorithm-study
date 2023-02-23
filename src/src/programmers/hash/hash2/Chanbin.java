package src.programmers.hash.hash2;

import java.util.HashMap;
import java.util.Map;

class Chanbin {
    public String solution(String[] participant, String[] completion) {
        /**
         * 1. 단 한 명만 마라톤을 완주하지 못합니다.
         * 2. completion의 길이는 participant의 길이보다 1 작습니다.
         * 3. 참가자 중 동명이인이 있을 수 있습니다.
         */
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        /* 중복된 선수 이름이 있을 수 있기 때문에 +1 */
        for (String s1 : participant) map.put(s1, map.getOrDefault(s1, 0) + 1);

        /* 완주한 선수의 value는 0, 완주하지 못한 선수의 value는 1 */
        for (String s2 : completion) map.put(s2, map.get(s2) - 1);

        /* Map을 순회하여 value가 1인 key를 조회 */
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
