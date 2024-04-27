problem : https://leetcode.com/contest/weekly-contest-334/problems/left-and-right-sum-differences/
class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] answer =new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        int leftArraySumInitial=0,rightArraySumInitial=sum;
        for(int i=0;i<nums.length;i++){
            answer[i]=Math.abs(leftArraySumInitial-(rightArraySumInitial-nums[i]-leftArraySumInitial));
            leftArraySumInitial+=nums[i];
        }
        
        return answer;
        
        
    }
}
