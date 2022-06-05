import java.util.*;

class Solution {
    public int maxSheepCount;
    public ArrayList<Integer>[] childs;
    
    public int solution(int[] info, int[][] edges) {
        childs = new ArrayList[info.length];
        
        for(int[] link : edges){
            int parent = link[0];
            int child = link[1];
            
            if(childs[parent] == null) {
                childs[parent] = new ArrayList<>();
            }
            childs[parent].add(child);
        }
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        DFS(0, 0, 0, nextNodes, info);
        
        return maxSheepCount;
    }
    
    public void DFS(int sheepCount, int wolfCount, int node, List nextNodes, int[] info){
        sheepCount += info[node] == 1?0:1;
        wolfCount += info[node];
        maxSheepCount = Math.max(maxSheepCount, sheepCount);
        
        if(sheepCount <= wolfCount) {
            return;
        }
        
        List<Integer> temp = new ArrayList<>();
        temp.addAll(nextNodes);
        
        if(childs[node] != null){
            temp.addAll(childs[node]);
        }
        temp.remove(Integer.valueOf(node));
        
        for(int nextNode : temp){
            DFS(sheepCount, wolfCount, nextNode, temp, info);
        }
    }
}
