35. Search Insert Position.java
problem : https://leetcode.com/problems/search-insert-position/
class Solution {
    public int searchInsert(int[] nums, int target) {
        Arrays.sort(nums);
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i]>=target){return i;}
        }
        return i;
        
    }
}
