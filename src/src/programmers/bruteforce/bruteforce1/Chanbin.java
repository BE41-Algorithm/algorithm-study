package src.programmers.bruteforce.bruteforce1;

public class Chanbin {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        Solution solution = new Solution();
        int answer = solution.solution(sizes);

        System.out.println(answer);
    }
}

class Solution {
    /**
     * 1. 모든 카드를 담을 카드 지갑을 만들어야 한다.
     * 2. 카드는 가로 세로를 돌릴 수 있다.
     * 3. 각 카드마다 긴 길이와 짧은 길이를 분류한다.
     * 4. 모든 카드들을 비교하여 긴 길이 중 가장 큰 값과 짧은 길이 중 가장 큰 값을 구한다.
     * 5. 두 값을 곱한다.
     */

    int bigSize;
    int smallSize;

    public int solution(int[][] sizes) {
        int width;
        int height;
        int bigSizeMax = 0;
        int smallSizeMax = 0;

        for (int i = 0; i < sizes.length; i++) {
            width = sizes[i][0];
            height = sizes[i][1];
            compareToSize(width, height);
            bigSizeMax = max(bigSizeMax, bigSize);
            smallSizeMax = max(smallSizeMax, smallSize);
        }

        return bigSizeMax * smallSizeMax;
    }

    private void compareToSize(int width, int height) {
        bigSize = Math.max(width, height);
        smallSize = Math.min(width, height);
    }

    private int max(int lengthMax, int longLength) {
        return Math.max(lengthMax, longLength);
    }
}
