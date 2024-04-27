/*

649. Dota2 Senate.java
Medium
1K
823
Companies

In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

    Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
    Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.

Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".

 

Example 1:

Input: senate = "RD"
Output: "Radiant"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.

Example 2:

Input: senate = "RDD"
Output: "Dire"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And the third senator comes from Dire and he can ban the first senator's right in round 1. 
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.

 

Constraints:

    n == senate.length
    1 <= n <= 104
    senate[i] is either 'R' or 'D'.


Dota2  --> Radiant & Dire
  |            +
  + ---> contains senator's of both 
    
 */
//class Solution {
  //  public String predictPartyVictory(String senate) {
        // int countR=0,countD=0;
        // for(char ch: senate.toCharArray()){
        //     if(ch=='R')countR++;
        //     else countD++;
        // }
        // System.out.println(countR+","+countD);
        // char[] chance=new char[2];

        // if(senate.length()>=2){
        // chance[0]=senate.charAt(0);
        // chance[1]=senate.charAt(0)=='R' ? 'D' : 'R';}
        // else return senate.charAt(0)=='R'? "Radiant" : "Dire";

        // int i=0;
        // while(senate.contains("RD") || senate.contains("DR")){
        // System.out.println(senate+","+chance[i%2]);
       
        // senate=senate.replaceFirst("RD",chance[i%2]+"");
        // senate=senate.replaceFirst("DR",chance[i%2]+"");
        
        // i++;
        // }
        // System.out.println(senate);
        // return   senate.charAt(0)=='R'? "Radiant" : "Dire";


        //if(chr.get(chr.size()-2)!=chr.get(0)){
        //  chr.set(chr.size()-2,chr.get(0));
       
    //    List<Character> chr=new ArrayList<>();
    //    Map<Character,Character> enemie=new HashMap<>();
    //    enemie.put('R','D');
    //    enemie.put('D','R');
    //    enemie.put('_','_');
    //     for(char ch: senate.toCharArray()){
    //         chr.add(ch);
    //     }
    //     int i=0,right,left,indx=-1;
    //     boolean rightFound=false,leftFound=false;
    //     while(new HashSet<>(chr).size()>2){
    //         if(i==chr.size()){i=0;}
         
    //      int index = chr.subList(i, chr.size()).indexOf(enemie.get(chr.get(i)));
    // if (index != -1) {
    //     indx= i + index;
    // } else {
    //     indx= chr.subList(0, i).indexOf(enemie.get(chr.get(i)));
    // }
    //     if(index>=0)
    //       chr.set(indx,'_');          
    //       i++;
        
    //     System.out.println(chr.toString()+","+i);

    //     }
    //      System.out.println(chr.toString()+","+i);
    //      System.out.println(String.valueOf(chr.toString().replace("[","").replace("]","").replace("_","").replace(" ","").replace(",","")));
    //    return  String.valueOf(chr.toString().replace("[","").replace("]","").replace("_","").replace(" ","").replace(",",""))
    //    .charAt(0)=='R'? "Radiant" : "Dire";
        
//     }
// }

class Solution {

    // Ban the candidate "toBan", immediate next to "startAt"
    public void ban(String senate, boolean[] banned, char toBan, int startAt) {
        // Find the next eligible candidate to ban
        int pointer = startAt;
        while (true) {
            if (senate.charAt(pointer) == toBan && !banned[pointer]) {
                banned[pointer] = true;
                break;
            }
            pointer = (pointer + 1) % senate.length();
        }
    }

    public String predictPartyVictory(String senate) {

        // To mark Banned Senators
        boolean[] banned = new boolean[senate.length()];

        // Count of Each Type of Senator who are not-banned
        int rCount = 0, dCount = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        // Turn of Senator at this Index
        int turn = 0;

        // While both parties have at least one senator
        while (rCount > 0 && dCount > 0) {

            if (!banned[turn]) {
                if (senate.charAt(turn) == 'R') {
                    ban(senate, banned, 'D', (turn + 1) % senate.length());
                    dCount--;
                } else {
                    ban(senate, banned, 'R', (turn + 1) % senate.length());
                    rCount--;
                }
            }

            turn = (turn + 1) % senate.length();
        }

        return dCount == 0 ? "Radiant" : "Dire";
    }
}
