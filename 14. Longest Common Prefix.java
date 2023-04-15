/*
14. Longest Common Prefix.java
problem : https://leetcode.com/problems/longest-common-prefix/
Easy
13.4K
3.9K
Companies

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.


 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Boolean matching=true;
        String requiredString="";
        int j=0;
        while(matching){
         try{
        char ch=strs[0].charAt(j);
         
        for(int i=1;i<strs.length;i++){
            if(ch!=strs[i].charAt(j))
               matching=false;
        }
        if(matching)
              requiredString+=ch;

        j++;
        }catch(Exception e){return requiredString;}
        }
       return requiredString;
    }
}
