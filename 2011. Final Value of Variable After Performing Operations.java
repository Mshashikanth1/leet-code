/*
2011. Final Value of Variable After Performing Operations.java
problem : https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 */
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(int i=0;i<operations.length;i++){
                if(operations[i].charAt(1)=='+'){x++;}
                else{x--;}
        }
        return x;
    }
}
