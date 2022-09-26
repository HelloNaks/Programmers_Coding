class Solution {
    public int solution(int n) {
        int answer = 0;
        int st=1;
        int end=1;
        int num=1;
        while(true){
            if(end>n || st>n) break;
            if(num==n) {
                answer++;
                end++;
                num+=end;
            }else if(num>n){
                num-=st;
                st++;
            }else{
                end++;
                num+=end;
            }
        }
        return answer;
    }
}
