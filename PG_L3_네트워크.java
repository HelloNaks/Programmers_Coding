class Solution {
    int answer = 0;
    public int solution(int n, int[][] computers) {
        
        boolean[] visited=new boolean[computers.length];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                visited[i]=true;
                dfs(n, i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int n, int k, int[][] computers, boolean[] visited) {
        for(int i=0;i<computers.length;i++){
            if(k==i) continue;
            if(computers[k][i]==1 && !visited[i]){
                visited[i]=true;
                dfs(n,i,computers,visited);
            }
        }
    }
}
