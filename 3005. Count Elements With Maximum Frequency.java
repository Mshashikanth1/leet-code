class Solution {

    /**
    1. the number of elements with maximum frequecy 
    appraoch : 1.count the frequencey of the elements (a)
               2.count the frequencey of the frequecy. (b)
               3.find the maximum frequencey of the frequency Max(b.getKeys) (c)
               4. the number of elements with max frequece is  c*b.get(c)
    Time : O(n)
    Space :O(n)
     */
    public int maxFrequencyElements(int[] nums) {

        
        Map<Integer,Integer> hMapFreq=new HashMap<>();
        for(int i: nums){
            int freq= hMapFreq.containsKey(i) ? hMapFreq.get(i) : 0;
            freq+=1;
            hMapFreq.put(i,freq);
        }

        Map<Integer,Integer> hMapFreqFreq=new HashMap<>();
        for(int i: hMapFreq.values()){
            int freq= hMapFreqFreq.containsKey(i) ? hMapFreqFreq.get(i) : 0;
            freq+=1;
            hMapFreqFreq.put(i,freq);
        }

        int maxFreqFreq=-1;
        for(int i: hMapFreqFreq.keySet())   maxFreqFreq=Math.max(maxFreqFreq,i);
        
        return maxFreqFreq*(hMapFreqFreq.get(maxFreqFreq));
    }
}


/**
3005. Count Elements With Maximum Frequency
Solved
Easy
Topics
Companies
Hint
You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that element in the array.

 

Example 1:

Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.
Example 2:

Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

 */
