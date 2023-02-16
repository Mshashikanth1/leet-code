2529. Maximum Count of Positive Integer and Negative Integer.java
problem :https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

class Solution {
    public int maximumCount(int[] nums) {
        int i=0,neg=0,pos=0;
        while(i<nums.length){
            if(nums[i]>0){pos+=1;}
            else if(nums[i]<0){neg+=1;}
            i++;
        }
        if(neg>pos){return neg;}
        else if (neg<pos){return pos;} 
        return neg;
    }
}
