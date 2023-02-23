package src.programmers.hash.hash3;

import java.util.*;
import java.util.stream.Collectors;

class Chanbin {
    public boolean solution(String[] phone_book) {
        /**
         * 1. 배열의 어떤 전화번호가 다른 전화번호의 접두어라면 false
         * 2. 아니라면 true
         */

        /* 접두어가 있는지 체크할 Map을 선언합니다. */
        Map<String, Integer> map = new HashMap();

        /* String 배열을 List로 변환 */
        List<String> list = new ArrayList<>(Arrays.asList(phone_book));

        while (!list.isEmpty()) {
            /* 가장 짧은 전화번호의 길이를 구합니다. */
            int min = list.stream().mapToInt(String::length).min().getAsInt();

            /* 첫 번째 phone과 동일한 길이를 가진 phone 조회 */
            List<String> sameLen = list.stream().filter(p -> p.length() == min).collect(Collectors.toList());

            for (String phone : phone_book) {
                if (phone.length() >= min) {
                    /* 비교하려는 모든 전화번호의 길이를 phone의 길이와 맞춥니다. */
                    phone = phone.substring(0, min);
                }

                /* phone2를 key로 넣고 value를 +1 합니다. */
                map.put(phone, map.getOrDefault(phone, 0) + 1);
            }

            for (String phone : sameLen) {
                /* phone의 value가 2보다 같거나 크다면 phone이 접두어로 포함되었다는 뜻이기 때문에 false를 반환합니다. */
                if (map.get(phone) >= 2) return false;

                /* list에서 해당 phone을 삭제합니다. */
                list.remove(phone);
            }

            /* 반복문이 1회 끝나면 map을 비웁니다. */
            map.clear();
        }

        /* 모든 반복문이 무사히 끝났다면 접두어가 포함된 것이 아니므로 true를 반환합니다. */
        return true;
    }
}