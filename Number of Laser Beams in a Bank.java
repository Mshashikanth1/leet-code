class Solution {
  public int numberOfBeams(String[] bank) {
    int prev = 0, ans = 0;

    for (String s: bank) {
      int count = 0;
      for (int i = 0; i < s.length(); i++)
        if (s.charAt(i) == '1') {
          count++;
        }

      if (count > 0) {
        ans += prev * count;
        prev = count;
      }
    }

    return ans;
  }
}

/**
2125. Number of Laser Beams in a Bank
Medium
1.4K
136
Companies
Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.

There is one laser beam between any two security devices if both conditions are met:

The two devices are located on two different rows: r1 and r2, where r1 < r2.
For each row i where r1 < i < r2, there are no security devices in the ith row.
Laser beams are independent, i.e., one beam does not interfere nor join with another.

Return the total number of laser beams in the bank.

 

Example 1:


Input: bank = ["011001","000000","010100","001000"]
Output: 8
Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0th row with any on the 3rd row.
This is because the 2nd row contains security devices, which breaks the second condition.
Example 2:


Input: bank = ["000","111","000"]
Output: 0
Explanation: There does not exist two devices located on two different rows.
 

Constraints:

m == bank.length
n == bank[i].length
1 <= m, n <= 500
bank[i][j] is either '0' or '1'.

Accepted
127.1K
Submissions
148.4K
Acceptance Rate
85.6%
Seen this question in a real interview before?
1/4
Yes
No
Discussion (82)
Similar Questions
Related Topics
Copyright ©️ 2024 LeetCode All rights reserved


Approach: Greedy
Intuition

The laser beam will exist from one row (let's call it row a) to another (row b) if all rows in between have no security devices. In such cases, there will be a laser beam from each safety device in row a to every safety device in row b. Therefore, if the first row has M devices and the second one has N devices, then the total number of laser beams will be M * N between these two rows. Note that it doesn't matter how many rows in between have no safety devices as the beams will only exist between the rows having the devices.

In continuation to the above scenario, the second row with safety devices has N devices, and suppose the third row with safety devices has K devices. Then the number of laser beams between the second and this third row will be N * K, and there will be no other beams between the third row and other previous rows. One thing to observe from here is that we can ignore the rows without safety devices as they will be passed through by the beams that are created by rows having devices. Also, the beams will only be there between adjacent rows with devices and the number of beams will be the product of their device count.

We will keep the count of devices in each row and then multiply it by the number of devices in the previous row which has devices (if it exists). The count of devices in the previous row will be stored in a variable prev and will be updated with the number of devices in the current row (only if the devices count is non zero). The sum of all these products of devices count of every adjacent row with non-zero devices will be our answer.

fig

Algorithm

Initialize prev and ans to 0.
Iterate over each string in bank and initialize the count to 0. Iterate over each character in the string and increment the counter count if the character is a 1.
After iterating over all characters of a string, if the count is not zero then add prev * count to ans. Also update the value of prev to count if count != 0.
Return ans.
Implementation


Complexity Analysis

Here, MMM is the number of strings in the bank and NNN is the average length of the strings.

Time complexity: O(M∗N)O(M * N)O(M∗N)

We have to iterate over each character once to find the number of safety devices in each row and hence the time complexity is equal to O(M∗N)O(M * N)O(M∗N).

Space complexity: O(1)O(1)O(1)

We only need three variables prev, ans and count and hence the space complexity is constant.
 */
