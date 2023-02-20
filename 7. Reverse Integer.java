7. Reverse Integer.java
problem : https://leetcode.com/problems/reverse-integer/description/
class Solution {
    public int reverse(int x) {
        try{
            String integerXInString=x+"",reverseIntegerXinString="",sign="";
            int i=integerXInString.length()-1;
            while(i>=0){
                if(integerXInString.charAt(i)=='-'){sign+='-';}
                else{
                reverseIntegerXinString+=integerXInString.charAt(i);}
                i--;
            }
            return Integer.valueOf(sign+reverseIntegerXinString);
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
}
