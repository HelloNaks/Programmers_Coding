import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Id[] ids=new Id[id_list.length];
        for(int i=0;i<id_list.length;i++){
            ids[i]=new Id(id_list[i],i,0,0);
        }
        int[] arr = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<>();
        for(int i=0;i<report.length;i++){
            reportSet.add(report[i]);
        }
        String[] reports=new String[reportSet.size()];
        Iterator<String> itera=reportSet.iterator();
        int index=0;
        while(itera.hasNext()){
            reports[index++]=itera.next();
        }
        for(int i=0;i<reports.length;i++){
            String[] s=reports[i].split(" ");
            for(int j=0;j<id_list.length;j++){
                if(s[1].equals(ids[j].name)){
                    ids[j].report++;
                }
                if(s[0].equals(ids[j].name)){
                    ids[j].from++;
                }
            }
        }
        
        Set<String> set=new HashSet<>();
        for(int i=0;i<id_list.length;i++){
            if(ids[i].report>=k){           //해당 유저의 신고받은 횟수가 k이상이면
                set.add(ids[i].name);
            }
        }
        for(int i=0;i<reports.length;i++){
            String[] s = reports[i].split(" ");
            Iterator<String> iter = set.iterator();
            while(iter.hasNext()){
                String temp=iter.next();
                if(temp.equals(s[1])){
                    for(int l=0;l<id_list.length;l++){
                        if(ids[l].name.equals(s[0])){
                            answer[ids[l].index]++;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public class Id{
        String name;
        int index;
        int from;
        int report;
        public Id(String name, int index, int from, int report){
            this.name=name;
            this.index=index;
            this.from=from;
            this.report=report;
        }
    }
}
