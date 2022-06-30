import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for(int i=0;i<str1.length()-1;i++){
            String temp = str1.substring(i,i+2);
            if((temp.charAt(0)>='a' && temp.charAt(0)<='z')){
                if(temp.charAt(1)>='a' && temp.charAt(1)<='z'){
                    list1.add(temp);
                }
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            String temp = str2.substring(i,i+2);
            if(temp.charAt(0)>='a' && temp.charAt(0)<='z'){
                if(temp.charAt(1)>='a' && temp.charAt(1)<='z'){
                    list2.add(temp);
                }
            }
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        List<String> sameList = new ArrayList<>();
        List<String> allList = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            String ad = list1.get(i);
            if(list2.remove(ad)){
                sameList.add(ad);
            }
             allList.add(ad);
        }
        
        for(int i=0;i<list2.size();i++){
            allList.add(list2.get(i));
        }
        if(allList.size()!=0){
            answer = 65536*sameList.size()/allList.size();
            System.out.println(sameList.size()+" "+allList.size());
        }else{
            answer = 1*65536;
        }
        return answer;
    }
}
