/*
415. Add Strings.java
Problem : https://leetcode.com/problems/add-strings/
 */
import java.math.BigInteger;
class Solution {
    public String addStrings(String num1, String num2) {
            BigInteger bigNumber1 = new BigInteger(num1);

    BigInteger bigNumber2 = new BigInteger(num2);

        return bigNumber1.add(bigNumber2)+"";
    }
}
