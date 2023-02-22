1011. Capacity To Ship Packages Within D Days.java
Problem : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discussion/
class Solution {
    public int calculateTheNumberOfDaysNeededWithThisMidCapacity(int[] weights, int maxCapacity){
        int currentCapacity=0, need=1;
        for(int i=0;i<weights.length;i++){
            if(currentCapacity+weights[i]>maxCapacity){
               need+=1;
               currentCapacity=0;}
              currentCapacity+=weights[i];
        }
        return need;
    }
    public int shipWithinDays(int[] weights, int days) {
        int minWeightCapacityOfShip=0,sumOfWeights=0,maxWeightCapacityOfShip=sumOfWeights;
        for(int i=0;i<weights.length;i++){
            minWeightCapacityOfShip=Math.max(minWeightCapacityOfShip,weights[i]); 
            sumOfWeights+=weights[i];
        }
        maxWeightCapacityOfShip=sumOfWeights; 

        int mid=minWeightCapacityOfShip+(maxWeightCapacityOfShip-minWeightCapacityOfShip)/2;
        while(maxWeightCapacityOfShip>minWeightCapacityOfShip){
              mid=minWeightCapacityOfShip+(maxWeightCapacityOfShip-minWeightCapacityOfShip)/2;
              calculateTheNumberOfDaysNeededWithThisMidCapacity(weights,mid);
              if(calculateTheNumberOfDaysNeededWithThisMidCapacity(weights,mid)>days)
                  minWeightCapacityOfShip=mid+1;
              else
                  maxWeightCapacityOfShip=mid;
              }
        return   minWeightCapacityOfShip;

        }

    }
