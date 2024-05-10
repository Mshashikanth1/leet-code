class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> fractions= new  ArrayList<>();

        for(int i=0; i<arr.length-1; i++){
            for(int j=arr.length-1; j>i; j--){
                fractions.add(new int[]{ arr[i], arr[j] });
            }
        }
        
        Collections.sort(fractions, (a, b) -> (a[0] * b[1] - a[1] * b[0]));
        return fractions.get(k-1);
    }
}