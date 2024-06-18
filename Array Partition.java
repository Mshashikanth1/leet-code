class Solution {
    public int arrayPairSum(int[] nums) {

        System.out.println(Arrays.toString(nums));
        mergeSort(nums, 0, nums.length-1);

        System.out.println(Arrays.toString(nums));
        int max=0;
        for(int i=0;i<nums.length;i+=2){
            max+=nums[i];
        }
        return max;
    }

    public void quickSort( int[] nums, int left, int right){
        if(left< right){
            int pivot= partition(nums, left, right);
            quickSort( nums, left, pivot-1);
            quickSort(nums, pivot+1, right);

        }

    }

    public int partition( int[] nums, int left, int right){
        int i=left-1, j=left;

        while( j< right) {
            if( nums[j] < nums[right]) swap( nums, ++i, j);
            j++;
        }
        swap( nums, ++i, right);
        return i;

    }
    public void swap( int[] nums, int i, int j){
            int temp= nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
    }

    public void mergeSort( int[] nums, int left, int right){
        if( left< right){
            int mid= left + (right- left)/2;

            mergeSort( nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge( nums, left, mid, right);
        }
    }

    public void merge( int[] nums, int left, int mid, int right){
        int n=mid-left+1 , m= right-mid,i=0, j=0,k=left;
        int[] nArr= new int[n], mArr = new int[m];

        while(i< n ) nArr[i]= nums[left + i++];
        while( j< m) mArr[j] = nums[mid+1 + j++];

        i=0; j=0;
        while( i<n && j< m) nums[k++] = nArr[i] > mArr[j] ? mArr[j++] : nArr[i++];

        while( i< n) nums[k++]= nArr[i++];
        while( j<m) nums[k++]= mArr[j++];
    }
}

/**
561. Array Partition
Solved
Easy
Topics
Companies
Hint
Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

 

Example 1:

Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.
Example 2:

Input: nums = [6,2,6,5,1,2]
Output: 9
Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 

Constraints:

1 <= n <= 104
nums.length == 2 * n
-104 <= nums[i] <= 104

 */
