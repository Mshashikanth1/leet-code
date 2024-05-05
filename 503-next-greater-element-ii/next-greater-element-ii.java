class Solution {

    //Time :O(n^2) Space : O(n)
    public int[] nextGreaterElements1(int[] nums) {

        int[] ans =new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int j=i+1, mric=-1;
            while(true){
                j=j%nums.length;
                if(nums[j] > nums[i]) {mric=nums[j];  break;}
                else if(i==j) break;
                j++;
            }

            ans[i]=mric;
        }
        return ans;
        
    }


   
    public int[] nextGreaterElements2(int[] nums) {

        int[] ans =new int[nums.length];
        int[] cirNums=new int[nums.length*2];

        for(int i=0;i<nums.length;i++) cirNums[i]=nums[i];
        for(int i=nums.length-1; i>=0 ;i--) cirNums[nums.length+i]=nums[i];
        System.out.print(Arrays.toString(cirNums));

        
        for(int i=0; i<nums.length; i++){
            int  mric=-1;
           
            for(int j=i; j<cirNums.length; j++){
                if(cirNums[j] > nums[i]) {mric=cirNums[j];  break;}
            }

            ans[i]=mric;
        }
        return ans;
    }

     public int[] nextGreaterElements(int[] nums) {

        int[] ans =new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            int  mric=Integer.MIN_VALUE;
           
            for(int j=i; j<nums.length; j++){
                if(nums[j] > nums[i]) {mric=nums[j];  break;}
            }

            if(mric==Integer.MIN_VALUE){
                for(int j=0; j<=i; j++){
                    if(nums[j] > nums[i]) {mric=nums[j];  break;}
                }
            }

            ans[i]=mric==Integer.MIN_VALUE ? -1 : mric;
        }
        return ans;
    }
}

