/*

1140. Stone Game II
Medium
2.1K
458
Companies

Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones. 

Alice and Bob take turns, with Alice starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

 

Example 1:

Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger. 

Example 2:

Input: piles = [1,2,3,4,5,100]
Output: 104

 

Constraints:

    1 <= piles.length <= 100
    1 <= piles[i] <= 104

Accepted
61.8K
Submissions
92.1K
Acceptance Rate
67.1%


Problem List
Premium
55
DCC Badge
3.95
(20 votes)
Solution

    Note. For this problem, we assume that you already know the fundamentals of dynamic programming and are figuring out how to apply it to a wide range of problems, such as this one. If you are not yet at this stage, we recommend checking out our relevant Explore Card content on dynamic programming before coming back to this article.

Approach 1: Memoization
Intuition

The game described in the problem is a zero-sum game. Since the number of stones in the piles is constant, the more stones Alice gets, the less Bob does, and vice versa. In this game, the players are antagonists. In particular, it implies that Bob wants to minimize the number of stones Alice gets.

Let nnn denote the number of piles.

For 0≤p≤10 \le p \le 10≤p≤1, 0≤i≤n0 \le i \le n0≤i≤n, 1≤m≤n1 \le m \le n1≤m≤n, define f(p,i,m)f(p, i, m)f(p,i,m) as the number of stones that Alice can get in the following state of the game, provided Alice and Bob play optimally.

    Parameter ppp determines whose turn it is: if p=0p = 0p=0, then Alice moves, otherwise Bob. We are only considering the last n−in-in−i piles (treat piles[i] as the first pile). The current value of the variable M described in the problem description is mmm.

The answer to the problem is f(0,0,1)f(0, 0, 1)f(0,0,1) – Alice moves first, all nnn piles are in the game, and the initial value of M is 111.

We want to know how to calculate f(p,i,m)f(p, i, m)f(p,i,m) for arbitrary ppp, iii, mmm.

Let us first define a base case: f(p,n,m)f(p, n, m)f(p,n,m) for arbitrary ppp and mmm. Here we have i=ni = ni=n, i.e., no piles in the game. In this case, the players will make no moves, and Alice will take no stones, thus f(p,n,m)=0f(p, n, m) = 0f(p,n,m)=0.

Consider now i<ni < ni<n when at least one pile is in the game. The player that moves now (determined by ppp) chooses a number xxx and takes all the stones from the first xxx remaining piles. Two inequalities must hold: x≤2mx \le 2mx≤2m (according to the rules) and x≤n−ix \le n - ix≤n−i (a player cannot take more piles than remains in the game). Thus x≤min⁡(2m,n−i)x \le \min(2m, n - i)x≤min(2m,n−i). We have two possible cases.

    p=0p = 0p=0, Alice moves. When Alice chooses a number xxx, she takes s=ai+ai+1+⋯+ai+x−1s = a_i + a_{i + 1} + \dots + a_{i+x-1}s=ai​+ai+1​+⋯+ai+x−1​ stones during her move. After that, the last n−(i+x)n-(i + x)n−(i+x) piles remain in the game (the players took iii piles earlier, and Alice takes xxx now), Bob will move next (ppp will become 111), and the new value of M will be max⁡(m,x)\max (m, x)max(m,x). Thus, Alice will get f(1,i+x,max⁡(m,x))f(1, i + x, \max (m, x))f(1,i+x,max(m,x)) stones after her current move. Adding two summands, we obtain that Alice will get s+f(1,i+x,max⁡(m,x))s + f(1, i + x, \max (m, x))s+f(1,i+x,max(m,x)) stones. Since she plays optimally, she will choose the value xxx that maximizes this value (we will need to iterate over all xxx and take the max).
    p=1p = 1p=1, Bob moves. Analogically to the previous case, Bob takes s=ai+ai+1+⋯+ai+x−1s = a_i + a_{i + 1} + \dots + a_{i+x-1}s=ai​+ai+1​+⋯+ai+x−1​ stones during his move. However, we do not count them in the result of fff, because we defined fff to return the number of stones Alice gets. Just like with Alice, if Bob takes xxx stones, then the next state will have i=i+xi = i + xi=i+x and m=max⁡(m,x)m = \max(m, x)m=max(m,x). Because Alice goes next, we will have p=0p = 0p=0. As we mentioned earlier, Bob wants to minimize the number of stones Alice receives, and thus Bob wants to minimize the return value of fff. Thus, f(1,i,m)f(1, i, m)f(1,i,m) will be the minimum of f(0,i+x,max⁡(m,x))f(0, i + x, \max (m, x))f(0,i+x,max(m,x)) for all valid xxx, which we will again iterate over.

Now, we are ready to code the solution.

The issue here is that fff might be called (exponentially) many times for the same parameters (p,i,m)(p, i, m)(p,i,m).

For example, we call f(0,7,4)f(0, 7, 4)f(0,7,4) for the first time and calculate the result for p=0p = 0p=0, i=7i = 7i=7, m=4m = 4m=4. But when we call f(0,7,4)f(0, 7, 4)f(0,7,4) for the second time, we recompute the same result.

Instead, one may keep the calculated values of f(0,7,4)f(0, 7, 4)f(0,7,4) in memory. We will store the table dp[2][n + 1][n + 1]. In this case, the process will be as follows.

For example, we call f(0,7,4)f(0, 7, 4)f(0,7,4) for the first time, calculate the result for p=0p = 0p=0, i=7i = 7i=7, m=4m = 4m=4 and write this result into dp[0][7][4]. When we call f(0,7,4)f(0, 7, 4)f(0,7,4) for the second time, we do not recompute the same result but return the value of dp[0][7][4].

Saving the function results in memory is called memoization.

It is how we calculate the value of fff for each state (each triplet of parameters (p,i,m)(p, i, m)(p,i,m)) only once.

There remains one small technical question: how to know whether we call f(p,i,m)f(p, i, m)f(p,i,m) for the first time and need to compute the result, or we call it later and can return dp[p][i][m] which we computed earlier? One can handle this by initializing the dp matrix with -1. Then dp[p][i][m] = -1 will mean that f(p,i,m)f(p, i, m)f(p,i,m) was not calculated yet. As soon as we find the result f(p,i,m)f(p, i, m)f(p,i,m), we will write it into dp[p][i][m], and this value will not be -1 anymore.
Algorithm

The function f takes three parameters: p, i, and m.

    If i=ni = ni=n, return 000. (The base case of the recursion.)
    If dp[p][i][m] != -1 (which means that we found this value earlier), return dp[p][i][m].
    Initialize s=0s = 0s=0. sss is the number of stones the player takes during the current move. Also initialize res, the return value of the current state. If it's Bob's turn, initialize it with a large number since Bob wants to minimize the return value. If it's Alice's turn, initialize it with a small number since Alice wants to maximize the return value.
    Iterate xxx from 111 to min⁡(2m,n−i)\min(2m, n - i)min(2m,n−i), as indicated by the problem description.
        Add piles[i + x - 1] to sss.
        If p=0p = 0p=0 (Alice moves), update the result with s+f(1,i+x,max⁡(m,x))s + f(1, i + x, \max(m, x))s+f(1,i+x,max(m,x)) if it is larger than the current res.
        If p=1p = 1p=1 (Bob moves), update the result with f(0,i+x,max⁡(m,x))f(0, i + x, \max(m, x))f(0,i+x,max(m,x)) if it is smaller than the current res.
    Write res into dp[p][i][m].
    Return res.

One needs to initialize the table dp[2][n + 1][n + 1] with -1 in the main function and return f(0,0,1)f(0, 0, 1)f(0,0,1).
Implementation
Complexity Analysis

    Time complexity: O(n3)O(n^3)O(n3).

There are O(n2)O(n^2)O(n2) possible states (p,i,m)(p, i, m)(p,i,m) (O(1)O(1)O(1) options for 0≤p≤10 \le p \le 10≤p≤1, O(n)O(n)O(n) options for 0≤i≤n0 \le i \le n0≤i≤n and O(n)O(n)O(n) options for 1≤m≤n1 \le m \le n1≤m≤n).

For each state, to calculate f(p,i,m)f(p, i, m)f(p,i,m), we try all possible values of xxx in the for loop, which performs min⁡(2⋅m,n−i)=O(n)\min(2 \cdot m, n - i) = O(n)min(2⋅m,n−i)=O(n) iterations.

Since, for each state, we calculate f(p,i,m)f(p, i, m)f(p,i,m) only once, thus the total time complexity is O(n2)⋅O(n)=O(n3)O(n^2) \cdot O(n) = O(n^3)O(n2)⋅O(n)=O(n3).

    Space complexity: O(n2)O(n^2)O(n2).

We store the table dp[2][n + 1][n + 1] of size O(n2)O(n^2)O(n2).
Comments (20)
 */

class Solution {
    private int f(int[] piles, int[][][] dp, int p, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        if (dp[p][i][m] != -1) {
            return dp[p][i][m];
        }
        int res = p == 1 ? 1000000 : -1, s = 0;
        for (int x = 1; x <= Math.min(2 * m, piles.length - i); x++) {
            s += piles[i + x - 1];
            if (p == 0) {
                res = Math.max(res, s + f(piles, dp, 1, i + x, Math.max(m, x)));
            }
            else {
                res = Math.min(res, f(piles, dp, 0, i + x, Math.max(m, x)));
            }
        }
        return dp[p][i][m] = res;
    }
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length + 1][piles.length + 1];
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i <= piles.length; i++) {
                for (int m = 0; m <= piles.length; m++) {
                    dp[p][i][m] = -1;
                }
            }
        }
        return f(piles, dp, 0, 0, 1);
    }
}
