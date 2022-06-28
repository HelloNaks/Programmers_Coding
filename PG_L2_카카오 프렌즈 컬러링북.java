import java.util.*;

class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int M, N;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];
        M=m;
        N=n;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    numberOfArea++;
                    bfs(picture[i][j], i, j, visited, picture);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public void bfs(int num, int r, int c, boolean[][] visited, int[][] picture){
        Queue<Node> q = new LinkedList<>();
        visited[r][c]=true;
        int cnt=0;
        q.add(new Node(r,c,num));
        cnt++;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                for(int d=0;d<4;d++){
                    int nr = temp.r+dr[d];
                    int nc = temp.c+dc[d];
                    if(isChecked(nr,nc) && !visited[nr][nc] && picture[nr][nc]==temp.num){
                        q.add(new Node(nr,nc,temp.num));
                        cnt++;
                        visited[nr][nc]=true;
                    }
                }
            }
        }
        if(cnt>maxSizeOfOneArea){
            maxSizeOfOneArea=cnt;
        }
    }
    public boolean isChecked(int nr, int nc){
        return nr>=0 && nr<M && nc>=0 && nc<N;
    }
    public class Node{
        int r; 
        int c;
        int num;
        public Node(int r, int c, int num){
            this.r=r;
            this.c=c;
            this.num=num;
        }
    }
}
