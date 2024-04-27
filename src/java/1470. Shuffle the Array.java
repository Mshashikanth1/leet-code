//swap i, n-i-1
/*
1470. Shuffle the Array.java
problem : https://leetcode.com/problems/shuffle-the-array/
5,3 --> 1,3
y array starts with n index;
x array ends witb n-1 index
*/
class Solution {

    public int[] shuffle(int[] nums, int n) {
        int len=nums.length;
        int[] ans=new int[len];
        int j=0;
        //x array
        for(int i=0;i<n;i++){
            ans[j]=nums[i];
            System.out.print(nums[i]+ "-->"+j+" ");
            j+=2;
        }
System.out.println("");
        //y array 
         j=1;
        for(int i=n;i<len;i++){
            ans[j]=nums[i];
            System.out.print(nums[i]+ "-->"+j+" ");
            j+=2;
        }

        
    
        return ans;
    }
}
