package src.programmers.sort.sort1;

import java.util.Arrays;

/*
 * Level 1 : K번째수
 * */
public class Jaehyeok {
    public static void main(String[] args) {
        Jaehyeok example = new Jaehyeok();
        System.out.println(Arrays.toString(example.solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3},{4, 4, 1},{1, 7, 3}}
        ))); // expect : [5,6,3]
    }
    public int[] solution(int[] array, int[][] commands) {

        // commands의 [i,j,k] 원소를 가진다.
        // 반환할 배열을 만든다.
        int[] answer = new int[commands.length];

        // commands 배열 길이만큼 순회를 한다.
        for (int i=0; i<commands.length; i++) {
            int[] cutArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cutArray);
            answer[i] = cutArray[commands[i][2]-1];
        }

        return answer;
    }
}
