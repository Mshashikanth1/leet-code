/*
1. Two Sum
Easy
47.8K
1.6K
Companies

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 

Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.


 */
 //brute force solution
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
      for(int i=0 ;i<n;i++){
          for(int j=0;j<n;j++){
              if(i!=j && (nums[i]+nums[j])==target) return new int[]{i,j};
          }
      }
      return null;
    }
}


//use two pass hash Table:
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> hmp=new HashMap<>();
            int n=nums.length;
            for(int i=0;i<n;i++) hmp.put(nums[i],i);
            for(int i=0;i<n;i++){
                int counter_part=target-nums[i];
                if(hmp.containsKey(counter_part) && hmp.get(counter_part)!=i){
                    return new int[]{hmp.get(counter_part),i};
                }
            }
            return null;
    }
}
//use one pass hashtable:
class Solution {
    public int[] twoSum(int[] nums, int target) {
          Map<Integer,Integer> hmp=new HashMap<>();
          int n=nums.length;
          for(int i=0;i<n;i++){
              int counter_part=target-nums[i];
              if(hmp.containsKey(counter_part)){
                  return new int[]{hmp.get(counter_part),i};
              }
              hmp.put(nums[i],i);
          }
          return null;
    }
}



