problem :https://leetcode.com/contest/weekly-contest-338/problems/k-items-with-the-maximum-sum/

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(numOnes+numZeros>=k){
            if(numOnes>=k){
                return k;
            }
            return numOnes;
        }
        else{
            k-=numOnes+numZeros;
            return numOnes-k;
        }
        
    }
}
