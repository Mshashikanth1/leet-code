//problem :https://leetcode.com/problems/separate-the-digits-in-an-array/description/
class Solution {
    public int[] separateDigits(int[] nums) {
        List lis= new ArrayList<Integer>();
                    String str="";
        for(int i=0;i<nums.length;i++){
            str+=nums[i]+"";
                }
            System.out.println(str);
            int[] arr= new int[str.length()];
            for(int i=0;i<str.length();i++){
                    if(str.charAt(0)!='0')
                      arr[i]=str.charAt(i)-'0';}
            return arr;

        }
        
    }
