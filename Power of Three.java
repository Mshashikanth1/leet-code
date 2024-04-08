class Solution {
    public boolean isPowerOfThree1(int n) {
        int m=1;
        while(m<n){
            m*=3;
        }
        return n==m ? true:false;
    }

     public boolean isPowerOfThree2(int n) {
        return rec(n,1);
     }

     public boolean rec(int n, int m){
        if(n==m) return true;
        if(m<n) return rec(n, m*3);
        return false;
     }

    /**the largest number divisible by three is  1162261467 before 2^31 -1 , checking it is divisible by it 
    would be sufficient */
     public boolean isPowerOfThree(int n) {
         return n > 0 && 1162261467 % n == 0;
     }

}

/**
326. Power of Three
Solved
Easy
Topics
Companies
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

 

Example 1:

Input: n = 27
Output: true
Explanation: 27 = 33
Example 2:

Input: n = 0
Output: false
Explanation: There is no x where 3x = 0.
Example 3:

Input: n = -1
Output: false
Explanation: There is no x where 3x = (-1).
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?

 */
