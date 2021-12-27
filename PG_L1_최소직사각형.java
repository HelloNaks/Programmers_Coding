class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_0=Integer.MIN_VALUE;
        int max_1=Integer.MIN_VALUE;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>sizes[i][1]){
                int temp=sizes[i][0];
                sizes[i][0]=sizes[i][1];
                sizes[i][1]=temp;
            }
            if(max_0<sizes[i][0]) max_0=sizes[i][0];
            if(max_1<sizes[i][1]) max_1=sizes[i][1];
        }
        answer = (max_0*max_1);
        return answer;
    }
}
