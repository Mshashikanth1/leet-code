1528. Shuffle String.java
problem : https://leetcode.com/problems/shuffle-string/
class Solution {
    public String restoreString(String s, int[] indices) {
        String c="";
        for(int i=0;i<indices.length;i++){
        for(int j=0;j<indices.length;j++){
            if(i==indices[j]){
                c+=s.charAt(j);
            }
        }
    }
            return c;

}
}
