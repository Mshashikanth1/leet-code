class Solution1 {
    // Initialize a hash map to cache the result of each sub-problem
    Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();

    public int minFallingPathSum(int[][] grid) {
        // We can select any element from the first row. We will select
        // the element which leads to minimum sum.
        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < grid.length; col++) {
            answer = Math.min(answer, optimal(0, col, grid));
        }

        // Return the minimum sum
        return answer;
    }

    // The optimal(row, col) function returns the minimum sum of a
    // falling path with non-zero shifts, starting from grid[row][col]
    int optimal(int row, int col, int[][] grid) {
        // If the last row, then return the value of the cell itself
        if (row == grid.length - 1) {
            return grid[row][col];
        }

        // If the result of this sub-problem is already cached
        if (memo.containsKey(new Pair<>(row, col))) {
            return memo.get(new Pair<>(row, col));
        }

        // Select grid[row][col], and move on to next row. For next
        // row, choose the cell that leads to the minimum sum
        int nextMinimum = Integer.MAX_VALUE;
        for (int nextRowCol = 0; nextRowCol < grid.length; nextRowCol++) {
            if (nextRowCol != col) {
                nextMinimum = Math.min(nextMinimum, optimal(row + 1, nextRowCol, grid));
            }
        }

        // Minimum cost from this cell
        memo.put(new Pair<>(row, col), grid[row][col] + nextMinimum);
        return memo.get(new Pair<>(row, col));
    }
}

class Solution {
    public int minFallingPathSum(int[][] grid) {
        // Minimum and Second Minimum Column Index
        int nextMin1C = -1;
        int nextMin2C = -1;

        // Minimum and Second Minimum Value
        int nextMin1 = -1;
        int nextMin2 = -1;

        // Find the minimum and second minimum from the last row
        for (int col = 0; col < grid.length; col++) {
            if (nextMin1 == -1 || grid[grid.length - 1][col] <= nextMin1) {
                nextMin2 = nextMin1;
                nextMin2C = nextMin1C;
                nextMin1 = grid[grid.length - 1][col];
                nextMin1C = col;
            } else if (nextMin2 == -1 || grid[grid.length - 1][col] <= nextMin2) {
                nextMin2 = grid[grid.length - 1][col];
                nextMin2C = col;
            }
        }

        // Fill the recursive cases
        for (int row = grid.length - 2; row >= 0; row--) {
            // Minimum and Second Minimum Column Index of the current row
            int min1C = -1;
            int min2C = -1;

            // Minimum and Second Minimum Value of current row
            int min1 = -1;
            int min2 = -1;

            for (int col = 0; col < grid.length; col++) {
                // Select minimum from valid cells of the next row
                int value;
                if (col != nextMin1C) {
                    value = grid[row][col] + nextMin1;
                } else {
                    value = grid[row][col] + nextMin2;
                }

                // Save minimum and second minimum
                if (min1 == -1 || value <= min1) {
                    min2 = min1;
                    min2C = min1C;
                    min1 = value;
                    min1C = col;
                } else if (min2 == -1 || value <= min2) {
                    min2 = value;
                    min2C = col;
                }
            }

            // Change of row. Update nextMin1C, nextMin2C, nextMin1, nextMin2
            nextMin1C = min1C;
            nextMin2C = min2C;
            nextMin1 = min1;
            nextMin2 = min2;
        }
        
        // Return the minimum from the first row
        return nextMin1;
    }
}