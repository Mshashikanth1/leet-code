//20. Valid Parentheses.java
// problem : https://leetcode.com/problems/valid-parentheses/description/
class Solution {
    public boolean isValid(String s) {
        Stack<Character>  stack = new Stack<>();

        for(char ch : s.toCharArray()){
           
            if(!stack.isEmpty() &&
                              (
                                  (ch==')' && stack.peek()=='(')   ||
                                  (ch==']' && stack.peek()=='[')   ||
                                  (ch=='}' && stack.peek()=='{')
                              ))
                              {stack.pop();}
            else{ stack.push(ch);}
        }

        return stack.isEmpty();
        
    }
}
