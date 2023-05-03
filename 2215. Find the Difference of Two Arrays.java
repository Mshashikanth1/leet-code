/*

2215. Find the Difference of Two Arrays.java
Easy
1.1K
49
Companies

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.

Note that the integers in the lists may be returned in any order.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

Example 2:

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

 

Constraints:

    1 <= nums1.length, nums2.length <= 1000
    -1000 <= nums1[i], nums2[i] <= 1000


 */
class Solution {
    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {

        List<List<Integer>> ans=new ArrayList<>(); 

        Set<Integer> a=new LinkedHashSet<>();
        Set<Integer> b=new LinkedHashSet<>();
        int n=nums1.length,m=nums2.length,i=0,j=0;
        while(i<n){
            a.add(nums1[i]);
            i++;
        }

        while(j<m){
            b.add(nums2[j]);
            j++;
        }

        //String[] str= a.toString().replace("[","").replace("]","").split(",");
        //System.out.println(str);
        List<Integer> copyOfSet =new ArrayList<Integer>();
       for( int l : a){
           copyOfSet.add(l);
       }


        for( int  k: copyOfSet){
            // System.out.println(Integer.parseInt(k+""));
            if(b.contains(k
                //Integer.parseInt(k.strip()))
            )){

                b.remove((k
                //Integer.parseInt(k.strip()))
                ));
                a.remove((k
                //Integer.parseInt(k.strip()))
                ));
            }
        }

        ans.add(new ArrayList<>(a));
                ans.add(new ArrayList<>(b));

        
        
        return ans;
        
    }

     public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> ans=new ArrayList<>(); 
        List<Integer>a=Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer>b=Arrays.stream(nums2).boxed().collect(Collectors.toList());

        Set<Integer> mySet=new HashSet<>();
        a.forEach(i->mySet.add(i));

        mySet.forEach(j->{if(b.remove(j))  a.remove(j); });


        ans.add(a);
        ans.add(b);
        return ans;

        
    }

    /*
    
    nums1 = [1,2,3], nums2 = [2,4,6]

    set=[1,2,3]

     */
}
