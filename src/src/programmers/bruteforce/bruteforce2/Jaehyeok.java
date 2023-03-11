package src.programmers.bruteforce.bruteforce2;

import java.util.Arrays;

/*
 * Level 1 : 모의고사
 * */
public class Jaehyeok {
    public static void main(String[] args) {
        Jaehyeok example = new Jaehyeok();
        System.out.println(Arrays.toString(example.solution(new int[]{1, 2, 3, 4, 5}))); // expect : [1]
        System.out.println(Arrays.toString(example.solution(new int[]{1, 3, 2, 4, 2}))); // expect : [1,2,3]
        System.out.println(Arrays.toString(example.solution(new int[]{1, 3, 2, 4, 2}))); // expect : [1,2,3]
        System.out.println(Arrays.toString(example.solution(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}))); // expect : [1,3]
    }
    public int[] solution(int[] answers) {
        int[] answer = new int[3]; // 정답과 수포자패턴이 일치하는 내용을 담는 배열
        int[] supojaOne = new int[]{1, 2, 3, 4, 5};  // 수포자 1 반복패턴 배열
        int[] supojaTwo = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; // 수포자 2 반복패턴 배열
        int[] supojaThree = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 수포자 3 반복패턴 배열

        // 정답을 순회하여 수포자패턴과 일치하면, answer 배열을 카운팅시킴
        for (int i = 0; i < answers.length; i++) {
            if(supojaOne[i % supojaOne.length] == answers[i]) answer[0]++;
            if(supojaTwo[i % supojaTwo.length] == answers[i]) answer[1]++;
            if(supojaThree[i % supojaThree.length] == answers[i]) answer[2]++;
        }

        int max = Arrays.stream(answer).max().getAsInt(); // 카운팅된 최대값을 찾음

        // answer 배열을 순회하여 최댓값과 같은 수포자를 배열에 담고, 그렇지 않은 배열은 0으로 만듬
        for (int j = 0; j < answer.length; j++) {
            if(answer[j] == max) answer[j] = j+1;
            else answer[j] = 0;
        }

        // 최댓값과 다른 배열을 제거하여 반환
        return Arrays.stream(answer).filter(i -> i > 0).toArray();
    }
}
