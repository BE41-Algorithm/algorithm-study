package src.programmers.sort.sort3;

import java.util.Arrays;

/*
* Level 2 : H-Index
* */
public class Jaehyeok {
    public static void main(String[] args) {
        Jaehyeok example = new Jaehyeok();
        System.out.println(example.solution(new int[]{3, 0, 6, 1, 5})); // expect : 3
    }
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i=0; i<citations.length; i++) {
            int index = citations.length-i;

            if (citations[i] >= index) {
                answer = index;
                break;
            }
        }
        return answer;
    }
}
