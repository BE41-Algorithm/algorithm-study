package src.programmers.hash3;

import java.util.HashMap;

public class PshHashThree {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 모든 phone 번호 hashMap에 담기
        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            // 전화번호의 길이만큼 순회
            for (int j = 0; j < phone_book[i].length(); j++) {
                // 해당 전화번호의 접두어가 key로 가진 경우
                if (hashMap.containsKey(phone_book[i].substring(0,j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
