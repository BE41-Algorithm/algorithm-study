package src.programmers.hash.hash1;

import java.util.HashSet;

public class Sungho {
    public int solution(int[] nums) {
        // hashSet 생성
        HashSet<Integer> hashSet = new HashSet<>();

        // hashSet에 포켓몬 담기(중복 제거됨)
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }



        // 둘 중 작은 것이 최대 종류
        return Math.min(hashSet.size(), nums.length / 2);
    }
}
