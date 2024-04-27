class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }
}
/**

2610. Convert an Array Into a 2D Array With Conditions
Medium
1.1K
48
Companies
You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.

 

Example 1:

Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.
Example 2:

Input: nums = [1,2,3,4]
Output: [[4,3,2,1]]
Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= nums.length

Approach: Frequency Counter
Intuition

The first thing to observe here is how many rows we need at least to ensure each row has distinct integers. Each repeated integer in the original array nums needs to be placed in a separate row. Therefore, we need at least as many rows as the maximum frequency of integers in the array nums.

Now, we know that if an integer has KKK instances, it would be kept in KKK different rows. So we can keep placing each instance in the row with an index equal to the current frequency. The 0−th0-\text{th}0−th instance of this integer will kept at row index 0, the 1−st1-\text{st}1−st instance at row index 1, and so on till the (K−1)−th(K - 1)-\text{th}(K−1)−th instance at the row index K - 1. Note that, if there is one integer with K1K1K1 instances and another integer with K2K2K2 instances, we need max(K1,K2)max(K1, K2)max(K1,K2) rows but not K1+K2K1 + K2K1+K2 rows. This is because we can have just max(K1,K2)max(K1, K2)max(K1,K2) rows and the other integer with fewer instances can be also stored in these rows.

We generally use a HashMap to store the frequencies. However, as mentioned in the problem, the values in the array would be up to the length of the array (which can be up to 200). Since we know the range of the values, it's efficient to use an array with a size of N + 1, where NNN is the length of nums. We will be using the array freq for this purpose. Now, we will iterate over the integers in the array nums and retrieve the current frequency of the integer from freq.

If the frequency of the current integer is greater than the current size of the two-dimensional array ans, indicating that we need to start a new row to store this element, so we add a row and insert the element into the new row.

Then we increment the frequency of this integer.

Current

Algorithm

Create an array freq of size nums.size() + 1 to store the frequency of integers in the array nums.

Create an empty 2D array ans to store the answer array.

Iterate over the array nums and for each integer c:

a. If the frequency of the integer is greater than or equal to the current rows count in ans, then add a row to ans.

b. Insert the integer c at the row freq[c].

c. Increment the frequency of c in freq.

Return ans.

Implementation


Complexity Analysis

Here, NNN is the size of array nums.

Time complexity: O(N)O(N)O(N)

We iterate over the array nums once to insert them into the 2D array ans. Accessing freq and incrementing it takes O(1)O(1)O(1). Hence, the total time complexity is equal to O(N)O(N)O(N).

Space complexity: O(N)O(N)O(N)

The size of the frequency array freq is equal to nums.size() + 1 as the value of integers in the array nums can be up to nums.size(). Hence, the total space complexity is equal to O(N)O(N)O(N).
 */
