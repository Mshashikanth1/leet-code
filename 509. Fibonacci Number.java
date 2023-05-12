/*
509. Fibonacci Number
Easy
6.7K
314
Companies

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.

Given n, calculate F(n).

 

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

 

Constraints:

    0 <= n <= 30


 */
//brute force time compexity : logn , space : O(1)
class Solution1 {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }
}

//rereating sub problems present in this problem 
//memorization or Top-Down time complexity : O(n) , space : O(n)
class Solution2 {
    public int fib(int n){
        Map<Integer,Integer>hashMap=new HashMap<>();
        return fibMemo(n,hashMap);
    }
    public int fibMemo(int n,Map<Integer,Integer> hashMap) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(hashMap.containsKey(n)) return hashMap.get(n);
        hashMap.put(n,fib(n-1)+fib(n-2));
        return hashMap.get(n);
    }
}


//Tabulation or Bottom-UP 
class Solution {
    public int fib(int n) {
       int[] arr =new int[n+2];
       arr[0]=0;
       arr[1]=1;
       for(int i=2;i<=n;i++){
           arr[i]=arr[i-1]+arr[i-2];
       }
       return arr[n];
    }
}
