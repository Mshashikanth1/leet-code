268. Missing Number.java
Problem : https://leetcode.com/problems/missing-number/
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
            try{
            if(i!=nums[i]){

                return i;
            }
            } catch(Exception e){
                System.out.println(e); 
                return i;}
        }
        return 0;
    }
}
