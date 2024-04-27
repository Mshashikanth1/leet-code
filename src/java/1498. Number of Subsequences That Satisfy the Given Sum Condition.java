/*
1498. Number of Subsequences That Satisfy the Given Sum Condition
Medium
2.4K
214
Companies

You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)

Example 2:

Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]

Example 3:

Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).

 

Constraints:

    1 <= nums.length <= 105
    1 <= nums[i] <= 106
    1 <= target <= 106


 */
/*

 nums=[3,5,6,7]  targe =9

valid sub sequnces
[3]    sum =max+min 3+3 =6
[3,5]   sum=max+min =3+5 =9
[3,5,6] sum=9
[3,6] sum=9

non valid sub sequnces 
[5]  sum=10
[6,7] sum =13
[3,5,6,7] sum=10
Brute-force approach : we simply generate all possible subsequences and then iterate through each subsequece to find its max and minimum 
this approach is feasible but the time complexity will be very high.

Binary Search Approach:
assuming the size of the array is n. we will have O(2^n) non-empty subsequences, resulting in a time complexity of O(2^n.n) this method is very expensive and indicates that we need a more efficient way to traverse the subsequence.

note that we only need to consider the minimum and maximum elements of a subsequnece to determine whether it is valid ,and elements with values bbetween them do not affect our judgment . therefore, we can traverse all possible, (minium, maximum ) combinations and check if they are valid 

if there are k subsequnces with min as the minimum value and max as the maximum avlue , we need only to check if max+min < target. the values that are between min and max, t,the number of such subsequnces k depends on how many elemnts hthat have between min and max . therefore we nee to sort nums first, so that the nubmber of values between min and max  can be represented bu their index difference, 

hear , we let left and right be the pointers to the mminimum elemnts and the maximum element. that is nums[left]=min.
 
 nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]
                 left                                                            right
 target=18
  min=nums[left]
  now  e need to traverse each possible minimum value . for min=nums[left], we need to ensure that the subsequences with this number as the minimum value are valid, which means the maximum element of these subsequncess cannot be greater thatn target-nums[left]. in other words, we need to find the largets element thatis not greater thatn target-num[left] . as shown in the picture below, we have found that nums[right]=12 is the rightmost element that is smaller thatn or equal to 17-nums[left], then we can freely pick element with the range [left+1,right] to make valid subsequnces.


 nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]
                 left                                                            right
                     \                                                           /
                       \                                                        /
                         +------>freeey pick elemts within this range  <-------+   

                         target=17
                         for examplee
                         [5,6,10,12]
                         [5,12]
                         [5,6,6.9]   

  since the array is already sorted , we can use binary search to  find the insertion posision of targer-nums[left]. Note that we are looking for the rightmost element that is smaller thatn or equal to targer-nums[left], and binary search find the index of the smallest element that is larger than targe-nums[left]. therefore,once we find the rightmost insertion posion as k we have right =k-1.

  now we have the left and right indices . for each number in the range [left+1,right], there are 2 Options. we can either thake it or not take it , so ther are a total of 2^right-left valid subsequences that have nums[left] as the minimum element.    


 nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]
                 left                                                            right
                                                                                       \
                                                                                       /
                                                                                    12
                 +-------------------------------------------------------------------+
                 | find the insertion position for (target-min) 17-nums[left]=12     |
                 +-------------------------------------------------------------------+

Nest, we move to the next min by moving the left pointer left one step to the right . we repeat the process by using binary search to find the new insertion position of (targer-nums[left]).


 nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]              target=17
        left                                                                                 right
        ---->                                                                                      \
                                                                                                   /
                                                                                    max=17-min = 14


  nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]              target=17
                  left                                                             right
                   ---->                                                                \
                                                                                        /
                                                                         max=17-min = 12
                                                                                  


  nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]              target=17
                            left                                      right
                            ---->                                          \
                                                                           /
                                                             max=17-min = 11



some time we may envounter situations where left>right and we don't need to consider these subsequnces because they have already been calucluated before and there is no need to recaulcautalte them again'


  nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]              target=17
                                         right          left 
                                               \         ---->  
                                               /
                                  max=17-min = 8

Algorithm :
1. Initialize anser=0 and the length of nums as n
2. iterate over the left index left from 0 to n-1 , for each index left:
        a. user binary search to locate the rightmost index right which (nums[right]<=targer-nums[left])
        b.if (left<=right),count the total numver of valid subsequnces as 2^right-left
        c. increament anser by the number of valid subsequnces.
3. return anser once the iteration ends.

Complexity Analusis:
Let n be the length of the input String s.
    a.Time Complexity : O(n.log(n))
        i.we sort nums, which take O(n.log(n)) time.
        ii.in java , we initialize an arraay power and precompute the value of 2 to the power of each value it takes O(n) time.
        iii.we iterate over nums, for each left index left, we use binary search to locate the rightmost element that is smaller thant or equal to target-nums[left].
        iv.binary search over array of size takes O(log(n)) on average.
        v. tom sum up the overall time complexity is O(n.log(n)).
    
    b. Space Complexity : O(n) or O(1)
        i.in java we initialize an array power and precompute the value of 2 to the power of each it takes O(n) space.
        ii. during the iterate over left , we onlu need to compute right and update anser, both take constatn space.
        iii. therefore, the space complexity is O(n) for java and O(1) for python

 */
