/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Input: nums = [1,3,5,6], target = 5
Output: 2

Input: nums = [1,3,5,6], target = 2
Output: 1
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length,mid=0;
        while(low<high){
            mid=low+(high-low)/2;
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]==target){
                return mid;
            }
            else{
                high=mid;
            }
        }
        if(nums[mid]<target){
            return mid+1;
        }
        else{
            return mid;
        }
    }
   
}
