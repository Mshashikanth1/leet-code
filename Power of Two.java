class Solution {

    //Time Limit Exceed
    public boolean isPowerOfTwo1(int n) {
        int m=1;
        while(m<n){
            m*=2;
        }
        return m==n?true:false;
    }

    public boolean isPowerOfTwo2(int n) {
       return rec(n,1);
    }
    boolean rec(int n, int m){
        if(n==m) return true;
        if(m<n) return rec(n,m*2);
        return false;
    }

    /**
    
    Time :O(1) Space : O(1)
    The fact that every power of two contains only one set bit and LSB

    1 ---> 0001
    2 ---> 00010
    4 ----> 00100
    8 ----> 01000

    
     */
    public boolean isPowerOfTwo(int n) {
        return n>0 &&( (n & (n-1))==0); 
    }

}

/**
231. Power of Two
Solved
Easy
Topics
Companies
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?
 */
