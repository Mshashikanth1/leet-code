class Solution {
    /**
    
     Time : O(n) * O(2^n)
     Space : O(n) * O(2^n)
    
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length,noOfSubSets= (1<<n);

        List<List<Integer>> subsets=new ArrayList<>(); 

        for(int i=0; i<noOfSubSets; i++){
            List<Integer> subset=new ArrayList<>();
            for(int j=0; j<n; j++){
                if( (i & (1<< j))!=0 ) subset.add(nums[j]); 
            }
            subsets.add(subset);
        }

        return subsets;
    }
}

/**
78. Subsets
Solved
Medium
Topics
Companies
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.


 */