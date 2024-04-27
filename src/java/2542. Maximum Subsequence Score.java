
/*
2542. Maximum Subsequence Score
Medium
1.4K
62
Companies

You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:

    The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
    It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).

Return the maximum possible score.

A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

 

Example 1:

Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
Output: 12
Explanation: 
The four possible subsequence scores are:
- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6. 
- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12. 
- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
Therefore, we return the max score, which is 12.

Example 2:

Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
Output: 30
Explanation: 
Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.

 

Constraints:

    n == nums1.length == nums2.length
    1 <= n <= 105
    0 <= nums1[i], nums2[j] <= 105
    1 <= k <= n


Solution
Overview

As shown in the picture below, if we select the index 0, 2, and 3, the score is defined as the product of the following two terms:

    The sum of all selected nums1[i], sum = 1 + 3 + 2 = 6.
    The minimum one from the selected nums2[i], min = min(2, 3, 4) = 2.

img

Thus the score equals 6 * 2 = 12. Our task is to find the maximum score if we pick k indexes.
Approach: Priority Queue
Intuition

Start with a brute force approach, if we find the maximum score by checking all groups of indexes with size k, there are (nk)=n!k!(n−k)!{n \choose k} = {{n!}\over{k! (n - k)!}}(kn​)=k!(n−k)!n!​ possibilities. We can't afford to check them one by one.

Let's first focus on the minimum of the selected elements from nums2. If we pick nums2[i] as the minimum, it means the other k - 1 selected elements from nums2 are larger or equal to nums2[i].

We can thus take advantage of this restriction on the selection by sorting nums2, which can reduce the time complexity. Assume that we have sorted nums2 by decreasing order (Note that we can't change the relative order of nums1 and nums2, so its better to store each pair as (nums1[i], nums2[i]) and sort the collection of pairs according to nums2[i]).

As shown in the picture below, if we pick nums2[i] (colored in red) as the minimum selected element from nums2, we can freely select the rest k - 1 indexes to the left of i without changing the second term: minimum of the selected elements from nums2.

img

Recall the definition of the score, the second term has been fixed as nums2[i], so we can maximzie the total score by maximizing the first term, that is, by selecting the maximum k elements from nums1 including nums1[i].

img

This can be done efficiently by maintaining a min-heap that always contains the largest k elements we have seen. Whenever we pick a new nums2[i] as the minimum from nums2, we shall remove one element from the heap (which represents removing a nums1 number and add nums[i] to it. Now the heap contains the largest k element including nums1[i] again, the current score equals the sum of this heap times nums2[i].

We can iterate over nums2 and repeat the above process. At each step, we calculate the current score and update answer as the maximum score we have met.

Take the following slides as an example:

Current

Algorithm

    Store every pair (nums1[i], nums2[i]) in array pairs, and sort pairs by the second element (nums2[i]) in decreasing order.

    Use a min-heap top_k_heap to store the first k nums1[i] and a variable top_k_sum to store their sum.

    Initialize answer as the sum of elements in top_k_heap (i.e. top_k_sum) times pairs[k - 1][1].

    Iterate over indices starting from k, at each index i:
        Remove the smallest element stored in top_k_heap and from top_k_sum.
        Add the current nums1[i] to the heap and top_k_sum.
        Get the current score as the sum of top_k_heap (i.e. top_k_sum) times nums2[i], and update answer as the maximum score we have met.

    Return answer.

Implementation
Complexity Analysis

Let nnn be the length of the input array nums1.

    Time complexity: O(n⋅log⁡n)O(n \cdot \log n)O(n⋅logn)

        We need to sort nums2, it takes O(n⋅log⁡n)O(n \cdot \log n)O(n⋅logn).

        Then we iterate over pairs of length n. At each iteration step i, we remove the smallest element from top_k_heap and add one element pairs[i][0] to it. Both the inserting and removing operations to priority queue of size kkk take O(log⁡k)O(\log k)O(logk) time.

        To sum up, the overall time complexity is O(n⋅log⁡n)O(n \cdot \log n)O(n⋅logn), because k≤nk \leq nk≤n.

    Space complexity: O(n)O(n)O(n)
        We store every pair (nums1[i], nums2[i]) in a 2-d array pairs, it takes O(n)O(n)O(n) space.
        The in-place sorting method also uses some additional space, in Python, it uses O(n)O(n)O(n) space and in Java, it uses O(log⁡n)O(\log n)O(logn) space.
        The priority queue contains at most kkk elements thus it takes O(k)O(k)O(k) space.


 */
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // Sort pair (nums1[i], nums2[i]) by nums2[i] in decreasing order.
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        // Use a min-heap to maintain the top k elements.
        PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        long topKSum = 0;
        for (int i = 0; i < k; ++i) {
            topKSum += pairs[i][0];
            topKHeap.add(pairs[i][0]);
        }
        
        // The score of the first k pairs.
        long answer = topKSum * pairs[k - 1][1];
        
        // Iterate over every nums2[i] as minimum from nums2.
        for (int i = k; i < n; ++i) {
            // Remove the smallest integer from the previous top k elements
            // then ddd nums1[i] to the top k elements.
            topKSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);
            
            // Update answer as the maximum score.
            answer = Math.max(answer, topKSum * pairs[i][1]);
        }
        
        return answer;
    }
}
