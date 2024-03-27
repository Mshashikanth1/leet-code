class Solution {

    /**Time :O(n^3) Space :O(1) */
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n=nums.length,c=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int prod=1;
                for(int l=i;l<=j;l++){
                prod*=nums[j];
                    if(prod>=k) break;
                }
            if(prod<k) c++;
            }
        }
        return c;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
           int i=0,j=1,prod=1,c=0;
        
        while(i!=j){
            prod*=nums[i];
            
            while(prod<k) {c++; j++;}
            if(prod>k) {
                while(!(prod<k)) prod/=nums[i++] ;
                c++;
            }
        }
        return c;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Handle edge cases where k is 0 or 1 (no subarrays possible)
        if (k <= 1) return 0;

        int totalCount = 0;
        int product = 1;

        // Use two pointers to maintain a sliding window
        for (int left = 0, right = 0; right < nums.length; right++) {
            // Expand the window by including the element at the right pointer
            product *= nums[right];

            // Shrink the window from the left while the product is greater than or equal to k
            while (product >= k) {
                // Remove the element at the left pointer from the product
                product /= nums[left++];
            }

            // Update the total count by adding the number of valid subarrays with the current window size
            totalCount += right - left + 1;  // right - left + 1 represents the current window size
        }

        return totalCount;
    }

}

/***

713. Subarray Product Less Than K
Solved
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
 */
