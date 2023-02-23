package src.programmers.stackqueue.stackqueue5;

import java.util.*;

public class Kgh {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        //bridge_length 길이의 큐 생성
        //0으로 초기화 
        //한 칸씩 없애고 truck_weights 하나씩 집어넣기
            //집어넣으면서 무게 합 계산하기
            //한 칸 이동할 때마다 시간 1+
        //while(!queue.isEmpty())
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();
        for(int i =1; i<bridge_length; i++){
            queue.add(0);
            
        }
        for(int i=1; i<truck_weights.length; i++){
            wait.add(truck_weights[i]);
        }
        queue.add(truck_weights[0]);
        int sum = truck_weights[0];
        while(!queue.isEmpty()){
            if(wait.peek() != null){
                if(wait.peek() + sum  - queue.peek() <= weight){
                answer++;
                queue.add(wait.peek());
                sum+= wait.poll();
                sum-= queue.poll();
            }
            else{
                answer++;
                queue.add(0);
                sum-= queue.poll();
                
            }
            }else{
                //wait에 더 이상 대기열이 없을 때
                if(sum  - queue.peek() <= weight){
                answer++;
                sum-= queue.poll();
            }
            else{
                answer++;
                sum-= queue.poll();
                
            }
            }
            
        }
        return answer;
    }
}
