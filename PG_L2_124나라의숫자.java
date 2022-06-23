class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr={"4","1","2"};
        int num=n;
        while(num>0){
            int mod = num%3;
            num /= 3;
            if(mod==0){
                num--;
            }
            answer=arr[mod]+answer;
        }
        return answer;
    }
}
