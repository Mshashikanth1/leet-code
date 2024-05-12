class Solution {
    public int findPermutationDifference(String s, String t) {
    int[] sCharArr= new int[26], tCharArr=new int[26];

    for(int i=0 ;i<s.length(); i++){
         sCharArr[s.charAt(i)-'a'] = i;
    }
    for(int i=0 ;i<t.length(); i++){
        tCharArr[t.charAt(i)-'a'] = i;
    }

    int ans=0;
    for(int i=0 ;i<26; i++){
        ans+= Math.abs(sCharArr[i] - tCharArr[i]);
    }

    return ans;
        
    }
}