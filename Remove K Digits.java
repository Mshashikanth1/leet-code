class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack=new Stack<>();
        for(char ch : num.toCharArray()) {
            while( !stack.isEmpty() && k>0 && stack.peek() > ch  ){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

         while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        for(char ch : stack) if(!(sb.length()==0 && ch=='0')) sb.append(ch);
        return sb.toString().equals("") ?  "0" : sb.toString();
    }
}


/**


Testcase
Testcase
Code
Test Result
Test Result
402. Remove K Digits
Solved
Medium
Topics
Companies
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */
