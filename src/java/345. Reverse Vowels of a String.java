/*
345. Reverse Vowels of a String
Easy
3.5K
2.5K
Companies

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"

Example 2:

Input: s = "leetcode"
Output: "leotcede"

 

Constraints:

    1 <= s.length <= 3 * 105
    s consist of printable ASCII characters.


 */
class Solution {
    public String reverseVowels(String s) {

        Stack<Character> stack=new Stack<>();
        char[] chr=s.toCharArray();
        int n=chr.length;

        for(char ch : chr){
            if(isVowel(ch)){
                stack.push(ch);
            }
        }

          for(int i=0;i<n;i++){
            if(isVowel(chr[i])){
                chr[i]=stack.pop();
            }
        }

        return String.valueOf(chr);

    }

    public Boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U';
    }
}
