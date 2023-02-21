package src.programmers.stackqueue5;


import java.util.*;

/*
 * LEVEL 2 스택/큐 : 다리를 지나는 트럭
 * */
public class JaeHyeok {
    public static void main(String[] args) {
        JaeHyeok example = new JaeHyeok();
        System.out.println(example.solution(2, 10, new int[]{7,4,5,6})); // expect : 8
        System.out.println(example.solution(100, 100, new int[]{10})); // expect : 101
        System.out.println(example.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10})); // expect : 110
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int sum = 0; // 다리를 건너는 트럭들의 무게 합

        for(int t : truck_weights) {

            while(true) {
                //큐가 비어있다면 다음 트럭 삽입
                if(q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                }
                // 큐가 트럭이 꽉차있을 경우
                else if(q.size() == bridge_length) {
                    sum -= q.poll(); // 큐의
                }
                //큐가 비어있지 않을 때
                else {
                    //다음 트럭이 최대 무게 초과
                    if(sum + t > weight) {
                        q.offer(0);
                        answer++;
                    }
                    //다음 트럭이 최대 무게 이내
                    else {
                        q.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        //걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
        return answer + bridge_length;
    }
}
