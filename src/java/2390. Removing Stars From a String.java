//2390. Removing Stars From a String.java
//problem :https://leetcode.com/problems/removing-stars-from-a-string/
class Solution {

    //brute force O(n^2)
    public String removeStarsBruteForce(String s) {
        char[] chr=s.toCharArray();
        int i=0;
        while(i<s.length()){
            if(chr[i]=='*'){
                chr[i]='_';
                int j=i;
                while(chr[j]=='_'){
                    j--;
                }
                chr[j]='_';
            }
            i++;
            
        }
        return String.valueOf(chr).replace("_","");
        
    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='*'){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        String str=stack.toString();
        str=str.replace(",","");
        str=str.replace("[","");
        str=str.replace("]","");
        str=str.replace(" ","");

       // stack.forEach(i-> str+=i);

        return str;

    }

}
