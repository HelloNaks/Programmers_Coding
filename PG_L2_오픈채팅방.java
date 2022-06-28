import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        
        for(int i=0;i<record.length;i++){
            String[] s = record[i].split(" ");
            if(!s[0].equals("Leave")){
                map.put(s[1],s[2]);
            }
        }
        for(int i=0;i<record.length;i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")){
                String temp = "";
                temp+=map.get(s[1]) +"님이 들어왔습니다.";
                list.add(temp);
            }else if(s[0].equals("Leave")){
                String temp = "";
                temp+= map.get(s[1]) + "님이 나갔습니다.";
                list.add(temp);
            }
        }
        String[] answer = new String[list.size()];
        int cnt=0;
        for(String s: list){
            answer[cnt++] = s;
        }
        // answer = list.toArray();
        return answer;
    }
}
