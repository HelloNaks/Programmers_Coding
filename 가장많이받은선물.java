import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[friends.length];
        for(int i=0;i<friends.length;i++){
            map.put(friends[i], i+1);
        }
        int[][] arr = new int[friends.length][friends.length];
        int[] give = new int[friends.length];
        int[] receive = new int[friends.length];
        int[] ind = new int[friends.length];
        int[] next = new int[friends.length];
        
        for(int i=0;i<gifts.length;i++){
            String[] s = gifts[i].split(" ");
            arr[map.get(s[0])-1][map.get(s[1])-1]++;
        }
        
        for(int i=0;i<friends.length;i++){
            for(int j=0;j<friends.length;j++){
                give[i] += arr[i][j];
                receive[i] += arr[j][i];
            }
            ind[i] = give[i] - receive[i];
            // System.out.println(ind[i]);
        }
        
        
        for(int i=0;i<friends.length-1;i++){
            for(int j=i+1;j<friends.length;j++){
                // System.out.println(i+" "+j);
                if(i==j) continue;
                if(arr[i][j]>arr[j][i]){
                    next[i]++;
                    // System.out.println("1: "+i+" "+j);
                }else if(arr[i][j]<arr[j][i]){
                    next[j]++;
                    // System.out.println("2: "+i+" "+j);
                }else{
                    if(ind[i]<ind[j]){
                    // System.out.println("3: "+i+" "+j);
                        next[j]++;
                    }else if(ind[i]>ind[j]){
                    // System.out.println("4: "+i+" "+j);
                        next[i]++;
                    }else continue;
                }
            }
        }
        int max = 0;
        for(int i=0;i<friends.length;i++){
            if(max<next[i]){
                max = next[i];
            }
        }
        return max;
    }
}
