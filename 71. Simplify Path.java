/*
71. Simplify Path.java
problem : https://leetcode.com/problems/simplify-path/
 */
class Solution {
    public String simplifyPath(String path) {
        String[] pathArray=path.split("/");
        System.out.println(Arrays.asList(pathArray).toString());
        Stack<String> stack=new Stack<>();
       
       for(String str : pathArray){
           if(str.equals("") || str.equals(" ") ||  str.equals(".")){continue;}
               
               if(str.equals("..")){
                   try{
                   stack.pop();
                   }catch(Exception e){
                      System.out.println(e);
                   }
               }
               else{
                   stack.push(str.trim());
               }

           }
                      System.out.println(stack.toString());
           String ans="";
           while(!stack.isEmpty()){
           ans="/"+stack.pop()+ans;
           }
           if(ans.equals("")){
               return "/";
           }
            return ans;
    }
}
