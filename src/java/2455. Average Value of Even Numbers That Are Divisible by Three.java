2455. Average Value of Even Numbers That Are Divisible by Three.java
problem : https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
class Solution {
    public int averageValue(int[] nums) {
        int sumOfEvenNumbersDividedByThree=0,EvenNumbersDividedByThree=0,i=0;
        while(i<nums.length){
            if(nums[i]%2==0 && nums[i]%3==0){
                sumOfEvenNumbersDividedByThree+=nums[i];
                EvenNumbersDividedByThree++;
                }
            i++;
        }
        try{ return Math.round(sumOfEvenNumbersDividedByThree / EvenNumbersDividedByThree);}
        catch(Exception e){return 0;}
    }
}
