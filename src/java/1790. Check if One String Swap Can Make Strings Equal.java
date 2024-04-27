// 1790. Check if One String Swap Can Make Strings Equal.java
// problem : https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/
class Solution {
    public String swapString(String str,int i,int j){
        char[] charArray=str.toCharArray();
        char temp=charArray[i];
        charArray[i]=charArray[j];
        charArray[j]=temp;
        System.out.println(String.valueOf(charArray));
        return String.valueOf(charArray);
    }
    public boolean areAlmostEqual(String s1, String s2) {
        int sum=0,diff=0;
        for(int i=0;i<s1.length();i++){
            sum+=(s1.charAt(i)-s2.charAt(i));
            if(s1.charAt(i)!=s2.charAt(i)){
                diff+=1;
            }
            if(!s2.contains(s1.charAt(i)+"")) return false;
            if(!s1.contains(s2.charAt(i)+"")) return false;
        }
        System.out.println(sum);
        return sum==0 && (diff==2 || diff==0);
    }
}
