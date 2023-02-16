import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //ArrayList<String> comple= new ArrayList<String>(Arrays.asList(completion));
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<participant.length; i++){
            if(!(participant[i].equals(completion[i]))){
                answer+= participant[i];
                break;
        //동명이인 해결 불가
        // String answer = "";
        // List<String> p = Arrays.asList(completion);
        // for(String folks: participant){
        //     if(!p.contains(folks)){
        //         answer = folks;
        //     }
        // }
        // return answer;
        String answer ="";
        HashMap<String, Integer> map = new HashMap<>();
        for(String p: participant){
            if(map.containsKey(p)){
                map.replace(p, map.get(p)+1);
            }
            else{
                map.put(p,1);
            }
        }
        for(String c: completion){
            map.replace(c, map.get(c)-1);
        }
        for(String s : map.keySet()){
            if(map.get(s) != 0) answer= s;
        }

        return answer;
    }
}
