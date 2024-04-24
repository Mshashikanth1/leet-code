class Solution {
    /**
    time : O(n)
    space : O(n)
    top down dp : memorization
     */
    Map<Integer,Integer> cache=new HashMap<>();
    public int tribonacci1(int n) {
        if(n==0) return 0;
        else if(n==1 || n==2) return 1;
        else if(cache.containsKey(n)) return cache.get(n);
        cache.put(n,tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3));
        return cache.get(n);
    }

/**
Time :O(n)
Space : O(n)
bottom up : tabulation
 */
    public int tribonacci2(int n) {
        int[] dp = new int[n+3];
        dp[0]=0;
        dp[1]++;
        dp[2]++;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }

 //Time :O(n) Space :O(1)
   public int tribonacci(int n) {
        int c=0,b=1,a=1;
        if(n==0) return c;
        if(n==1) return b;

        for(int i=3;i<=n;i++){
            int nex=a+b+c;
            c=b;
            b=a;
            a=nex;
        }
        return a;
    }
}

  

/**
1137. N-th Tribonacci Number
Solved
Easy
Topics
Companies
Hint
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.


 */
