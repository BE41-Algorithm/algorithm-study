import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        //검색과 데이터 삽입이 활발해야 함 
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i =0; i<nums.length; i++){
            //해시맵에 포함하고 있지 않을 때
            if(!hash.containsKey(nums[i])){
                hash.put(nums[i],1);
            }
            else{
                hash.replace(nums[i], hash.get(nums[i] + 1));
            }
        }
        /* 
        1. hashmap의 길이가 n/2이상일 경우 
        2. 미만인 경우는 hashmap 길이 리턴
        */
        if(hash.size()>= nums.length/2){
            answer = nums.length/2;
        }
        else{
           answer =  hash.size();
        }

        return answer;
    }
}
