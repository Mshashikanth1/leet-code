class Solution {
    public int[] searchRange(int[] nums, int target) {

        int i=0,j=nums.length-1,mid=(i+j)/2;
        int[] ans=new int[]{-1,-1}; 

        while(i<=j){
             mid=i+(j-i)/2;
            if(nums[mid]>target)
                j=mid-1;
            else if(nums[mid]<target)
                i=mid+1;
            else{
                while(mid>=0 && nums[mid]==target) mid--;
                     ans[0]=++mid;
                while(mid<nums.length && nums[mid]==target) mid++;
                     ans[1]=--mid;
                return ans;
            }
                
        }
        return ans;
    }
}

/*
34. Find First and Last Position of Element in Sorted Array
Medium
19.1K
461
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
