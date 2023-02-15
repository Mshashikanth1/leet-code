//problem link : https://leetcode.com/problems/find-the-array-concatenation-value/description/

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long sum=0;
        int i=0,j=nums.length-1;
        while(i<=j){
            if(i==j){
            sum+=Math.abs(nums[i]);}
            else{
            sum+=Math.abs(Integer.valueOf(Math.abs(nums[i])+""+Math.abs(nums[j])));}
            System.out.println(nums[i]+","+nums[j]);
            System.out.println(sum);
            i++;
            j--;
        }
        return sum;
    }
}
