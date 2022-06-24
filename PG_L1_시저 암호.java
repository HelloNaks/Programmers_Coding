import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] ch= answer.toCharArray();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                answer+=' ';
                continue;
            }
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                if(s.charAt(i)+n<='z'){
                    answer+=(char)(s.charAt(i)+n);
                }else{
                    answer+=(char)(s.charAt(i)+n-26);
                }
            }
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                if(s.charAt(i)+n<='Z'){
                    answer+=(char)(s.charAt(i)+n);
                }else{
                    answer+=(char)(s.charAt(i)+n-26);
                }
            }
        }
        //answer=Arrays.toString(ch);
        return answer;
    }
}
