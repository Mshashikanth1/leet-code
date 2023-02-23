724. Find Pivot Index.java
problem : https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){totalSum+=nums[i];}
        int rightSum=0,leftSum=totalSum-nums[0];
        if(rightSum==leftSum){return 0;}
        for(int i=1;i<nums.length;i++){
            rightSum+=nums[i-1];
            leftSum=totalSum-nums[i]-rightSum;
            System.out.println(rightSum+","+leftSum+","+i);
            if(rightSum==leftSum){return i;}
        }
        return -1;
        
    }
}
