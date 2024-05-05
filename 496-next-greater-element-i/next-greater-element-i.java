class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] ans=new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
             // search nums1[i] in nums2;
             int j=0;
             while(j<nums2.length) if(nums2[j++]==nums1[i]) break;

            int mri=-1;
             while(j<nums2.length) {
                if(nums1[i] < nums2[j]) {mri=nums2[j]; break;}
                j++;
             }

             ans[i]=mri;
             
        }
        return ans;
     }
}