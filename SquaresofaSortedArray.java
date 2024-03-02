/**
 suggestion : never ignore to learn multiple ways of doing this and performing the complexity analysis
 */
class Solution {
    /*
    method: first transform the array and use quick sort
    time :O(nlog(n)) space : O(1)
    */
    public int[] sortedSquares1(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     method: use streams ,map, sort and then convert back to array
     time : O(n)
     space : O(1)

     */
    public int[] sortedSquares2(int[] nums){
        return Arrays.stream(nums)
                .map(i->i*i)
                .sorted()
                .toArray();
    }

    /**
     method:  two pointer solution:
     //time : O(n) space: O(n)
     */
    public int[] sortedSquares(int[] nums) {
        int n=nums.length,i=0,j=n-1,k=j;
        int[] ans=new int[n];
        while(i<=j){
            int sqrNumI=nums[i]*nums[i],sqrNumJ=nums[j]*nums[j];
            if(sqrNumI>sqrNumJ) {ans[k]=sqrNumI; i++;}
            else {ans[k]=sqrNumJ; j--;}
            k--;
        }
        return ans;
    }
}

/*
977. Squares of a Sorted Array
Solved
Easy
Topics
Companies
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
*/