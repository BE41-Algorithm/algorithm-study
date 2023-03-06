package src.programmers.sort.sort3;

import java.util.Arrays;

public class Sungho {
    public static void main(String[] args) {
        Sungho ex = new Sungho();
        System.out.println(ex.solution(new int[]{3, 0, 6, 1, 5}));
    }
    /**
     * 논문 n편 중
     * h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었다면,
     * h의 최댓값이 H-Index
     * h번 이하 인용된 논문의 개수 < h && h편 이상 인용된 논문의 개수 > h
     * [0, 1, 3, 5, 6]
     * 0 > 5
     * 1 > 4
     * 3 > 3
     */
    public int solution(int[] citations) {
        int answer = 0;
        // 인용된 횟수 배열 오름차순 정렬
        Arrays.sort(citations);

        // 논문 순회
        for (int i = 0; i < citations.length; i++) {
            // 남은 논문의 개수
            int h = citations.length - i;

            // 현재 비교 논문의 인용된 횟수가 남은 논문의 개수보다 크거나 같으면
            if (citations[i] >= h) {
                // h 인덱스
                answer = h;
                break;
            }
        }

        return answer;
    }
}
