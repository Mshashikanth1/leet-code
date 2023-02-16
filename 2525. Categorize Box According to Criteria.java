2525. Categorize Box According to Criteria.java
problem:https://leetcode.com/problems/categorize-box-according-to-criteria/
class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume=(long)length*(long)width*(long)height;
        Boolean bulky=false,heavy=false;
        if (length>=Math.pow(10,4) || width>=Math.pow(10,4) || height>=Math.pow(10,4) || mass>=Math.pow(10,4) || volume>=Math.pow(10,9) ){
           bulky=true;
        }
        if(mass>=100){ heavy=true;}

        if(bulky==true && heavy==true){return "Both";}
        else if(bulky==false && heavy==false){return "Neither";}
        else if(bulky==true && heavy==false){return "Bulky";}
        else if(bulky==false && heavy==true){return "Heavy";}
        return "";
    }
}
