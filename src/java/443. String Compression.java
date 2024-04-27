443. String Compression.java
problem : https://leetcode.com/problems/string-compression/
class Solution {
    public int compress(char[] chars) {


    //   Map<Character,Integer> ansMap=new HashMap<Character,Integer>();
    //     for(int i=0;i<chars.length;i++){
    //             if(ansMap.containsKey(chars[i])){
    //                 if(ansMap.get(chars[i])==0){  
    //                   ansMap.put(chars[i],ansMap.get(chars[i])+2);}
    //                 else{
    //                 ansMap.put(chars[i],ansMap.get(chars[i])+1);
    //                 }
    //             }
    //             else{
    //                 ansMap.put(chars[i],0);
    //             }
    //     }
    //     String ansString=ansMap.toString();
    //     ansString=ansString.replace("{","");
    //     ansString=ansString.replace("=","");
    //     ansString=ansString.replace("}","");
    //     ansString=ansString.replace(" ","");
    //     ansString=ansString.replace(",","");
    //     ansString=ansString.replace("0","");
    //     System.out.println(ansString);
    //     for(int i=0;i<ansString.length();i++){
    //         chars[i]=ansString.charAt(i);
    //     }
    //     return ansString.length();
    if(chars.length==1){return 1;}

    char prev=chars[0];
    String ansStr="";
    int count=1;
    for(int i=1;i<chars.length;i++){
            if(prev!=chars[i]){
                if(count==1){
                    ansStr+=prev;
                }
                else{
                    ansStr+=prev;
                    ansStr+=count;
                }
                count=0;
                prev=chars[i];
            }
             count++;
            if(i==chars.length-1 && prev==chars[i]){
                 ansStr+=prev;
                 if(count!=1){
                 ansStr+=count;}
            }
          
            
    }
    System.out.println(ansStr);
    for(int i=0;i<ansStr.length();i++){
            chars[i]=ansStr.charAt(i);
    }
    return ansStr.length();
    }
}
