class Solution {

    /**
       using hash set intersection in built funcits
       convert the nums1 & nums2 hashset and make interse section 
       Time : O(m+n);
       Space  : O(n)
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> intersection= new HashSet<>();
        Set<Integer> set2= new HashSet<>();

        for(int i : nums1) intersection.add(i);
        for(int i : nums2) set2.add(i);

        intersection.retainAll(set2);
        int[] ans =new int[intersection.size()];
        int j=0;
        for(int i: intersection) {ans[j]=i; j++;}
        return ans;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
     int[] frqArr=new int[1000+1];
     Set<Integer> ans=new HashSet<>();
     for(int i: nums1) frqArr[i]++;
     for(int i:nums2) if(frqArr[i]>0) ans.add(i);
     return ans.stream().mapToInt(i->i).toArray();
    
    }


    /**
    349. Intersection of Two Arrays
Solved
Easy
Topics
Companies
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

     */

   

}
