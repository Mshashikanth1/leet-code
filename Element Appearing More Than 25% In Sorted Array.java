class Solution {
    public int findSpecialInteger1(int[] arr) {
    return  Arrays.stream(arr)
                  .boxed()
                  .collect(Collectors.groupingBy(e->e,Collectors.counting()))
                  .entrySet()
                  .stream()
                  .filter(e->e.getValue() > 0.25*arr.length)
                  .findFirst()
                  .map(Map.Entry::getKey)
                  .orElse(null);
    }
      public int findSpecialInteger(int[] arr) {
          Map<Integer,Integer> hashTable=new HashMap<>();
          for(int i: arr)
          hashTable.put(i,hashTable.containsKey(i) ? hashTable.get(i)+1 : 1);
          
          for(Map.Entry<Integer,Integer> entry : hashTable.entrySet() )
              if(entry.getValue() > 0.25*arr.length) return entry.getKey();
          
          return -1;
    }
}

/**
1287. Element Appearing More Than 25% In Sorted Array
Easy
1.5K
67
Companies
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.

 

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
Example 2:

Input: arr = [1,1]
Output: 1
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 105

 */
