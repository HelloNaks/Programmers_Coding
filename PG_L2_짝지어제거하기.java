import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.size()==0 || stack.peek()!=s.charAt(i)){
                stack.add(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        if(stack.size()!=0){
            return 0;
        }else{
            return 1;
        }
    }
}
