class Solution {

    /**  T :O(n) S: O(1)*/
    public int numWaterBottles(int numBottles, int numExchange) {
             int consumedBottles=0,  unUsedEmptyBottles=0;
             while( numBottles >= numExchange){

               consumedBottles += numExchange;
               numBottles -= numExchange;
              numBottles++;
             }

             return consumedBottles + numBottles;
    }
}
/**
1518. Water Bottles
Solved
Easy
Topics
Companies
Hint
There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

 

Example 1:


Input: numBottles = 9, numExchange = 3
Output: 13
Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13.
Example 2:


Input: numBottles = 15, numExchange = 4
Output: 19
Explanation: You can exchange 4 empty bottles to get 1 full water bottle. 
Number of water bottles you can drink: 15 + 3 + 1 = 19.
 

Constraints:

1 <= numBottles <= 100
2 <= numExchange <= 100
Seen this question in a real interview before?
1/5
Yes
No
Accepted
174.8K
Submissions
253.3K
Acceptance Rate
69.0%
Topics
Math
Simulation
Companies
Hint 1
Simulate the process until there are not enough empty bottles for even one full bottle of water.
Similar Questions
Discussion (126)
 */
