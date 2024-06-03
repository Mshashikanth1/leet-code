class Solution {
    public int appendCharacters1(String s, String t) {
        int count=0 , lastFoundAt=0;
        for( int i=0;i<t.length() ; i++ ){
             int j = lastFoundAt;
           
           while( j<s.length() && s.charAt(j)!= t.charAt(i)  ){
                  j++;
           }
           if( j<s.length() && s.charAt(j)== t.charAt(i)) lastFoundAt=j;
           else return t.length()-i;
        }
        return count;
    }

    /*Time : O(n) Space : O(1) */
    public int appendCharacters(String s, String t) {
           int i=0, j=0;
           while( i<s.length() && j<t.length()){
                   if( s.charAt(i++)==t.charAt(j)){
                        j++;
                   }
           }
           return t.length()-j;
    }
}

/**
2486. Append Characters to String to Make Subsequence
Solved
Medium
Topics
Companies
Hint
You are given two strings s and t consisting of only lowercase English letters.

Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

 

Example 1:

Input: s = "coaching", t = "coding"
Output: 4
Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
Now, t is a subsequence of s ("coachingding").
It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
Example 2:

Input: s = "abcde", t = "a"
Output: 0
Explanation: t is already a subsequence of s ("abcde").
Example 3:

Input: s = "z", t = "abcde"
Output: 5
Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
Now, t is a subsequence of s ("zabcde").
It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
 

Constraints:

1 <= s.length, t.length <= 105
s and t consist only of lowercase English letters.
 */
