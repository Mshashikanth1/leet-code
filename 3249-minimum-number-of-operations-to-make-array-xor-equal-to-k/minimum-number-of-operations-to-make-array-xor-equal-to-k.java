class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=0;
        for(int i:nums) xor^=i;

        String b1=String.format("%32s", Integer.toBinaryString(xor)).replace(' ', '0');
        String b2=String.format("%32s", Integer.toBinaryString(k)).replace(' ', '0');

        int c=0;
        for(int i=0;i<32;i++){
            if(b1.charAt(i)!=b2.charAt(i)) c++;
        }

        return c;
    }
}