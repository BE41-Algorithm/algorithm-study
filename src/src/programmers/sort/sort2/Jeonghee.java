import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] list = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            list[i] = (String.valueOf(numbers[i]));
        }
        Arrays.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return ( o2+ o1).compareTo(o1 + o2);
            }
        });
        for(int i=0; i<list.length; i++){
            answer+= list[i];
        }
        if(answer.charAt(0)== '0') return "0";
        return answer;
    }
}
