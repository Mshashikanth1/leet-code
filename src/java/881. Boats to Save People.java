// 881. Boats to Save People.java
//problem : https://leetcode.com/problems/boats-to-save-people/description/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans=0,i=0,j=people.length-1;
        while(i<=j){
            ans++;
            if(people[i]+people[j]<=limit)
               i++;
            j--;

        }
        return ans;
        
    }
}
