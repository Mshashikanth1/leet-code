771. Jewels and Stones.java
Problem : https://leetcode.com/problems/jewels-and-stones/
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int numberOfJewels=0;
        for(int i=0;i<jewels.length();i++){
            for(int j=0;j<stones.length();j++){
                if(stones.charAt(j)==jewels.charAt(i)){numberOfJewels+=1;}
            }
        }
        return numberOfJewels;
    }
}
