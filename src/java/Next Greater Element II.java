class Solution {

    //Time :O(n^2) Space : O(n)
    public int[] nextGreaterElements1(int[] nums) {

        int[] ans =new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int j=i+1, mric=-1;
            while(true){
                j=j%nums.length;
                if(nums[j] > nums[i]) {mric=nums[j];  break;}
                else if(i==j) break;
                j++;
            }

            ans[i]=mric;
        }
        return ans;
        
    }


       //Time :O(n^2) Space : O(n)
    public int[] nextGreaterElements2(int[] nums) {

        int[] ans =new int[nums.length];
        int[] cirNums=new int[nums.length*2];

        for(int i=0;i<nums.length;i++) cirNums[i]=nums[i];
        for(int i=nums.length-1; i>=0 ;i--) cirNums[nums.length+i]=nums[i];

        
        for(int i=0; i<nums.length; i++){
            int  mric=-1;
           
            for(int j=i; j<cirNums.length; j++){
                if(cirNums[j] > nums[i]) {mric=cirNums[j];  break;}
            }

            ans[i]=mric;
        }
        return ans;
    }

    //Time :O(n^2) Space : O(n)
     public int[] nextGreaterElements(int[] nums) {

        int[] ans =new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            int  mric=Integer.MIN_VALUE;
           
            for(int j=i; j<nums.length; j++){
                if(nums[j] > nums[i]) {mric=nums[j];  break;}
            }

            if(mric==Integer.MIN_VALUE){
                for(int j=0; j<=i; j++){
                    if(nums[j] > nums[i]) {mric=nums[j];  break;}
                }
            }

            ans[i]=mric==Integer.MIN_VALUE ? -1 : mric;
        }
        return ans;
    }
}



/**

503. Next Greater Element II
Solved
Medium
Topics
Companies
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
 */
