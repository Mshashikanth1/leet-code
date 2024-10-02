class Solution {

    /** T: O(n*n)  S: O(n) TLE*/
    public int[] _arrayRankTransform(int[] arr) {
        Set<Integer> set = new TreeSet<>(), visited= new HashSet<>(); 

        for(int i: arr) set.add(i);

        int rank=1;
        for( int i : set) {
                for( int k=0; k<arr.length; k++) {
                    if( !visited.contains(k) && arr[k]==i ) {  arr[k]=rank; visited.add(k); }
                }
            rank++;
        }

        return arr;
    }

    /** T: O(n) S: O(n) */
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new TreeSet<>(); 
        for(int i: arr) set.add(i);

        Map<Integer, Integer> hmap= new HashMap<>();
        int j=1;
        for( int i : set) hmap.put( i, j++);

        for( int k=0; k<arr.length; k++)  arr[k]=hmap.get(arr[k]); 

        return arr;
    }
}
/**

40 , 10, 20, 30
4  , 1, 2, 3   


set( 10, 20, 30, 40 )
0 , 1, 2, 3

1331. Rank Transform of an Array
Solved
Easy
Topics
Companies
Hint
Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.
 

Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.
Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
 

Constraints:

0 <= arr.length <= 105
-109 <= arr[i] <= 109

 */
