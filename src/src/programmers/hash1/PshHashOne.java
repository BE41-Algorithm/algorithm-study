package src.programmers.hash1;

import java.util.Arrays;

public class PshHashOne {
    public int solution(int[] nums) {
        /*
        - n / 2 마리를 가져갈 수 있음
        - 가져갈 수 있는 최대 종류의 수를 구해야 함.
        - 중복을 제거했을 때,
            - n / 2 보다 크면 최대 종류는 n / 2
            - n / 2가 크면 중복 제거한 리스트의 길이가 최대 종류
        */

        // 최대 가져갈 수 있는 포켓몬
        int possible = nums.length / 2;

        // 중복 제거
        nums = Arrays.stream(nums)
                .distinct()
                .toArray();

        // 최대 종류
        int value = nums.length;

        return Math.min(possible, value);
        // 아래와 같이도 사용할 수 있음
//        return possible >= value ? value : possible;
    }
}
