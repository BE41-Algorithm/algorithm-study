package src.programmers.hash1;

import java.util.HashMap;
import java.util.Map;

class Chanbin {
    public int solution(int[] nums) {
        int answer = 0;

        /**
         * 1. N 마리의 포켓몬 중에서 N/2 마리를 가질 수 있습니다.
         * 2. 포켓몬은 종류에 따라 번호로 구별됩니다.
         * 3. 동일한 종류의 포켓몬이 2마리 이상 들어갈 수 있습니다.
         * 4. 가장 많은 종류의 포켓몬을 선택하는 방법을 찾아, 종류 번호의 개수를 리턴해주세요.
         */

        /* 가질 수 있는 포켓몬 마리의 수를 구합니다. */
        int pickCount = nums.length / 2;

        /* 포켓몬 종류별 개수를 체크할 Map을 생성합니다. */
        Map<Integer, Integer> map = new HashMap<>();

        /* 포켓몬 종류별로 저장합니다. key: 포켓몬 종류 번호, value: 해당 종류의 포켓몬 마리 수 */
        for (int type : nums) map.put(type, map.getOrDefault(type, 0) + 1);

        /* 몇 종류의 포켓몬이 존재하는지 체크합니다. */
        int typeCount = map.size();

        /* 가질 수 있는 포켓몬 마리 수와 포켓몬 총 종류 수를 비교하여 더 작은 값을 반환합니다 */
        return Math.min(pickCount, typeCount);
    }
}