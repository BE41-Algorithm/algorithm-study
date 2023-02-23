package src.programmers.hash.hash1;
import java.util.*;

/*
* Level 1 : 폰켓몬
* */
public class Ljh {
    public static void main(String[] args) {
        Ljh example = new Ljh();
        System.out.println(example.solution(new int[]{3,1,2,3})); // expect : 2
        System.out.println(example.solution(new int[]{3,3,3,2,2,4})); // expect : 3
        System.out.println(example.solution(new int[]{3,3,3,2,2,2})); // expect : 2
    }

    public int solution(int[] nums) {
        // 골라야하는 폰켓몬 수, 즉 종류가 서로다를 경우 최대 종류의 개수
        int max = nums.length / 2 ;

        // 같은 종류의 폰켓몬은 제거
        Set<Integer> hashSet = new HashSet<>();
        Arrays.stream(nums).forEach(num -> hashSet.add(num));

        // 폰켓몬 종류가 최대 종류의 개수보다 많을 경우 -> 최대종류의 개수 리턴
        // 폰켓몬 종류가 최대 종류의 개수보다 적을 경우 -> 적은종류의 개수 리턴
        return (hashSet.size() > max) ? max : hashSet.size();
    }
}
