/*
     0->3,2
        1->3,2
        2->2,1
        3->1,0. //length of all nodes are equal

        0->0,0
        1->2,2
        2->1,1

        0->


class Solution {
    public int maximumRequests(int n, int[][] requests) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] req :requests){
            if(map.containsKey(req[0])){
                List<Integer> lis=map.get(req[0]);
                lis.add(req[1]);
                map.put(req[0],lis);
            }
            else{
                List<Integer> lis=new ArrayList<>();
                lis.add(req[1]);
                map.put(req[0],lis);
            }
        }

        System.out.println(map.toString());
        return 10;
        
    }
}

Approach 1 : Backtracking:
Algorithm 
1. initialize answer to 0; this will store the maximum requests we can consider.
2. Initialize an array indegree of size N with all the values as 0. this array will store the employee change count for each building
3.start the recursion with index and count as 0. The count here is the number of requests we have considered in the current combination. for each index:
    i). if we have iterated over all the requests, check if the values in the indegree are zero , if yes , update the vaiable answer by comparing it to count. if all values aren't zero, return'
    ii). for the first option, when we consider this request, update the indegree, for both the indexes of the current request involves, and move on to the request with count ad count+1;
    iii). Revert the changes in indegree for the request at index; thhis is the backtracking step
    iV). For the second Option, where we ignore the request , make the recursion call with the following index without changing the count.
4.Retrun anser.
Complexity Analysis:
Here, N is the number of buildings, and M is the number of requests.
Time complexity: O(2^M *N)
we iterate over every two possibilities for each of the M requests; this is equal to 2^M possibilities , for leaf nodes with are 2^M-1 , we will iterate over N buildings to check if the employee change is zero , therefore the total time complexity would be O(2^M *N)

Space Complexity: O(N+M):
the array indegree is of size N , and there would be some stack space as well for the recursion. the maximum number of active stack call would equal M , i..e. when all the request's call would be active , heace the total space complexity would be O(N+M)
 */
class Solution {
    int answer=0;
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree=new int[n];
        maxRequest(requests,indegree,n,0,0);
        return answer;
    }
    void maxRequest(int[][] requests, int[] indegree, int n, int index, int count){
        if(index==requests.length){
            for(int i=0;i<n;i++){
                if(indegree[i]!=0){
                    return ;
                }
            }
            answer=Math.max(answer,count);
            return ;
        }
        //consider this request , incremetn and decrement for the buildeings involved
        indegree[requests[index][0]]--;
        indegree[requests[index][1]]++;

        //move on tho the next request and also increment the coutn of requests.
        maxRequest(requests,indegree,n,index+1,count+1);

        //backtrack to the previous values to move back to the original state before the second recursion.
        indegree[requests[index][0]]++;
        indegree[requests[index][1]]--;

        //Ignore this request and move on to the next request without incrementing the count
        maxRequest(requests,indegree,n,index+1,count);
    }

}



/*
Bit Masking  Approach ::
intuition: we can solve the problem iteratively as well; all we need is a way to iterate over every possible combination of requests, that we can consider, we know the number of requests can only go up to 16 , we can user N, bits to represent the 


c    LeetCode Logo

Problem List
Premium
92
DCC Badge
1601. Maximum Number of Achievable Transfer Requests
Hard
675
44
Companies

We have n buildings numbered from 0 to n - 1. Each building has a number of employees. It's transfer season, and some employees want to change the building they reside in.

You are given an array requests where requests[i] = [fromi, toi] represents an employee's request to transfer from building fromi to building toi.

All buildings are full, so a list of requests is achievable only if for each building, the net change in employee transfers is zero. This means the number of employees leaving is equal to the number of employees moving in. For example if n = 3 and two employees are leaving building 0, one is leaving building 1, and one is leaving building 2, there should be two employees moving to building 0, one employee moving to building 1, and one employee moving to building 2.

Return the maximum number of achievable requests.

 

Example 1:

Input: n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
Output: 5
Explantion: Let's see the requests:
From building 0 we have employees x and y and both want to move to building 1.
From building 1 we have employees a and b and they want to move to buildings 2 and 0 respectively.
From building 2 we have employee z and they want to move to building 0.
From building 3 we have employee c and they want to move to building 4.
From building 4 we don't have any requests.
We can achieve the requests of users x and b by swapping their places.
We can achieve the requests of users y, a and z by swapping the places in the 3 buildings.

Example 2:

Input: n = 3, requests = [[0,0],[1,2],[2,1]]
Output: 3
Explantion: Let's see the requests:
From building 0 we have employee x and they want to stay in the same building 0.
From building 1 we have employee y and they want to move to building 2.
From building 2 we have employee z and they want to move to building 1.
We can achieve all the requests. 

Example 3:

Input: n = 4, requests = [[0,3],[3,1],[1,2],[2,0]]
Output: 4

 

Constraints:

    1 <= n <= 20
    1 <= requests.length <= 16
    requests[i].length == 2
    0 <= fromi, toi < n

Accepted
22.4K
Submissions
37.3K
Acceptance Rate
60.1%
Seen this question in a real interview before?
1/4
Yes
No
Discussion (47)
Related Topics
Array
Backtracking
Bit Manipulation
Enumeration
Copyright ©️ 2023 LeetCode All rights reserved
39
21

Maximum Number of Achievable Transfer Requests - LeetCode


 */
