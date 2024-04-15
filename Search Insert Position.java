class Solution {

    //Time :O(log(n)) Space : O(1)
    public int searchInsert(int[] nums, int target) {

        int l=0,r=nums.length-1,m=0;
        while(l<r){
            m= l+ (r-l)/2;
            if(nums[m]==target) return m;
            else if(nums[m]>target)  r=m-1;
            else l=m+1;
        }

        if(nums[l] >= target) return l;
        return l+1;
    }
}

/**
35. Search Insert Position
Solved
Easy
Topics
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

 */
