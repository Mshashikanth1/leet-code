class Solution {

    /** Time :O(n*n) Space : O(n) */
    public int[] kthSmallestPrimeFraction(int[] arr, int K) {
        int[][] fractions= new int[arr.length*arr.length][2];

        int k=0;
        for(int i=0; i<arr.length-1; i++){
            for(int j=arr.length-1; j>i; j--){
                fractions[k++] =(new int[]{ arr[i], arr[j] });
            }
        }

        Arrays.sort(fractions, (a, b) -> (a[0] * b[1] - a[1] * b[0]));
        return fractions[K-1];
    }

    public int factorial(int n){
        int fact=1;
        for(int i=1; i<=n; i++) fact*=i;
        return fact;
    }
}