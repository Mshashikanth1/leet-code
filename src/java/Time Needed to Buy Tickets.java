class Solution {

       /**Time :O(k*n) Space :O(n)*/
    public int timeRequiredToBuy0(int[] tickets, int k) {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<tickets.length; i++) queue.offer(i);

        int c=0;
        while(!queue.isEmpty()){
            if(tickets[k]==0) return c;
            int p=queue.poll();
            tickets[p]--;
            if(tickets[p]!=0) queue.offer(p);
             c++;
        }
        return c;
    }

    /* Time : O(k*n) Space :O(1) */
    public int timeRequiredToBuy1(int[] tickets, int k) {
      
      int c=0, n=tickets.length;
      if(tickets[k]==1) return k+1;
      while(tickets[k]>0){
            for(int i=0; i<n; i++){
                if(tickets[i]!=0){
                    tickets[i]--;
                    c++;
                }
                if(tickets[k]==0) return c;
            }
       }
       return c;
    }


    /** Time :O(n) Space :O(1) */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int c=0;
        for(int i=0; i<tickets.length; i++)
            c += Math.min( tickets[k] - (i<=k ? 0:1)  , tickets[i]); 
        return c;
    }
}


/**
2073. Time Needed to Buy Tickets
Solved
Easy
Topics
Companies
Hint
There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.

You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line.

Return the time taken for the person at position k (0-indexed) to finish buying tickets.

 

Example 1:

Input: tickets = [2,3,2], k = 2
Output: 6
Explanation: 
- In the first pass, everyone in the line buys a ticket and the line becomes [1, 2, 1].
- In the second pass, everyone in the line buys a ticket and the line becomes [0, 1, 0].
The person at position 2 has successfully bought 2 tickets and it took 3 + 3 = 6 seconds.
Example 2:

Input: tickets = [5,1,1,1], k = 0
Output: 8
Explanation:
- In the first pass, everyone in the line buys a ticket and the line becomes [4, 0, 0, 0].
- In the next 4 passes, only the person in position 0 is buying tickets.
The person at position 0 has successfully bought 5 tickets and it took 4 + 1 + 1 + 1 + 1 = 8 seconds.
 

Constraints:

n == tickets.length
1 <= n <= 100
1 <= tickets[i] <= 100
0 <= k < n
 */
