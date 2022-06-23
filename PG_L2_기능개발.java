import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            int temp;
            if((100 - progresses[i]) % speeds[i]!=0){
                temp = (100 - progresses[i]) / speeds[i] + 1;
            }else {
                temp = (100 - progresses[i]) / speeds[i];
            }
            q.add(temp);
        }
        
        while(!q.isEmpty()){
            int temp = q.poll();
            int cnt=1;
            int size = q.size();
            for(int i=0;i<size;i++){
                if(q.peek()<=temp){
                    q.poll();
                    cnt++;
                }else {
                    break;
                }
            }
            list.add(cnt);
        }
        answer = new int[list.size()];
        int size = list.size();
        for(int i=0;i<size;i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}
