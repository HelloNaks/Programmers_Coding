class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int temp=nums[i]+nums[j]+nums[k];
                    boolean flag=false;
                    for(int l=2;l<temp;l++){
                        if(temp%l==0){
                            flag=true;
                        }
                    }
                    if(flag){
                        continue;
                    }else{
                        answer++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}
