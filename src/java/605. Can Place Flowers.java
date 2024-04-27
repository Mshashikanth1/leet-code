/*
flowerbed[i] ==0 can be placed 
605. Can Place Flowers.java
problem : https://leetcode.com/problems/can-place-flowers/
*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ZeroCount=0;
        //length 1 array check
        if(flowerbed.length==1 &&flowerbed[0]==0){
            return true;
        }
        

        //first element check
        if(flowerbed[0]==0 && flowerbed[1]==0){
              flowerbed[0]=1;
                n-=1;
        }

        //form i=1 to i=length-1 can be inserted??
        for(int i=1;i<flowerbed.length-1;i++){
            if(flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;
                n-=1;

            }
        }

        //last element check
        if(flowerbed.length > 2 && flowerbed[flowerbed.length-2]==0 && flowerbed[flowerbed.length-1]==0){
              flowerbed[flowerbed.length-1]=1;
                n-=1;
        }

        
        return n<=0;
    }
}
