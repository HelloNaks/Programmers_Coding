class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int M=board.length, N=board[0].length;
        int[][] sum = new int[M+1][N+1];
        //누적합 좌표
        for(int[] s : skill){
            int i1=s[1], j1=s[2];
            int i2=s[3], j2=s[4];
            int d=s[5]*(s[0]==1?-1:1);
            sum[i1][j1]+=d;
            sum[i2+1][j1]+=d*-1;
            sum[i1][j2+1]+=d*-1;
            sum[i2+1][j2+1]+=d;
        }
        // 좌 -> 우
        for(int j=1;j<N;j++){
            for(int i=0;i<M;i++){
                sum[i][j]+=sum[i][j-1];
            }
        }
        // 상 -> 하
        for(int i=1;i<M;i++){
            for(int j=0;j<N;j++){
                sum[i][j]+=sum[i-1][j];
            }
        }
        // 누적합
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]+sum[i][j]>0)answer++;
            }
        }
        
        return answer;
    }
}
