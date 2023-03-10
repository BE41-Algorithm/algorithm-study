package src.programmers.stackqueue.stackqueue6;

import java.util.*;

public class Kgh {
    public int[] solution(int[] prices) {
    // 1.큐로 풀기
         Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i ; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    list.add(queue.size());
                    queue.clear();
                    break;
                } else {
                    queue.add(0);
                }
                if(j == prices.length-1) {
                    //마지막 1초는 더하지 않음
                list.add(queue.size()-1);
                queue.clear();
                }

            }

        }
        list.add(0);
        System.out.println(list.stream().mapToInt(i -> i).toArray());
        return list.stream().mapToInt(i -> i).toArray();
        
        //2. 스택으로 풀기
//         Stack<Integer> beginIdxs = new Stack<>();
//         int i=0;
//         int[] terms = new int[prices.length];

//         beginIdxs.push(i);
//         for (i=1; i<prices.length; i++) {
//             while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
//                 int beginIdx = beginIdxs.pop();
//                 terms[beginIdx] = i - beginIdx;
//             }
//             beginIdxs.push(i);
//         }
//         while (!beginIdxs.empty()) {
//             int beginIdx = beginIdxs.pop();
//             terms[beginIdx] = i - beginIdx - 1;
//         }

//         return terms;
    }
}

//        //3. 어레이리스트로
//        List<Integer> result = new ArrayList<>();
//        for(int i=0; i<prices.length; i++){
//            if( i == prices.length-1){
//                result.add(0);
//                break;
//            }
//            if( i == prices.length-2){
//                result.add(1);
//                continue;
//            }
//            int cnt =0;
//            for(int j =i+1; j<prices.length; j++){
//                if(prices[i] <= prices[j]) cnt++;
//                else{
//                    cnt++;
//                    break;
//                }
//            }
//            result.add(cnt);
//        }
//        int[] answer = result.stream()
//            .mapToInt( i -> i)
//            .toArray();
//
//        return answer;
//    }
//}
