class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0]=GCD(n, m);
        answer[1]=n*m/answer[0];
        return answer;
    }
    
    public int GCD(int num1, int num2){
        while(num2!=0){
            int r=num1%num2;
            num1=num2;
            num2=r;
        }
        return num1;
    }
}
