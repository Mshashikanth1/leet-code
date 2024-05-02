class Solution {
    public int findMaxK1(int[] nums) {
        // Arrays.sort(nums);
        // quickSort(nums,0,nums.length-1);
        mergeSort(nums,0,nums.length-1);
        Set<Integer> hset=new HashSet<>();
        for(int i: nums){
            hset.add(i);
        }

        for(int i=nums.length-1; i>=0; i--) {
            if(hset.contains(-1*nums[i])){
                return nums[i];
            }
        }
        return -1;
    }

    public int findMaxK(int[] nums) {
        int max=Integer.MIN_VALUE;
        Set<Integer> hset=new HashSet<>();
        for(int i: nums){
            if(hset.contains(-1*i)){
                max=Math.max(max,Math.abs(i));
            }
            hset.add(i);
        }
        return max==Integer.MIN_VALUE? -1:max;
    }

    /**divide and conquer type of algo
involves in partitioning on every index,
partitioning is notthing but choosing a pivot element and put all the elements lesser than that are smaller to left  */
public void quickSort(int[] arr,int left, int right){
    if(left<right){
        int pivotIndex=partition(arr,left,right);
        quickSort(arr,left,pivotIndex-1);
        quickSort(arr,pivotIndex+1,right);
    }
}
public int partition(int[] arr, int left, int right){
    int i=left-1, j=left;
    while(j<right){
        if(arr[j]<=arr[right]) swap(arr, ++i, j);
        j++;
    }
    swap(arr, ++i , right);
    return i;
}
public void swap(int[] arr, int left, int right){
    int temp=arr[left];
    arr[left]=arr[right];
    arr[right]=temp;
}

/**dcAlgo, repeatedly divided the array into halfs and merging them Time :O(log(N)) Space : O(log(N)) */
public void mergeSort(int[] arr, int left, int right){
    if(left<right){
        int mid= left+(right-left)/2;
        mergeSort(arr, left,mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
}

/**merging includes identifying the left & sub arrays  and puttin back the data in sorted fashion to input array */
public void  merge(int[] arr, int left, int mid, int right){
    int n=mid-left+1, m=right-mid, i=0, j=0,k=left;
    int[] nArr=new int[n], mArr=new int[m];

    while(i<n) nArr[i]=arr[left + i++];
    while(j<m) mArr[j]=arr[mid+1 + j++];

    i=0; j=0;
    while(i<n && j<m) arr[k++]= nArr[i]<=mArr[j] ? nArr[i++]:mArr[j++];

    while(i<n) arr[k++]=nArr[i++];
    while(j<m) arr[k++]=mArr[j++];
}


}



/**
2441. Largest Positive Integer That Exists With Its Negative
Solved
Easy
Topics
Companies
Hint
Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.

 

Example 1:

Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.
Example 2:

Input: nums = [-1,10,6,7,-7,1]
Output: 7
Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
Example 3:

Input: nums = [-10,8,6,7,-2,-3]
Output: -1
Explanation: There is no a single valid k, we return -1.
 

Constraints:

1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
nums[i] != 0

 */