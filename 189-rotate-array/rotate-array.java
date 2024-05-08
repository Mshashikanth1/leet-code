class Solution {
    public void rotate(int[] nums, int k) {
            k= k % nums.length;

           int[] numsCopy=new int[nums.length];

           for(int i=0; i<nums.length; i++) numsCopy[i]= nums[i];  

           int j=0;

    
           for(int i=nums.length-k;  i<nums.length; i++){
                //    System.out.println(numsCopy[i]);
                    nums[j++] = numsCopy[i];
           }

            for(int i=0; i< nums.length-k; i++){
                    nums[j++] = numsCopy[i];
           }

          
    }
}