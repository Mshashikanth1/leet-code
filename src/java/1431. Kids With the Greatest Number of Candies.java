/*
1431. Kids With the Greatest Number of Candies.java
problem : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length;
       // int kidWithMaxCandies=new int[n];
        int maxCandies=-1;
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            maxCandies=Math.max(maxCandies,candies[i]);
            ans.add(false);
        }
       // System.out.println(maxCandies);
    
        for(int i=0;i<n;i++){
        //System.out.print(candies[i]+extraCandies+" ");
        if(candies[i]+extraCandies>=maxCandies){
            ans.set(i,true);
        }
        }
        return ans;
    }
}
