class Solution {

    /**Time :O(n) Space :O(n) */
    public int firstMissingPositive1(int[] nums) {
        int fmp=1;
        Set<Integer> hSet=new HashSet<>();
        for(int i: nums) hSet.add(i);
        while(hSet.contains(fmp))  fmp++;
        return  fmp;
    }

    
    /**Time :O(n) Space :O(1) */
     public static int firstMissingPositive(int[] nums) {

        boolean contains1=false;
        int n=nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i]==1) contains1=true;
            if(nums[i]<=0 || nums[i]>n) nums[i]=1;
        }
        if(!contains1) return 1;

        for(int i=0;i<n;i++){
            int value = Math.abs(nums[i]);
            if (value == n) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[value-1] = - Math.abs(nums[value-1]);
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }

}


/**


 [ 3, 4, -1 ,1]
41. First Missing Positive
Solved
Hard
Topics
Companies
Hint
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1


 */
