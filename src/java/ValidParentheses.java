import java.util.*;
class Solution {
    public boolean isValid(String s) {
        //declare a map and initialize the values
        Map<Character, Character> dic = new HashMap<Character, Character>();
        dic.put('(',')');
        dic.put('{','}');
        dic.put('[',']');
       
        /*System.out.println(dic.get("("));
        System.out.println(dic.get("{"));
        System.out.println(dic.get("["));*/
        
        //declare the stack
        Stack<Character> stack = new Stack<Character>();
        int i=0;
        while(i<s.length()){
            if (stack.empty()){stack.push(s.charAt(i));}
            else{
                if( dic.get(stack.peek())!=null &&(dic.get(stack.peek())==s.charAt(i))){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
            
            i++;            
        }


                
        //STACK.empty() will return true if nothing is there on the top of stack else it returns false
        return stack.empty();
    }
}
