/*
1672. Richest Customer Wealth.java
problem : https://leetcode.com/problems/richest-customer-wealth/
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int numberOfCustomer=accounts.length;  //rows
        int numberOfBanks=accounts[0].length;  //cols
        int sumAmounts;
        int richestCustomerHasBalence=-1;
        for(int i=0;i<numberOfCustomer;i++){
            sumAmounts=0;
            for(int j=0;j<numberOfBanks;j++){
                sumAmounts+=accounts[i][j];
            }
            richestCustomerHasBalence=Math.max(sumAmounts,richestCustomerHasBalence);
        }

        return richestCustomerHasBalence;
    }
}
