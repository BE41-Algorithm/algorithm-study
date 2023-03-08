package src.programmers.sort.sort2;

import java.util.Arrays;

public class Sungho {
    public static void main(String[] args) {
        Sungho ex = new Sungho();
        int[] numbers = {30, 3, 34, 5, 9};

        System.out.println(ex.solution(numbers));
    }
    public String solution(int[] numbers) {
        // numbers의 길이만큼 String 배열 선언
        String[] answer = new String[numbers.length];

        // int 배열을 String으로 변환하면서 배열에 담음
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = String.valueOf(numbers[i]);
        }

        /**
         * 1. Comparetor와 Comparable은 정렬과 검색 등의 알고리즘에서 사용되는 인터페이스
         * - Comparetor : compare()를 통해 두 매개변수의 객체를 비교할 수 있음, 기본 정렬 외에 다른 기준으로 정렬 가능
         * - compare()를 직접 구현하는 것으로 다른 기준을 만듬
         *
         * - Comparable : compareTo() 메서드를 통해 자기 자신과 인자를 비교할 수 있음, 기본 정렬 기준을 구현(오름차순, 내림차순)
         *
         * 2. 이 문제의 경우 다른 기준으로 정렬을 해야 함.
         * - 문자열을 합쳤을 때 결과를 기준으로 내림차순 정렬해야 함.
         *
         * 3. {30, 3}배열이 있다고 가정한다.
         * - (o2 + o1).compareTo(o1 + o2)
         * - ("303").compareTo("330") - 330이 더 큼.
         * - {3, 30}으로 정렬됨
         *
         * - 참고1) Java에서는 문자열끼리 +연산이 가능함.
         * - 참고2) 문자열끼리의 대소 비교는 compareTo()로 비교 가능함.
         * - compareTo()는 대소 비교로 각 유니코드 값을 비교
         * - "A" < "B", 65 < 66
         * - "1" < "2", 49 < 50
         */

        // 정렬 전 {"30", "3", "34", "5", "9"}
        Arrays.sort(answer, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        // 정렬 후 {"9", "5", "34", "3", "30"}

//        Arrays.sort(answer, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String str1 = o2 + o1;
//                String str2 = o1 + o2;
//
//                System.out.println("str1 = " + str1);
//                System.out.println("str2 = " + str2);
//
//                return str1.compareTo(str2);
//            }
//        });

        // 첫 번쨰 요소가 0이면 이후에 모든 요소도 0임
        if (answer[0].equals("0")) {
            return "0";
        }

        return String.join("", answer);
    }
}
