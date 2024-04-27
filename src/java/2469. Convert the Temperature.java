2469. Convert the Temperature.java
problem : https://leetcode.com/problems/convert-the-temperature/description/
class Solution {
    public double[] convertTemperature(double celsius) {
        double[] ans=new double[2];
        ans[0]=celsius+273.15; //kelvin=Celciys+273.15
        ans[1]=celsius*1.80+32.00; //Fahrenheit = Celsius * 1.80 + 32.00
        return ans;
    }
}
