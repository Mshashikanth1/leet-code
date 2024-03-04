class Solution {
    /**
    face up : will cost power and gains 1 score
    face down : will cost 1 score and gain power
    each toke value is +ve , initial power is +ve and score is 0


948. Bag of tokens 

Score =0;
power= function parameter 

Token =[t1,t2,t3…….tn]

Face-up()=>  power-ti (play) —> 1 score
(At least one score ) Face-down() => ti (1 score). —> gain power  

We need to maximise the score

(Play:1)
p=50
s=0
t=[50,50,50,100]

(Play:2)
p=0
s=1
t=[Face-up,50,50,100]


(Play:3)
p=100
s=0
t=[Face-up,50,50,Face-down]



(Play:4)
p=50
s=1
t=[Face-up,Face-up,50,Face-down]




(Play:5)
p=0
s=2
t=[Face-up,Face-up,Face-up,Face-down]

Maximum score s=2;

Array.sort(Token);

SORT & GREADY  (Maintain the largest score )

Face-up ==> small token
Face-Down ==> bigger token

Two pointers
Play with the power until it becomes 0; earn score;
Play with the score and buy only the larger once until zero;
Again play with the power to get 

Time : O(nlogn)

     */
    public int bagOfTokensScore1(int[] tokens, int power) {
        int score=0,res=0,l=0,n=tokens.length,r=n-1;
        Arrays.sort(tokens);
        while(l<=r){
            //Face-up
            if(power >= tokens[l]){
                power-=tokens[l];
                score+=1;
                l++;
                res=Math.max(score,res);
            }else if(score > 0){ //face-down
                power+=tokens[r];
                score-=1;
                r--;
            }else break; //to avoid in finite loop
        }
        return res; //max score found
    }

        public int bagOfTokensScore(int[] tokens, int power) {
            int n=tokens.length,score=0;
            Arrays.sort(tokens);
            Deque<Integer> deque=new LinkedList<>();
            for(int token: tokens) deque.add(token);

            while(!deque.isEmpty()){
                if(power >= deque.peekFirst()){
                    power -= deque.pollFirst();
                    score+=1;
                }else if (score > 0. && deque.size()>1 ){
                    power+=deque.pollLast();
                    score-=1;
                } else return score;
            }
        return score;

        }

}





/**
948. Bag of Tokens
Solved
Medium
Topics
Companies
You start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer array tokens, where each tokens[i] donates the value of tokeni.

Your goal is to maximize the total score by strategically playing these tokens. In one move, you can play an unplayed token in one of the two ways (but not both for the same token):

Face-up: If your current power is at least tokens[i], you may play tokeni, losing tokens[i] power and gaining 1 score.
Face-down: If your current score is at least 1, you may play tokeni, gaining tokens[i] power and losing 1 score.
Return the maximum possible score you can achieve after playing any number of tokens.

 

Example 1:

Input: tokens = [100], power = 50

Output: 0

Explanation: Since your score is 0 initially, you cannot play the token face-down. You also cannot play it face-up since your power (50) is less than tokens[0] (100).

Example 2:

Input: tokens = [200,100], power = 150

Output: 1

Explanation: Play token1 (100) face-up, reducing your power to 50 and increasing your score to 1.

There is no need to play token0, since you cannot play it face-up to add to your score. The maximum score achievable is 1.

Example 3:

Input: tokens = [100,200,300,400], power = 200

Output: 2

Explanation: Play the tokens in this order to get a score of 2:

Play token0 (100) face-up, reducing power to 100 and increasing score to 1.
Play token3 (400) face-down, increasing power to 500 and reducing score to 0.
Play token1 (200) face-up, reducing power to 300 and increasing score to 1.
Play token2 (300) face-up, reducing power to 0 and increasing score to 2.
The maximum score achievable is 2.

 

Constraints:

0 <= tokens.length <= 1000
0 <= tokens[i], power < 104
 */
