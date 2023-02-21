1678. Goal Parser Interpretation.java
Problem : https://leetcode.com/problems/goal-parser-interpretation/
class Solution {
    public String interpret(String command) {
        try{
            command=command.replace("()","o");
        }
        catch(Exception e){System.out.println(e);}
        try{
            command=command.replace("(al)","al");
        }
        catch(Exception e){System.out.println(e);}
        return command;
        
    }
}
