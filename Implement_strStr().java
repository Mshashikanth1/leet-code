class Solution {
    public int strStr(String haystack, String needle) {
      
        if(haystack.length()<needle.length()){return -1;}
          for(int i=0;i<=haystack.length()-needle.length();i++){
              
              int j=0;
              while (j<needle.length() && haystack.charAt(i+j)==needle.charAt(j)){
                  
                  if(j==needle.length()-1){return i;}
                  j++;
              }
            
              }   
          
    return -1;
    }
        
}
