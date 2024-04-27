
/*
338. Counting Bits
Easy
8.8K
419
Companies

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

 

Constraints:

    0 <= n <= 105

 
 */
//using in build to string and integer functions
//time complexity O(n^2) , space complexity O(n)
class Solution1 {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
        int count=0;
        for(char ch: Integer.toBinaryString(i).toCharArray()){
            if(ch=='1') count++;
        }
        ans[i]=count;
        }

        return ans;
    }
}

//not using in build strings and  integer funcsion ,
//time complexity is O(n^3) space complexity is O(n)
class Solution2 {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
        int count=0;
        for(char ch: toBinaryCharArray(i)){
            if(ch=='1') count++;
        }
        ans[i]=count;
        }

        return ans;
    }

    public char[] toBinaryCharArray(int n){
        String  ans="";
        //perform synthetic array
        while(n>0){
            ans=n%2+ans;
            n=n/2;
        }
        return ans.toCharArray();

    }
}


//not using in build strings and  integer funcsion we can remove extra method which we  will convert to binary string array  ,
//time complexity is O(n^2) space complexity is O(n)
class Solution3 {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
        ans[i]=SyntheticDivisiionAndCountOnes(i);
        }
        return ans;
    }

    public int SyntheticDivisiionAndCountOnes(int n){
        int count=0;
        while(n>0){
            if(n%2==1) count++;;
            n=n/2;
        }
        return count;

    } 
}

class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=dfs(n);
        }
        return ans;
    }

    public int dfs(int n){
        if(n==0) return 0;
        else if (n==1) return 1;
        return n%2+dfs(n-1);
    } 
}



