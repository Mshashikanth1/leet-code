class Solution {
    /**
    Time : O(n) + O(m)
    Space : O(m)
     */
    public String firstPalindrome(String[] words) {
        for(String str : words){
            if(isPalindrome(str)) return str;
        }

        return "";
    }

    public boolean isPalindrome(String str){
        char[] chrArr=str.toCharArray();

        Stack<Character> stack=new Stack<>();
        for(char ch : chrArr) stack.push(ch);

        for(char ch : chrArr) if(stack.pop()!=ch) return false;
        return true;

    }
}

/**
2108. Find First Palindromic String in the Array
Easy
Topics
Companies
Hint
Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.

 

Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.
Example 2:

Input: words = ["notapalindrome","racecar"]
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".
Example 3:

Input: words = ["def","ghi"]
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists only of lowercase English letters.


 */
