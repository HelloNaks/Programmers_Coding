import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = run(n,k);
        StringTokenizer st = new StringTokenizer(s,"0");
        //String[] st = s.split("0");
        Long[] longlist = new Long[st.countTokens()];
        int index=0;
        while(st.hasMoreTokens()){
            longlist[index++]=Long.parseLong(st.nextToken());
        }
        
        for(int i=0;i<longlist.length;i++){
            if(isPrime(longlist[i])){
                answer++;
            }
        }
        
        return answer;
    }
    public boolean isPrime(long num){
        if(num==1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public String run(int n, int k){
        String temp="";
        List<String> list = new LinkedList<>();
        while(true){
            if(n<k){
                list.add(Integer.toString(n));
                break;
            }else{
                int a=n/k;
                int b=n%k;
                list.add(Integer.toString(b));
                n=a;
            }
        }
        for(int i=0;i<list.size();i++){
            temp+=list.get(list.size()-i-1);
        }
        return temp;
    }
}
