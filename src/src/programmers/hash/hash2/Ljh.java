package src.programmers.hash.hash2;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Level 1 : 완주하지 못한 선수
 * */
public class Ljh {
    public static void main(String[] args) {
        src.programmers.hash.hash2.Ljh example = new src.programmers.hash.hash2.Ljh();
        System.out.println(example.solution(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"} // expect : leo
        ));
        System.out.println(example.solution(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}) // expect : vinko
        );
        System.out.println(example.solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"} // expect : mislav
        ));
    }
    public String solution(String[] participant, String[] completion) {

        // 방법 1). groupingBy를 이용한 카운팅
        // 참가자를 카운팅으로 그룹핑 시켜 Map으로 반환
        Map<String, Long> hashMap = Arrays.stream(participant)
                .collect(Collectors.groupingBy(person -> person, Collectors.counting()));

        // 완주자 목록으로 참가자를 비교해 Map에서 제거하기
        Arrays.stream(completion)
                .forEach(person -> {
                            if (hashMap.get(person) == 1L) hashMap.remove(person);
                            else hashMap.put(person, hashMap.get(person) - 1);
                        });
        return hashMap.keySet().iterator().next();

        // 방법 2). getOrDefault를 이용한 카운팅
        /*
        String answer = "";
        Map<String, Integer> hashMap = new HashMap<>();

        // 참가자 체크 (동명인이 있을 경우 value값 1씩 증가)
        Arrays.stream(participant)
                .forEach(person -> hashMap.put(person, hashMap.getOrDefault(person,0)+1));

        // 완주자 체크 (참가자 중 완주한 사람은 value값을 1씩 감소)
        Arrays.stream(completion)
                .forEach(person -> hashMap.put(person, hashMap.get(person)-1));

        // 값이 0이 아닐경우는 완주하지 못한 것으로 간주
        for(String key : hashMap.keySet()){
            if(hashMap.get(key) != 0){
                answer = key;
            }
        }
        return answer;
        */
    }
}