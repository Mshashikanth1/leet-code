344. Reverse String.java
Problem : https://leetcode.com/problems/reverse-string/
class Solution {
    public void reverseString(char[] s) {
        int i=0,j=s.length-1;
        while(i<j){
            char chr=s[i];
            s[i]=s[j];
            s[j]=chr;
            i++;
            j--;
        }
    }
}
