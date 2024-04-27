/*
946. Validate Stack Sequences
problem : https://leetcode.com/problems/validate-stack-sequences/
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack =new Stack<>();
        
        int i=0,j=0,n=pushed.length;
        while(i<n){
     
            stack.push(pushed[i]);
            i++;
            
        try{
            while(stack.peek()==popped[j]){
               stack.pop();
                j++;
            }
        }catch(Exception e){
            continue;
        }
           
        }
            if(stack.isEmpty()){
                return true;
            }
            return false;
    }
}
