540. Single Element in a Sorted Array.java
problem : https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] nums) {
    int i=0,j=nums.length-1;
    while(i<j){
        try{
        if(nums[i]!=nums[i+1])
            return nums[i];
        i+=2;
        if(nums[j]!=nums[j-1])
            return nums[j];
        j-=2;
        }
        catch (Exception e){System.out.println(e);}
        
    }
    if ( i==j)
        return nums[i];
        return 0;
    }
}
