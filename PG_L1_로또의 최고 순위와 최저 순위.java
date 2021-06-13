import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int min=0;
        int num_0=0;
        int temp0=0;
        int temp1=0;
        for(int i=0;i<6;i++){
            if(lottos[i]==0){
                num_0++;
            }
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j]){
                    min++;
                }
            }
        }
        temp0=min+num_0;
        temp1=min;
        
        answer[0]=Math.min(7-temp0,6);
        answer[1]=Math.min(7-temp1,6);
        return answer;
    }
}
