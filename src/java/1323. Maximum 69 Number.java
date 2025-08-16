class Solution {


    /** 
        Time : O(log₁₀ n) char array convertion. + O(log₁₀ n) string builder operations + O(n) iteration process = O(n) 
        Space: O(log₁₀ n) char array + O(n) string builder space = O(log₁₀ n)
    */

    public int maximum69Number_0 (int num) {
        char[] transformation = (num +"").toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isFliped =false;
        for( char ch : transformation){
            if(!isFliped && ch=='6'){
                sb.append('9');
                isFliped=true;
            }else {
                sb.append(ch);
            }
        }
        return Integer.valueOf(sb.toString()) ;
    }
    
    /** i can optimize the space complexity with arthematic operations */

    /** Time :  O(log₁₀ n). Space : O(1) */
    public int maximum69Number_1 (int num){
        int largetIntegerAfterFlip=num,  lastDigit6FoundAt=-1, currAt=0, currDigit=-1;
    
        while (num >0 ) {
            currDigit= num%10;
            currAt++;
            if( currDigit==6 ) {
                lastDigit6FoundAt=currAt;
            }
            num /=10 ;
        }
        if(lastDigit6FoundAt==-1)  return largetIntegerAfterFlip;

        largetIntegerAfterFlip += (Math.pow(10 , lastDigit6FoundAt-1 ) * 3 ) ;
        return largetIntegerAfterFlip;
        
    }


     /** don't use the bilt in math functoins */
    /** Time :  O(log₁₀ n). Space : O(1) */
    public int maximum69Number_2 (int num){
        int largetIntegerAfterFlip=num,  lastDigit6FoundAt=-1, currAt=0, currDigit=-1, howMuchToAddToFlip=3;
    
        while (num >0 ) {
            currDigit= num%10;
            currAt++;
            if( currDigit==6 ) {
                lastDigit6FoundAt=currAt;
            }
            num /=10 ;
        }
        if(lastDigit6FoundAt==-1)  return largetIntegerAfterFlip;
        
        for( int i=1; i<lastDigit6FoundAt; i++){
            howMuchToAddToFlip*=10;
        }

        largetIntegerAfterFlip += howMuchToAddToFlip;
        return largetIntegerAfterFlip;
        
    }

        /** don't replicate the power of 10 seperately  */
    /** Time :  O(log₁₀ n). Space : O(1) */
   public int maximum69Number(int num) {
    int originalNum = num;
    int howMuchToAddToFlip = 0;
    int currPowerOf10 = 1;

    while (num > 0) {
        int currDigit = num % 10;
        if (currDigit == 6) {
            howMuchToAddToFlip = 3 * currPowerOf10;
        }
        num /= 10;
        currPowerOf10 *= 10;
    }

    if (howMuchToAddToFlip == 0) {
        return originalNum;
    }

    return originalNum + howMuchToAddToFlip;
}
}

/**

1323. Maximum 69 Number
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

 

Example 1:

Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.
 

Constraints:

1 <= num <= 104
num consists of only 6 and 9 digits.


 */
