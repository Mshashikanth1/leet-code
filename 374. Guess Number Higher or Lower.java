/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

374. Guess Number Higher or Lower.java
problem : https://leetcode.com/problems/guess-number-higher-or-lower/?envType=study-plan&id=binary-search-i
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int right =n,left=1,mid=0;
        while(right-left>=0){
            mid=left+(right-left)/2;
            System.out.println(mid+","+guess(mid));
            if(guess(mid)==-1){
                right=mid-1;
            }
            if(guess(mid)==1){
                left=mid+1;
            }
            if(guess(mid)==0){
                return mid;
            }
        
        }
        return -1;
    }
}
