class Solution {
    public int[] plusOne(int[] digits) {
        int c=0,i=digits.length-1,l=digits[i];
        digits[i]=(l+1)%10;
        c=(l+1)/10;
         i--;
        while(i>=0 && c!=0){
           
            l=digits[i];
              digits[i]=(l+1)%10;
             c=(l+1)/10; 
            i--;
        }
        
        if(c==0)
            return digits;
        else{
            int[] arr= new int[digits.length+1];
            arr[0]=c;
            int j=0;
            while(j<digits.length){
                arr[j+1]=digits[j];
                j++;
            }
            return arr;
        }
        
    }
}
