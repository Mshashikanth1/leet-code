217. Contains Duplicate.java
problem:https://leetcode.com/problems/contains-duplicate/description/?envType=study-plan&id=data-structure-i
class Solution {
    public boolean containsDuplicate(int[] nums) {
       int i=0;
       Arrays.sort(nums);
       while(i<nums.length-1){
           if(nums[i]==nums[i+1]){
               return true;
           }
           i++;
       }
       return false;
}
}
