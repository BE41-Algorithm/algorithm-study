package src.programmers.hash3;
import java.util.*;

/*
 * Level 2 : 전화번호 목록
 * */
public class Ljh {
    public static void main(String[] args) {
        Ljh example = new Ljh();
        System.out.println(example.solution(new String[]{"119", "97674223", "1195524421"})); // expect : false
        System.out.println(example.solution(new String[]{"123","456","789"})); // expect : true
        System.out.println(example.solution(new String[]{"12","123","1235","567","88"})); // expect : false
    }

    public boolean solution(String[] phone_book) {

        // 방법 1. for문으로 풀기
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;

        // 방법 2. stream으로 풀기
        /*
        // 전화번호부 정렬
        Arrays.sort(phone_book);

        // 첫번째 전화번호를 지정
        String[] startsWith = {phone_book[0]};

        // 첫번째 전화번호부터 비교하여 시작번호가 동일할 경우 false 리턴
        return !Arrays.stream(phone_book)
                .filter(s -> !s.equals(startsWith[0]))
                .map(phone -> {
                    if (phone.startsWith(startsWith[0])) return "false";
                    else startsWith[0] = phone;
                    return "true";
                })
                .collect(Collectors.toList())
                .contains("false");
         */
    }
}
