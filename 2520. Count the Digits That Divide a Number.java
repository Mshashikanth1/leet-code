2520. Count the Digits That Divide a Number.java
problem:https://leetcode.com/problems/count-the-digits-that-divide-a-number/
class Solution {
    public int countDigits(int num) {
        int i=0,c=0;
        String str=num+"";
        while (i<str.length()){
            if(num%(str.charAt(i)-'0')==0){c++;}
            i++;
        }
        return c;
    }
}
