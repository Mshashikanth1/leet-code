2114. Maximum Number of Words Found in Sentences.java
Problem: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
class Solution {
    public int mostWordsFound(String[] sentences) {
        int MaxWords=0;
        for(int i=0;i<sentences.length;i++){
            MaxWords=Math.max(sentences[i].split(" ").length,MaxWords);
        }
        return MaxWords;
    }
}
