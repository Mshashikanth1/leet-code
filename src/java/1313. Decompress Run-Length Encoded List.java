/*
1313. Decompress Run-Length Encoded List.java
problem :https://leetcode.com/problems/decompress-run-length-encoded-list/
 */
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int freq,val,n=nums.length,m=0;
    
        //count the number of elements will be there in the new ans array using frequecy
        for(int i=0;i<n;i+=2){
            freq=i;
            val=i+1;
            System.out.println(nums[freq]+","+nums[val]);
            m+=nums[freq];
        }

        //after calculating the new array size with the frequiec's index initizlize the array
        int[] ans=new int[m];
        int k=0;

        for(int i=0;i<n;i+=2){
            freq=i;
            val=i+1;

            //for the frequecy of the elements insert the value
            for(int j=0;j<nums[freq];j++){
                ans[k]=nums[val];
                k++;
            }
        }

        return ans;
        
    }
}
