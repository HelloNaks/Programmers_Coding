import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        
        while(true){
            if(n<3){
                q.offer(n);
                break;
            }
            q.offer(n%3);
            n/=3;
        }
        
        int size = q.size();
        for(int i=0;i<size;i++){
            int temp = q.poll();
            System.out.println(temp);
            answer+= temp*Math.pow(3, size-i-1);
        }
        return answer;
    }
}
