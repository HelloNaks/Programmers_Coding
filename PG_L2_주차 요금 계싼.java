import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Set<String> set = new TreeSet<>();
        List<Parking> list = new LinkedList<>();
        for(int i=0;i<records.length;i++){
            String[] s = records[i].split(" ");
            String[] time=s[0].split(":");
            int minute=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            String carnum=s[1];
            boolean input;
            if(s[2].equals("IN")){
                input=true;
            }else{
                input=false;
            }
            list.add(new Parking(minute, carnum, input));
            set.add(s[1]);
        }
        Iterator<String> iter = set.iterator();
        Map<String, Integer> map = new TreeMap<>();
        Map<String, Boolean> visited = new TreeMap<>();
        while(iter.hasNext()){
            String temp=iter.next();
            map.put(temp,0);
            visited.put(temp, false);
        }
        int[] answer = new int[set.size()];
        for(int i=0;i<list.size();i++){
            if(!list.get(i).input){
                visited.put(list.get(i).carnum,false);
                for(int j=i-1;j>=0;j--){
                    if(list.get(i).carnum.equals(list.get(j).carnum)){
                        int tempmin=map.get(list.get(i).carnum);
                        int temp=list.get(i).minute-list.get(j).minute;
                        map.put(list.get(i).carnum,temp+tempmin);
                        break;
                    }
                }
            }else{
                visited.put(list.get(i).carnum,true);
            }
        }
        Iterator<Map.Entry<String, Boolean>> iters = visited.entrySet().iterator();
        while(iters.hasNext()){
            Map.Entry<String, Boolean> tempMap = iters.next();
            if(tempMap.getValue()){
                for(int i=records.length-1;i>=0;i--){
                    if(tempMap.getKey().equals(list.get(i).carnum)){
                        int minute=23*60+59-list.get(i).minute;
                        int temp=map.get(list.get(i).carnum);
                        map.put(list.get(i).carnum,temp+minute);
                        break;
                    }
                }
            }
        }
        Iterator<Integer> ite = map.values().iterator();
        
        for(int i=0;i<answer.length;i++){
            int minute = ite.next();
            if(minute<=fees[0]){
                answer[i]=fees[1];
            }else{
                answer[i]+=fees[1];
                minute-=fees[0];
                if(minute%fees[2]!=0){
                    int temp1=minute/fees[2];
                    answer[i]+=fees[3]*(temp1+1);
                }else{
                    int temp1=minute/fees[2];
                    answer[i]+=fees[3]*temp1;
                }
            }
        }
        return answer;
    }
    
    public class Parking{
        int minute;
        String carnum;
        boolean input;
        public Parking(int minute, String carnum, boolean input){
            this.minute=minute;
            this.carnum=carnum;
            this.input=input;
        }
    }
}
