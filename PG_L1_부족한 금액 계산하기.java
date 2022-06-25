class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long cnt=0;
        for(int i=1;i<=count;i++){
            cnt += i;
        }
        answer = cnt*price;
        if(answer>money){
            return answer-money;
        }else{
            return 0;
        }
    }
}
