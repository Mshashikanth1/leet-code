917. Reverse Only Letters.java
problem : https://leetcode.com/problems/reverse-only-letters/
class Solution {
    public boolean checkIsAlphabet(char chr){
        int asciiValueOfChr=chr-0;
        return (asciiValueOfChr>=65 && asciiValueOfChr<=90) //Higher Case English Alphabet
               ||(asciiValueOfChr>=97 && asciiValueOfChr<=122);  // Lower Case English Alphabet
    }
    public String reverseOnlyLetters(String s) {
        char[] charArray=s.toCharArray();
        int i=0,j=charArray.length-1;
        char temp;
        while(i<j){
            if(!checkIsAlphabet(charArray[i])){
               i++;
               }
            else if(!checkIsAlphabet(charArray[j])){
               j--;
               }
            else {
                temp= charArray[i];
                charArray[i]=charArray[j];
                charArray[j]=temp;

                i++;
                j--;
            }
        }

        String ans="";
        for(i=0;i<charArray.length;i++){
            ans+=charArray[i];
        }

        return ans;
        
    }
}
