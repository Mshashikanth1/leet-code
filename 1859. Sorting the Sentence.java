/*
1859. Sorting the Sentence.java
problem :https://leetcode.com/problems/sorting-the-sentence/
 */
class Solution {
    public String sortSentence(String s) {
        String[] strArr=s.split(" ");
        int n= strArr.length;
        String[] str=new String[n];
        int idx,len;
        for(String st : strArr){
            len=st.length()-1;
            idx=Integer.parseInt(st.charAt(len)+"")-1;
            str[idx]=st.substring(0,len);
            
        }
        String ans="";
        for(String st: str){
                ans+=st;
                ans+=" ";
        }
        return ans.trim();
    }
}
