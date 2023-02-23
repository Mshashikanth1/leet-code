704. Binary Search.java
problem : https://leetcode.com/problems/binary-search/description/
class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=0;
        while(right-left>=0){
            mid=left+(right-left)/2;
            if(nums[mid]== target){return mid;}
            else if(nums[mid]<target){ left=mid+1;}
            else{right=mid-1; }
        }
        return -1;
    }
} 
