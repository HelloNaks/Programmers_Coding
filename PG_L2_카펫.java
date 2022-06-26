import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i=1;i<=yellow;i++){
            if(yellow%i==0){
                map.put(i,yellow/i);
            }
        }
        Iterator<Map.Entry<Integer,Integer>> iter = map.entrySet().iterator();
        int r=0;
        int c=0;
        while(iter.hasNext()){
            Map.Entry<Integer, Integer> m = iter.next();
            int a = m.getKey();
            int b = m.getValue();
            if(brown==2*(a+b+2)){
                r=a+2;
                c=b+2;
                
                answer[0]=r;
                answer[1]=c;
            }
        }
        return answer;
    }
}
