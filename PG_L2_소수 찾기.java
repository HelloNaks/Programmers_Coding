import java.util.*;
class Solution {
    Set<Integer> set;
    boolean[] visited;
    public int solution(String numbers) {
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        back(0,numbers,"");
        return set.size();
    }
    public void back(int cnt, String numbers, String current){
        if(cnt==numbers.length()){
            return;
        }
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                String number = current + numbers.charAt(i);
                
                if(isPrime(number)){
                    set.add(Integer.parseInt(number));
                }
                
                back(cnt+1,numbers,number);
                visited[i]=false;
            }
        }
    }
    public boolean isPrime(String current){
        int num = Integer.parseInt(current);
        for(int i=2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        if(num<=1) return false;
        return true;
    }
}
