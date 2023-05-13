/*
1389. Create Target Array in the Given Order.java
problem : https://leetcode.com/problems/create-target-array-in-the-given-order/
 */
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n=nums.length,temp;
        int[] target=new int[n];
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
           arr.add(index[i],nums[i]);
        }
        //arr.toArray(new Integer[n]); --> converts to Object[] --> Integer[]., but we want int[]
        return arr.stream().mapToInt(i->i).toArray();
    }
}
