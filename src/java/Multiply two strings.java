

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        boolean neg=false;
        boolean neg1=false;
        boolean neg2=false;
        int i=0,j=0;
        for(;i<s1.length();i++){
            if(s1.charAt(i)=='-') neg1=true;
            else if(s1.charAt(i)>='1' && s1.charAt(i)<='9') break;
        }
        if(i==s1.length()) return "0";
        for(;j<s2.length();j++){
            if(s2.charAt(j)=='-') neg2=true;
            else if(s2.charAt(j)>='1' && s2.charAt(j)<='9') break;
        }
        if(j==s2.length()) return "0";
        
        if(neg1==true && neg2==true) neg=false;
        else if(neg1==true || neg2==true) neg=true;
        
        s1=s1.substring(i);
        s2=s2.substring(j);
        
        int[] ans=new int[s1.length()+s2.length()];
        for(i=s1.length()-1;i>=0;i--){
            for(j=s2.length()-1;j>=0;j--){
                ans[i+j+1]+=(s1.charAt(i)-'0')*(s2.charAt(j)-'0');
                ans[i+j]+=ans[i+j+1]/10;
                ans[i+j+1]%=10;
            }
        }
        i=0;
        StringBuilder sb=new StringBuilder();
        while(i<ans.length && ans[i]==0) i++;
        while(i<ans.length) sb.append(ans[i++]);
        return (neg==true)?"-"+sb.toString():sb.toString();
    }
}


/*
Multiply two strings
MediumAccuracy: 20.06%Submissions: 162K+Points: 4
Win from a prize pool of INR 15K and get exciting merch! Register your team for Hack-A-Thon today!

Given two numbers as strings s1 and s2. Calculate their Product.

Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers.

Example 1:

Input:
s1 = "0033"
s2 = "2"
Output:
66

Example 2:

Input:
s1 = "11"
s2 = "23"
Output:
253

Your Task: You don't need to read input or print anything. Your task is to complete the function multiplyStrings() which takes two strings s1 and s2 as input and returns their product as a string.

Expected Time Complexity: O(n1* n2)
Expected Auxiliary Space: O(n1 + n2); where n1 and n2 are sizes of strings s1 and s2 respectively.

Constraints:
1 ≤ length of s1 and s2 ≤ 103

*/
