problem: https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/

class Solution {
    public int differenceOfSum(int[] nums) {
        int Esum=0,Dsum=0,i=0;
        while(i<nums.length){
            Esum+=nums[i];
            int j=0;
            String str=nums[i]+"";
            while(j<str.length()){
                Dsum+=str.charAt(j)-'0';
                j++;}
            i++;
        }
        return Math.abs(Esum-Dsum);
    }
}
