class Solution {
    public int getCommon1(int[] nums1, int[] nums2) {
        for(int i: nums1){
            for(int j: nums2){
                if(i==j) return i;
            }
        }
        return -1;

    }
    //time: O(n^2) space:O(1)

      public int getCommon2(int[] nums1, int[] nums2) {
        Set<Integer> hashSet=new HashSet<>();
        for(int i: nums1) hashSet.add(i);

        Set<Integer> hashSet2=new TreeSet<>();
        for(int i: nums2) hashSet2.add(i);

        for(int j: hashSet2) if(hashSet.add(j)==false) return j;
        
        return -1;
    }
    //time: O(n+m), n=size(nums1) && m=sizer(num2) space: O(n+m)


      public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> hashSet=new HashSet<>();
        for(int i: nums1) hashSet.add(i);

        for(int j: nums2) if(hashSet.contains(j)) return j;
        
        return -1;
    }
    //time: O(n+m), n=size(nums1) && m=sizer(num2) space: O(n)
}


/**
2540. Minimum Common Value
Easy
482
11
Companies
Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.
Example 2:

Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 

Constraints:

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[j] <= 109
Both nums1 and nums2 are sorted in non-decreasing order.
 */
