class Solution {
    public boolean judgeSquareSum(int c) {

        for( int i= (int) Math.sqrt(c);i>=0; i--){

            int left=i, right= (int) Math.sqrt(c);
            while(left <= right ){

                int mid= left + (right -left)/2, val= (c - (i*i));
                if( mid*mid==val ) { return true;}
                else if( mid*mid < val) {  left =mid+1;}
                else  { right=mid-1;}
                
                if( mid > (int)Math.sqrt(c)) break;

            }
        }
        return false;
    }
}

/**
633. Sum of Square Numbers
Solved
Medium
Topics
Companies
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
 

Constraints:

0 <= c <= 231 - 1
 */
