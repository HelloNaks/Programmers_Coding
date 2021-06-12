import java.util.Arrays;
import java.util.Collections;

class Solution {
    public Long solution(long n) {
        String N=Long.toString(n);
        long answer = 0;
        char []ch=N.toCharArray();
        int[] a=new int[ch.length];
        for(int i=0;i<ch.length;i++){
            a[i]=(int)ch[i];
        }
        Arrays.sort(a);
        String s = "";
        for(int i=0;i<a.length;i++){
            s+=(char)a[a.length-i-1];
        }
        return Long.parseLong(s);
    }
}
