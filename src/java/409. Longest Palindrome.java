class Solution {
    /**T : O(n) S : O(n) */
    public int longestPalindrome(String s) {
        int[] chrFrqArr= new int[256];

        for( char ch : s.toCharArray()) {
            chrFrqArr[ch]++; 
        }

        int noOfOdd=0, len=0;
        for( int frq: chrFrqArr){
            if( noOfOdd==0 && frq%2==1) noOfOdd++;
            else if ( noOfOdd==1 && frq%2==1) frq--;

            len+=frq;
        }

        return len;
    }
}


/**
409. Longest Palindrome
Solved
Easy
Topics
Companies
Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
