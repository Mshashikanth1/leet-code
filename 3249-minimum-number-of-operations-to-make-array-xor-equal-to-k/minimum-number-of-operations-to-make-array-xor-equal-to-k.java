class Solution {
    public int minOperations(int[] nums, int k) {
        int res=0;
        for(int i:nums) res^=i;

        int[] b1= toBinaryRepArr(res), b2= toBinaryRepArr(k);


        int c=0;
        for(int i=0; i<32; i++){
            if(b1[i]!=b2[i]) c++;
        }

        return c;
    }

    public int[] toBinaryRepArr(int n){
        int[] bin =new int[32]; int i=31;
        while(n>0){
            bin[i--]=n%2;
            n/=2;
        }
        return bin;
    }
}