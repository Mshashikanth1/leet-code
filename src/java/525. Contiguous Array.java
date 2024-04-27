class Solution {
       public static int findMaxLength1(int[] nums) {

        /*
         brute force solution is to generate all the sub arrays and calculate the zeros
         and ones in them
         Time : O(n^)
         Space : O(1)
         */
        int n=nums.length,maxLen=0,i,j,k,ones,zeros;
        for( i=0;i<n;i++){
            ones=0; zeros=0;
            for( j=i;j<n;j++){
                    if(nums[j]==1) ones++;
                    else zeros++;
                if(ones==zeros ) maxLen=Math.max(Math.abs(i-j)+1,maxLen);
            }
        }
        return maxLen;
    }
    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        map.put(0,-1);
        int n=nums.length,maxlen=0
        ;
        for(int i=0;i<n;i++){
            count= count+ (nums[i] ==1 ? 1:-1);
            if(map.containsKey(count)) maxlen=Math.max(maxlen,i-map.get(count));
            else  map.put(count,i);
        }
        return maxlen;
            
}
  }

  /**
  525. Contiguous Array
Solved
Medium
Topics
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
   */
