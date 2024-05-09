class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int  sub=0, i=happiness.length-1;
        Long sum=0L;
        while(k>0){
            sum+=happiness[i]-sub >=0  ? happiness[i]-sub : 0;
            sub++;
            k--;
            i--;
        }

        return sum;
    }
}