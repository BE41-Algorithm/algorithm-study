package src.programmers.hash2;

import java.util.HashMap;

public class PshHashTwo {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 같은 이름의 완주자가 있을 수 있기 때문에 HashMap 사용
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : participant) {
            // key가 없는 경우 1, 있을 경우 +1
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            // 완주한 사람의 1명씩 제거
            hashMap.put(s, hashMap.get(s) - 1);
        }

        for (String s : hashMap.keySet()) {
            // 완주하지 못한 사람
            if (hashMap.get(s) > 0) {
                answer = s;
                break;
            }
        }

        return answer;
    }
}
