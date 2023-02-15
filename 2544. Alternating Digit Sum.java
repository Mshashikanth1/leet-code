problem: https://leetcode.com/problems/alternating-digit-sum/description/
class Solution {
    public int alternateDigitSum(int n) {
        int sum=0;
        int i=0;
        int rn=0;
        while(n>0){
            rn=rn*10+n%10;
            n=n/10;
        }
        while(rn>0){
            sum+=Math.pow(-1,i)*rn%10;
            rn=rn/10;
            i++;
        }
        return sum;}
}
