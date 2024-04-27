/*
27. Remove Element.java
Problem : https://leetcode.com/problems/remove-element/
 */
class Solution {
    public int removeElement(int[] nums, int target) {
   int j=nums.length-1,i=0,temp;
	while(i<=j){
		try {
			while (nums[j] == target) {
				j--;
			}
			if (i<=j && nums[i] == target) {
				System.out.println("performing swapping : "+i+","+j);
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
			i++;
		}catch(Exception e){
			System.out.println(e);
			for(i=0;i< nums.length;i++){
				System.out.print(nums[i]+",");
			}
			System.out.println();
			return j+1;
		}
	}
	for( i=0;i< nums.length;i++){
		System.out.print(nums[i]+",");
	}
	System.out.println();

	return j+1;
}
}
