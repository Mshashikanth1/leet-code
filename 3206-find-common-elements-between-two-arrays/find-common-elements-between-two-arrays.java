class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int c1=0, c2=0;
        Set<Integer> hSet1 =new HashSet<>();
        Set<Integer> hSet2=new HashSet<>();
        
        
        for(int i: nums1) 
            hSet1.add(i);

        for(int j:nums2){
            if(hSet1.contains(j)) c2++;
            hSet2.add(j);
        }

        for(int i: nums1) {
           if(hSet2.contains(i)) c1++;
        }

        return new int[]{c1,c2};
    }
}