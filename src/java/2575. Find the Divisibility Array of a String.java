 2575. Find the Divisibility Array of a String.java
problem :https://leetcode.com/contest/weekly-contest-334/problems/find-the-divisibility-array-of-a-string/
import java.math.BigInteger;
class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] answer=new int[word.length()];
        for(int i=1;i<=word.length();i++){
             BigInteger number = new BigInteger(word.substring(0,i));
        if(number.divideAndRemainder((BigInteger.valueOf(m)))[1].equals(BigInteger.valueOf(0))){answer[i-1]=1;}
            else{answer[i-1]=0;}
            }
        return answer;
    }
}
