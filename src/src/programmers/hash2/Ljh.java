package src.programmers.hash2;

import java.util.*;

/*
 * Level 1 : 완주하지 못한 선수
 * */
public class Ljh {
    public static void main(String[] args) {
        src.programmers.hash2.Ljh example = new src.programmers.hash2.Ljh();
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
    }
}