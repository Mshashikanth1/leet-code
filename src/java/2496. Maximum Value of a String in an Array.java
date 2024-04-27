2496. Maximum Value of a String in an Array.java
problem : https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/
class Solution {
    public int maximumValue(String[] strs) {
        int ans=0;
        int i=0;
        while(i<strs.length){
            try{
            ans=Math.max(ans,Integer.valueOf(strs[i]));}
            catch(Exception e){
                ans=Math.max(ans,strs[i].length());
            }
            i++;
        }
        return ans;
        
    }
}
