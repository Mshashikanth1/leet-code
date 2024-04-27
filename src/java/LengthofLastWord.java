class Solution {
    public int lengthOfLastWord(String s) {
        s=s.strip();
        int j=s.length()-1,i=0;
        while (j>=0 && s.charAt(j)!=' '){
            j--;
            i++;
        }
        
        return i;
        
    }
}
