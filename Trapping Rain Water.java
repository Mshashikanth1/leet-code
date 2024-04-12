class Solution {

    /**Time : O(n^2) Space : O(1) */
    public int trap1(int[] height) {
        int water=0;
        for(int i=0;i<height.length;i++){
            int lMax= 0, rMax=0,l=i, r=i;

            while(l>=0) lMax=Math.max(lMax, height[l--]);
            while(r<height.length) rMax=Math.max(rMax, height[r++]);

            water+=Math.min(lMax,rMax)-height[i];
        }
        return  water;
    }

    /**Time :O(n) Space :O(1) */
    public int trap(int[] height) {
        int water=0, l=0, r=height.length-1, lMax=height[l], rMax=height[r];
        while(l<=r){
            lMax=Math.max(lMax, height[l]);
            rMax=Math.max(rMax, height[r]);

            water += lMax>rMax ?  rMax-height[r--] : lMax-height[l++];
        }
        return water;
    }
}





/**
42. Trapping Rain Water
Solved
Hard
Topics
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

 */
