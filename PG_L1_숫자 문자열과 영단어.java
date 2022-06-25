class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] number = {"0","1","2","3","4","5","6","7","8","9"};
        String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0;i<10;i++){
            s = s.replace(nums[i],number[i]);
        }
        
        return Integer.parseInt(s);
    }
}
