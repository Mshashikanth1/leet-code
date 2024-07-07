class Solution {


    /** T : O(n^2) S: O(1) */
    public int _missingNumber(int[] nums){
        int n= nums.length;
        for( int i=0 ;i<n ;i++ ){
            boolean isIPresent=false;
            for( int j=0 ; j<n; j++){
                 if( i == nums[j]) isIPresent=true;
            }

            if( !isIPresent ) return i;
        }
        return nums.length;
    }



    /**. T : O( nlog(n)) + O(n). S: O(1) */
    public int __missingNumber(int[] nums) {
        int currNum=0;
        Arrays.sort(nums);

        while( currNum < nums.length) {
                if(  nums[currNum] != currNum++  ) return --currNum;
        }
        return currNum;
    }

     /** T : O(n) + hashingTime  S : O(n) +hashingSpace */
    public int ___missingNumber( int[] nums){
        Set<Integer> hset= new HashSet<>();
        int n= nums.length;
        for( int i :nums) hset.add(i);

        for( int i=0; i<n ; i++){ if( !hset.contains(i)) return i; }
        return n;
    }

    /** T : O(n)   S : O(n)  */
    public int _____missingNumber( int[] nums){
        int n= nums.length;
        int[] harr= new int[n+1];
        for( int i: nums){ harr[i]++; }

        for( int i=0; i<n ;i++) { if( harr[i]==0 ) return i;}
        return n;
    }




    /** T : O(n)  S : O(1)*/
    public int ______missingNumber( int[] nums){
           int n= nums.length, expectedSum = n*(n+1)/2, actualSum=0;
           for( int num : nums) actualSum+=num;

           return  expectedSum == (actualSum-n) ? n  :  expectedSum - actualSum;
    }

    /** T :O(n)  S:O(1)  bitwise operations are more opitimal */
    public int missingNumber ( int[] nums){
        int n= nums.length, nxor=0 , numsxor=0;
        for( int i=0; i<=n ; i++)  { nxor^=i;  if( i!=n ) numsxor^=nums[i]; }
        return nxor ^ numsxor;
    }
}

/**
268. Missing Number
Solved
Easy
Topics
Companies
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
