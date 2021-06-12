import java.util.*;
class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String N=Long.toString(n);
        char[] ch=N.toCharArray();
        answer=new int[ch.length];
        for(int i=0;i<ch.length;i++){
            answer[i]=(int)(ch[ch.length-i-1]-'0');
        }
        return answer;
    }
}
