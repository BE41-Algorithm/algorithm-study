package src.programmers.stackqueue.stackqueue4;

import java.util.*;

public class Kgh {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            pq.add(priorities[i]);
        }
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    if(i == location){
                        return answer;
                    }
                    else {
                        pq.poll();
                        answer++;
                    }
                }
                
                
            }
        }
        return answer;
    }
}
