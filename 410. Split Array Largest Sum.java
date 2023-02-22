problem : https://leetcode.com/problems/split-array-largest-sum/
class Solution { 
    public int calcuateTheNumberOfSubarraysWithK(int[] nums,int mid){
        int currentSum=0,needSum=1;
        for(int i=0;i<nums.length;i++){
            if(currentSum+nums[i]>mid){
                currentSum=0;
                needSum++;
            }
            currentSum+=nums[i];
        }
        return needSum;
    }
    public int splitArray(int[] nums, int k) {
           int minLargestSum=0,sumOfNums=0,maxArrayLargestSum=sumOfNums;
           for(int i=0;i<nums.length;i++){
               sumOfNums+=nums[i];
               minLargestSum=Math.max(minLargestSum,nums[i]);
           }
           maxArrayLargestSum=sumOfNums;
           
           while(minLargestSum<maxArrayLargestSum){
            int mid=minLargestSum+(maxArrayLargestSum-minLargestSum)/2;
            if(calcuateTheNumberOfSubarraysWithK(nums,mid)>k){
                minLargestSum=mid+1;
            }
            else{
                maxArrayLargestSum=mid;
            }

           }
           return minLargestSum;
        
    }
}
