/*
1876. Substrings of Size Three with Distinct Characters.java
Problem : https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
1876. Substrings of Size Three with Distinct Characters
Easy
1.1K
30
Companies

A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Example 2:

Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".

 

Constraints:

    1 <= s.length <= 100
    s​​​​​​ consists of lowercase English letters.


 */
class Solution {
    public int checkIsGoodString(char x, char y, char z){
        if(x==y || y==z || x==z) return 0;
        else return 1;
    }
    public int countGoodSubstrings(String s) {
        char[] chr=s.toCharArray();
        int n=chr.length,goodStrings=0,i=0;
        if(n<3){return 0;}

        while(i<=n-3){
            goodStrings+=checkIsGoodString(chr[i],chr[i+1],chr[i+2]);
            System.out.println(chr[i]+""+chr[i+1]+""+chr[i+2]+":"+goodStrings);
            i++;
        }
        return goodStrings;
    }
}
