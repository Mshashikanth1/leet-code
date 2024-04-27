/*
1232. Check If It Is a Straight Line
Easy
1.8K
212
Companies

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

 

Constraints:

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.


Approach: Slope Property

Intuition

We are given NNN points (x, y), where x and y represent the coordinates. We must return true if the points make a straight line and false otherwise.

To solve this problem, we will use the slope property of a straight line. The slope of a line is defined as the change in Y coordinates with respect to the change in X coordinates of any two points on the line.

    Slope = ΔYΔX\frac{\Delta Y}{\Delta X}ΔXΔY​

The property that can be used to solve this problem is that the slope between any two points on a straight line will be the same. If we choose two points from the given list of points, the value of Slope as defined above should be the same.

We don't actually need to check all pairs of points, but only all slopes relative to one fixed point. We will choose to measure from the point at index 000 and see if all slopes are the same.

fig

So if we have three points p0, p1, p2, and the slope using p0 and p1 is ΔY1ΔX1\frac{\Delta Y1}{\Delta X1}ΔX1ΔY1​ and the slope between p0 and p2 is ΔY2ΔX2\frac{\Delta Y2}{\Delta X2}ΔX2ΔY2​, we will check if these two slopes are equal or not, i.e. ΔY1ΔX1\frac{\Delta Y1}{\Delta X1}ΔX1ΔY1​ = ΔY2ΔX2\frac{\Delta Y2}{\Delta X2}ΔX2ΔY2​ . Since ΔX\Delta XΔX can be zero as well and in that case dividing by it would cause an issue. We can tweak the previous equality equation to convert division into multiplication to avoid the divide by zero issues. The new equation would be:

    ΔY1\Delta Y1ΔY1 * ΔX2\Delta X2ΔX2 = ΔY2\Delta Y2ΔY2 * ΔX1\Delta X1ΔX1

Algorithm

    Find the ΔX\Delta XΔX and ΔY\Delta YΔY using the points at index 0 and 1.
    Iterate over the indices from 2 to the end of the list, and for each index i find the ΔX\Delta XΔX, ΔY\Delta YΔY for points at index 0 and i.
    Compare the slope calculated in step #1 with that of step #2 using the previous equation.
    If the equation is not satisfied, return false.
    Otherwise, at the end of the loop return true.

Implementation

 */
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x=diffX(coordinates[1],coordinates[0]);
        int y=diffY(coordinates[1],coordinates[0]);
        for(int i=2;i<coordinates.length;i++){
            if(x*diffY(coordinates[i],coordinates[0])!=y*diffX(coordinates[i],coordinates[0]))return false;
        }
        return true;
    }
    public int diffX(int[] a, int[] b){return a[0]-b[0];}
    public int diffY(int[] a, int[] b){return a[1]-b[1];}
}
