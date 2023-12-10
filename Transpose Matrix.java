class Solution {
    int[][] ans;
    public int[][] transpose(int[][] matrix) {
        int rowLength=matrix.length,colLength=matrix[0].length;
        ans=new int[colLength][rowLength];
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
               ans[j][i]=matrix[i][j];
            }
        }
        return ans;
    }
}

/**
867. Transpose Matrix
Easy

Companies
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal,
switching the matrix's row and column indices.


Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109


Approch 1: Copy Directly
Intutaion and Algorithm
The transpose of a matrix A with dimensions R * C is a matrix 
ans with dimensions C * R for which ans[c][r]=A[r][c].

Let's initialize a new matrix ans representing the anser.
Then, we'll copy each entry of the matrix as appropriate.

Complexity Analysis:
  . Time Complexity: O(R*C), where R and C are the number of rows
    ans columns in the given matrix A.
  . Space Complexity: O(R*C), the space used by the answer.
 */
