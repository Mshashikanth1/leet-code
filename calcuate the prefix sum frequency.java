class Solution {
  public static int numSubarraysWithSum1(int[] nums, int goal) {
        /*
        * get all sub array sums and compare it with goal  return count if equals
        * Time :O(n^2)
        * Space :O(1)
        * Time Limit Exceeded 53 / 60 testcases passed
        */
        int n=nums.length,c=0;
        for(int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j; k++){
                   sum+=nums[k];
                }
                if(sum==goal) c++;
            }
        }
        return c;
    }


   /**
    calcuate the prefix sum frequency
    
    */
    public static int numSubarraysWithSum(int[] nums, int goal) {
           Map<Integer,Integer> frqPreSum=new HashMap<>();
           int currSum=0,count=0;
           for(int i : nums){
                currSum+=i;
                if(currSum==goal) count++; 
                if(frqPreSum.containsKey(currSum-goal)) count+=frqPreSum.get(currSum-goal);
                frqPreSum.put(currSum, frqPreSum.getOrDefault(currSum,0)+1);
           }
           return count;
      }
}

/* 
1, 0, 1, 0, 1

1, 1, 2, 2, 3

930. Binary Subarrays With Sum
Solved
Medium
Topics
Companies
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length

*/
