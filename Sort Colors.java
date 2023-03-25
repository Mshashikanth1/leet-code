//  Sort Colors.java
//Problem https://leetcode.com/explore/learn/card/sorting/694/comparison-based-sorts/4483/
class Solution {
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            int minimumValue=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[minimumValue]){
                    minimumValue=j;
                }
            }
            int temp= nums[i];
            nums[i]=nums[minimumValue];
            nums[minimumValue]=temp;
            System.out.println(Arrays.toString(nums));
        }
        
    }
}
