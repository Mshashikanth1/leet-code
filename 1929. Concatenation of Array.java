//1929. Concatenation of Array.java
//problem :https://leetcode.com/problems/concatenation-of-array/
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] ans= new int[2*n];
        for(int i=0;i<2*n;i++){
            if(i>=n){
                ans[i]=nums[i-n];
            }
            else{
                ans[i]=nums[i];
            }
        }
        return ans;
        
    }
}