class Solution1 {
    public static int binarySearchRightMost(int[] nums,int target){
            int left=0,right=nums.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(nums[mid]<=target){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }

            }
            return left;
    }
    public int numSubseq1(int[] nums, int target) {
        int answer=0,n=nums.length;
        int mod=1_000_000_007;
        Arrays.sort(nums);

        int[] power=new int[n];
        power[0]=1;
        for(int i=1;i<n;++i){
            power[i]=(power[i-1]*2)%mod;
        }


        //Iterate over each left pointer.
        for(int left=0;left<n;left++){
    
            //find the insertion positon for 'target-nums[left]'
            //'right equals'tje insertion index minus1.
            int right=binarySearchRightMost(nums,target-nums[left])-1;


            if(left<=right){
                answer+=power[right-left];
                answer%=mod;
            }

        }
                    return answer;
        
    }
}


/*
Two Pointer Approach :

intuitaion:
Reacalling the binary search in the prious soulution , we traverse left from 0 to n-1 so the valud of (target-nums[left]) actually decresases which means the insertion postion of (targer-nums[left]) int the array also decreses.
 
        nums[         -------->   ]                targer
         left(min)                right (max)
         --->                      <----


therefore, we do not bother applying binary serach, but only need to set anouther pointer right for the largest element which is smaller thatn or equal to (targer-nums[left]). in the processing of traversing left, the pointer right is monotonically moving to the left and the time complexity of the algotihm post-sort is only O(n) insteand of O(n.logn) in the previous approach (althourgh ) the overall thiem complexity will not change due to the sort).
Take the following sliseds as an example

         0         1           2           3            4              5           6            7
 nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]
         left                                                                                right
          --->                                                                             


                 +------------------------------------------------------------------------+
                 | left=0 right=7 there are 2^7 valid subsequnces that have nums[0 as min |
                 +------------------------------------------------------------------------+



         0         1           2           3            4              5           6            7
 nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]
                  left                                                           right
                    --->                                                                             


                 +------------------------------------------------------------------------+
                 | left=1 right=6 there are 2^5 valid subsequnces that have nums[1] as min |
                 +------------------------------------------------------------------------+     


 
         0         1           2           3            4              5           6            7
 nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]
                             left                                    right
                              --->                                                                             


                 +------------------------------------------------------------------------+
                 | left=2 right=5 there are 2^3 valid subsequnces that have nums[1] as min |
                 +------------------------------------------------------------------------+      

 
 
         0         1           2           3            4              5           6            7
 nums  [ 3   ,    5     ,     6     ,     6     ,       9     ,       10      ,   12      ,   14 ]
                                        left            right
                                         --->                                                                             


                 +------------------------------------------------------------------------+
                 | left=1 right=2 there are 2^3 valid subsequnces that have nums[1] as min |
                 +------------------------------------------------------------------------+        



Algorithm :
1.initialize anser=0 and the length of nums as 0 . set two pointers left=0 and right=n-1.
2. iterate over left while left<=right, for each index left:
            i.(nums[left]+nums[right]>targer), it menas nums[right] is too larger for the right boundary we shall ove it to the left by setting right=right-1.
            ii. other wise, right is the rightmost index with (nums[right]<=targer-nums[left]), we can count the total number of valid subsequnces as 2^right-left and increment anser by this number.
            Repeat step 2.
3. return anser once the iteration ends.


 */

 class Solution {
    
    public int numSubseq(int[] nums, int target) {
        int n=nums.length, mod=1_000_000_007,answer=0,left=0,right=n-1;
        Arrays.sort(nums);

        //precompute the vale of 2 to the poser of each value.
        int[] power=new int[n];
        power[0]=1;
        for(int i=1;i<n;++i){
            power[i]=(power[i-1]*2)%mod;
        }

        while(left<=right){
            if(nums[left]+nums[right]<=target){
                answer+=power[right-left];
                answer%=mod;
                left++;

            }
            else{
                right--;
            }
        }
        return answer;
        
    }
}
