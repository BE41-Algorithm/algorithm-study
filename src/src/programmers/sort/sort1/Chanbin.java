package src.programmers.sort.sort1;

import java.util.Arrays;

public class Chanbin {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution solution = new Solution();
        int[] answer = solution.solution(arr, commands);

        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int[] arr, int[][] commands) {
        // 명령 갯수만큼의 배열을 생성한다.
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            // 자를 배열의 첫 번째 인덱스(
            int start = commands[i][0] - 1;

            // 자를 배열의 마지막 인덱스
            int end = commands[i][1];

            // 인덱스는 0부터 시작하기때문에 -1을 해준다.
            int idx = commands[i][2] - 1;

            // command대로 배열을 자른다.
            int[] slice = Arrays.copyOfRange(arr, start, end);

            // 자른 배열을 정렬한다.
            Arrays.sort(slice);

            // idx번째 값을 answer에 넣는다.
            answer[i] = slice[idx];
        }

        return answer;
    }
}
