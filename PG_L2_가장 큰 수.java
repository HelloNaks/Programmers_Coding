import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] number=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            number[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(number, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(int i=0;i<numbers.length;i++){
            answer+=number[i];
        }
        if(number[0].equals("0")) return "0";
        return answer;
    }
}
