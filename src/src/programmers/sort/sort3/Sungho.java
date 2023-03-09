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
     * h번 이하 인용된 논문의 개수 < h && h편 이상 인용된 논문의 개수 > h ?
     * [0, 1, 3, 5, 6]
     * 0 > 5
     * 1 > 4
     * 3 > 3
     */

    /**
     * 1. 문제 설명이 이해하기 힘든 문제
     * 2. h-index란? 참고 - https://postechlibrary.tistory.com/489
     * - 전체 논문 중에 많이 인용된 순으로 정렬하여 나열한 후(내림차순)
     * - 인용된 횟수가 논문 번호와 같거나 작아지는 순간의 논문 번호를 h-index라고 함.
     *
     * - 반대로 인용된 횟수를 오름 차순으로 정렬 했다면?
     * - 작성한 논문의 개수부터 1개씩 줄여가면서 인용된 횟수가 적은순으로 차례대로 비교하여 풀 수도 있음
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
