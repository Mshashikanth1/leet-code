// 2405. Optimal Partition of String.java
// problem: https://leetcode.com/problems/optimal-partition-of-string/submissions/
class Solution {
    public int partitionString(String s) {
        List<String> requiredPartition= new ArrayList<>();
        String subStr="";
        for(char c : s.toCharArray()){
            if(subStr.contains(c+"")){
                requiredPartition.add(subStr);
                subStr="";
                subStr+=c;
            }
            else{
                subStr+=c;
            }
        }
        if(subStr.length()!=0){
            requiredPartition.add(subStr);
            subStr="";
        }
        System.out.println(requiredPartition.toString());
        return requiredPartition.size();
    
    }
}
