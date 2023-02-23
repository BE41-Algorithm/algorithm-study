package src.programmers.stackqueue.stackqueue4;

import java.util.*;

/*
* LEVEL 2 스택/큐 : 프린터
* */
public class JaeHyeok {
    public static void main(String[] args) {
        JaeHyeok example = new JaeHyeok();
        System.out.println(example.solution(new int[]{2, 1, 3, 2},2)); // expect : 1
        System.out.println(example.solution(new int[]{1, 1, 9, 1, 1, 1},0)); // expect : 5
    }

    private int solution(int[] priorities, int location) {

        // 문제의 핵심.
        // 높은 숫자가 중요도가 높은 것이다.
        // 대기문서에서 꺼낸 문서가 대기열에 있는 문서보다 중요도가 낮으면 맨뒤로간다.
        Queue<Integer> important = new LinkedList<>(); // 우선순위를 담는 Queue
        Queue<Integer> document = new LinkedList<>(); // 문서를 위치를 담는 Queue
        List<Integer> result = new ArrayList<>(); // 프린트를 완료한 List
        int maxDoc = 0;

        // 우선순위, 문서를 Queue에 담는다.
        for (int i=0; i<priorities.length; i++) {
            important.add(priorities[i]);
            document.add(i);
        }

        while (important.size() != 0) { // Queue의 담긴게 없으면 반복문을 탈출
            Integer print = important.poll(); // 대기열의 중요도를 하나씩 빼온다
            Integer target = document.poll(); // 대기열의 문서위치를 하나씩 빼온다
            if(important.size() >= 1) {
                maxDoc = important.stream().mapToInt(i -> i).max().getAsInt(); // 현재 우선순위가 가장 높은 숫자
            }
            if(print >= maxDoc) {
                result.add(target); // 우선순위가 높을경우 프린트 완료 List에 문서위치를 담는다.
            } else {
                important.add(print); // 우선순위가 아닐경우 우선순위를 마지막에 넣는다.
                document.add(target); // 우선순위가 아닐경우 문서위치를 마지막에 넣는다.
            }
        }

        return result.indexOf(location) + 1;
    }
}
