import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int arr_num=0;
        int temp=0;
        int length=0;
        Queue<Integer> q = new LinkedList<Integer>();
        int[] answer = {};
        q.offer(arr[0]);
        temp=arr[0];
        length++;
        while(arr_num<arr.length){
            if(temp==arr[arr_num]){
                arr_num++;
            }else{
                q.offer(arr[arr_num]);
                temp=arr[arr_num];
                arr_num++;
                length++;
            }
        }
        answer=new int[length];
        for(int i=0;i<length;i++){
            answer[i]=q.poll();
        }
        return answer;
    }
}
