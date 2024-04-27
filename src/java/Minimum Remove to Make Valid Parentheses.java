class Solution {
    /**Time: O(n) Space: O(n) */
    public String minRemoveToMakeValid(String str) {
        char[] chr=str.toCharArray();
        Stack<Integer> s=new Stack<>();
        for(int i=0;i< chr.length;i++){
            if(chr[i]=='(' || chr[i]==')') {
                if( !s.isEmpty() && (chr[s.peek()] =='(' && chr[i]==')' ) ) s.pop();
                else s.push(i);
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chr.length;i++){
            if(!s.contains(i)) sb.append(chr[i]);
        }

        return sb.toString();
    }
}



/**1249. Minimum Remove to Make Valid Parentheses
Solved
Medium
Topics
Companies
Hint
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter. */
