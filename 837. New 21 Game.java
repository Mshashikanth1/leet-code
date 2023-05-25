/*

837. New 21 Game
Medium
1.4K
1K
Companies

Alice plays the following game, loosely based on the card game "21".

Alice starts with 0 points and draws numbers while she has less than k points. During each draw, she gains an integer number of points randomly from the range [1, maxPts], where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.

Alice stops drawing numbers when she gets k or more points.

Return the probability that Alice has n or fewer points.

Answers within 10-5 of the actual answer are considered accepted.

 

Example 1:

Input: n = 10, k = 1, maxPts = 10
Output: 1.00000
Explanation: Alice gets a single card, then stops.

Example 2:

Input: n = 6, k = 1, maxPts = 10
Output: 0.60000
Explanation: Alice gets a single card, then stops.
In 6 out of 10 possibilities, she is at or below 6 points.

Example 3:

Input: n = 21, k = 17, maxPts = 10
Output: 0.73278

 

Constraints:

    0 <= k <= n <= 104
    1 <= maxPts <= 104

Accepted
44.7K
Submissions
112.9K
Acceptance Rate
39.6%
Seen this question in a real interview before?
1/4
Yes

    LeetCode Logo

Problem List
Premium
54
DCC Badge
2.91
(33 votes)
Solution

    Note. For this problem, we assume that you already know the fundamentals of dynamic programming and are figuring out how to apply it to a wide range of problems, such as this one. If you are not yet at this stage, we recommend checking out our relevant Explore Card content on dynamic programming before coming back to this article.

Approach 1: Dynamic Programming
Intuition

Let dp[i]\text{dp}[i]dp[i] be the probability of having exactly iii points at some moment. We are interested only in the states with i≤ni \le ni≤n.

The base case of this DP is dp[0]\text{dp}[0]dp[0]. At the very beginning, Alice has 000 points, thus dp[0]=1\text{dp}[0] = 1dp[0]=1.

Now we need to write down the recurrence relation for dp[i]\text{dp}[i]dp[i] for i>0i > 0i>0.

To have iii points, Alice must have just drawn some number, let's call it jjj, where 1≤j≤min⁡(i,maxPts)1 \le j \le \min (i, \text{maxPts})1≤j≤min(i,maxPts). Before drawing this number, Alice had i−ji - ji−j points and thus moved from the state dp[i−j]\text{dp}[i - j]dp[i−j] to dp[i]\text{dp}[i]dp[i]. Since the game did not end at the state dp[i−j]\text{dp}[i - j]dp[i−j], i−j<ki - j < ki−j<k must also hold.

The probability of drawing jjj points at the state dp[i−j]\text{dp}[i - j]dp[i−j] is 1maxPts\frac{1}{\text{maxPts}}maxPts1​ because all numbers in the range [1,maxPts][1, \text{maxPts}][1,maxPts] are equiprobable. Thus the probability of transitioning from dp[i−j]\text{dp}[i - j]dp[i−j] to dp[i]\text{dp}[i]dp[i] is 1maxPts\frac{1}{\text{maxPts}}maxPts1​.

To calculate dp[i]\text{dp}[i]dp[i], we need to consider all possible values of jjj, and sum all the probabilities.

dp[i]\text{dp}[i]dp[i] for k≤i≤nk \le i \le nk≤i≤n is the state of the game when it's over, and Alice has nnn or fewer points. It implies that the answer to the problem is the sum of dp\text{dp}dp for all such states.

Now we are ready to code the solution.

However, this solution is too slow because its time complexity is O(n⋅maxPts)O(n \cdot \text{maxPts})O(n⋅maxPts). One needs to optimize it.

For finding dp[i]\text{dp}[i]dp[i], we are calculating the sum of the dp\text{dp}dp values in the range [max⁡(0,i−maxPts),min⁡(k−1,i−1)][\max (0, i - \text{maxPts}), \min (k - 1, i - 1)][max(0,i−maxPts),min(k−1,i−1)].

The animation illustrates an example of calculating DP for k=7k = 7k=7, n=11n = 11n=11, maxPts=4\text{maxPts} = 4maxPts=4. The cell dp[i]\text{dp}[i]dp[i] is blue, and the cells that contribute to dp[i]\text{dp}[i]dp[i] are yellow.

Current

Instead of calculating the sum of dp\text{dp}dp values in the yellow segment in O(maxPts)O(\text{maxPts})O(maxPts) each time, one can keep this sum in a variable sss.

For i=1i = 1i=1, the yellow segment is [0,min⁡(k−1,0)][0, \min (k - 1, 0)][0,min(k−1,0)] which is empty when k=0k = 0k=0 or contains the only cell dp[0]\text{dp}[0]dp[0] otherwise. Thus the initial value of sss is 000 when k=0k = 0k=0 and dp[0]=1\text{dp}[0]=1dp[0]=1 when k>0k > 0k>0.

When iii moves to the right, sss needs to change accordingly. The above animation helps to understand which dp\text{dp}dp values one has to add to and subtract from sss. Essentially, sss is a sliding window. We remove dp[i−maxPts]\text{dp}[i - \text{maxPts}]dp[i−maxPts] and add dp[i]\text{dp}[i]dp[i] until i≥ki \ge ki≥k.
Algorithm

    Declare the array dp\text{dp}dp and initialize it with zeros.
    Set dp[0]=1\text{dp}[0] = 1dp[0]=1, the base case.
    Declare the variable sss and initialize it with 111 if k>0k > 0k>0 or with 000 otherwise.
    Iterate iii from 111 to nnn.
        Set dp[i]=smaxPts\text{dp}[i] = \frac{s}{\text{maxPts}}dp[i]=maxPtss​. Remember that sss is the probability of all the states that we could have reached iii from. We need to divide it by maxPts\text{maxPts}maxPts as we mentioned earlier, that is the probability of reaching iii from each of the states.
        If i<ki < ki<k, add dp[i]\text{dp}[i]dp[i] to sss.
        If i−maxPts≥0i - \text{maxPts} \ge 0i−maxPts≥0 and i−maxPts<ki - \text{maxPts} < ki−maxPts<k, subtract dp[i−maxPts]\text{dp}[i - \text{maxPts}]dp[i−maxPts] from sss.
    Return the sum of dp[i]\text{dp}[i]dp[i] for k≤i≤nk \le i \le nk≤i≤n.

Implementation
Complexity Analysis

    Time complexity: O(n)O(n)O(n).

There are n+1n + 1n+1 states of the DP. We calculate each of them in O(1)O(1)O(1).

    Space complexity: O(n)O(n)O(n).

The size of the DP array is n+1n + 1n+1.
Comments (24)
💡 Article Commenting Rules

1. This comment section is for questions and comments regarding this LeetCode article. All posts must respect our LeetCode Community Rules.

2. Concerns about errors or bugs in the article, problem description, or test cases should be posted on LeetCode Feedback, so that our team can address them.
longluo
100 Days Badge 2022
7 hours ago

This problem should be tagged as Hard.
If I met this problem in an interview, I would quit.
69
Show 9 Replies
Reply
ardulat
Apr LeetCoding Challenge
7 hours ago

Honestly, I don't understand what skills this problem evaluates.
27
Show 2 Replies
Reply
kiryu_0
Graph Theory I
4 hours ago

Yesterday I tried my hardest to solve a heap question with DP, today I tried my hardest to solve a DP question with heap. Noice.
22
Reply
Arana
50 Days Badge 2022
4 hours ago

Am I the only one here even having problem understanding this problem?
I feel very frustrated... I had even hard time understanding the answers
call me dumb. i gave up on this problem. if i meet this problem in an interview, i guess i am just not a candidate for that job
13
Show 2 Replies
Reply
tejasnakhate
Algorithm III
5 hours ago

You only ask such problems if you are hiring a statistician.
9
Reply
atxiai
Mar LeetCoding Challenge
5 hours ago

this is a hard problem and it's not weekend yet :(
8
Reply
ansdeki
Annual Badge 2022
7 hours ago

Google really?
7
Reply
MohakHarjani
Annual Badge 2022
5 hours ago

Can someone explain why this recursion code is giving wrong answer
I know it will ultimately give TLE, but I am not getting why is it giving WA
Logic I used
Probab = (no. of cases where points <= n) / (total no. of cases)
= (no. of cases where points <= n) / (no. of cases where points >= k)
WA on 3rd sample case
21
17
10
My ans = 0.55218
Expected = 0.73278

class Solution {
public:
    long long x = 0, y = 0;
    void solve(int n, int k, int maxPts, long long currPoints)
    {
        if (currPoints >= k)
        {
            if (currPoints <= n) x++;
            y++;
            return;
        }
        for (int i = 1; i <= maxPts; i++)
        {
            solve(n, k, maxPts, currPoints + i);
        }
    }
    double new21Game(int n, int k, int maxPts) 
    {
        solve(n, k, maxPts, 0);
        return ((double)x / (double)y);
    }
};

Read more
6
Show 5 Replies
Reply
sohilg002
Apr LeetCoding Challenge
6 hours ago

Leetcode should start awarding for correct understanding of questions too! Took me a while 🫠
5
Show 1 Replies
Reply
cecilia5
Feb LeetCoding Challenge
4 hours ago

The space can be optimized to O(maxPts)O(\text{maxPts})O(maxPts) by maintaining only the last at most maxPts\text{maxPts}maxPts values in a circular queue.

If nnn is much bigger than maxPts+k\text{maxPts} + kmaxPts+k, your code might be just generating a bunch of 000 and then sum them up. Following this thought, you should be able to make the time complexity O(min⁡(n,maxPts+k))O(\min(n, \text{maxPts} + k))O(min(n,maxPts+k)) as well.

The thing I don't understand is how can we guarantee the floating point error does not exceed 10−510^{-5}10−5 after doing 2×10−42 \times 10^{-4}2×10−4 floating point operations, many of them are divisions.


New 21 Game - LeetCode


 */

class Solution1 {
    public double new21Game(int n, int k, int maxPts) {
        double dp[] =new double[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=maxPts;j++){
                if((i-j)>=0 && (i-k) <k){
                    dp[i]+=dp[i-j]/maxPts;
                }
            }
        }

        double ans=0;
        for(int i=k;i<=n;i++){
            ans+=dp[i];
        }
        return ans;
    }
}
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double dp[] = new double[n + 1];
        dp[0] = 1;
        double s = k > 0 ? 1 : 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = s / maxPts;
            if (i < k) {
                s += dp[i];
            }
            if (i - maxPts >= 0 && i - maxPts < k) {
                s -= dp[i - maxPts];
            }
        }
        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }
}
