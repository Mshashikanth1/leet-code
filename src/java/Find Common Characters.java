class Solution {

    /** T :O(len(words)*len(word) )  S : O(len(word))*/
    public List<String> commonChars(String[] words) {

        List<String> ans=new ArrayList<>();
        int[][] wcfa= new int[words.length][26];
        int i=0;

        for( String word: words){
            int[] cfa= new int[26];
            for( char ch : word.toCharArray()) cfa[ch-'a']++;
            wcfa[i++]=cfa;
        }

        
        for(  i=0; i<26; i++){
            int min= Integer.MAX_VALUE;
            for( int[] cfa : wcfa ) min=Math.min( min , cfa[i]);
            while( min-- > 0)  ans.add( (char) ('a'+i) + "" ); 
        }

        return ans;
    }
}

/**
 0 : { "b" : 1 , "e" : 1 , "l" : 2, "a" : 1},
 1 : { "b" : 1 , "e" : 1 , "l" : 2, "a" : 1},
 2 : { "b" : 0 , "e" : 1, "l : 2, "r" : 1, "O" : 1}


1002. Find Common Characters
Solved
Easy
Topics
Companies
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
Seen this question in a real interview before?
1/5
 */
