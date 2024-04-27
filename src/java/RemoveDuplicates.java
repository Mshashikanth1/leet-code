class Solution {
    public int removeDuplicates(int[] nums) {
       int i=0,j=i+1;
           while(j<nums.length){
               if (nums[i]==nums[j]){
                   j++;
               }
               else{
                   i++;
                   int temp=nums[i];
                   nums[i]=nums[j];
                   nums[j]=nums[i];
               }
               
           }
        return i+1;
}}
