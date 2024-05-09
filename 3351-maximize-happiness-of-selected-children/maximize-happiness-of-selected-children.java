class Solution {

    /**Time : O(n*log(n)) Space : O(1) */
    public long maximumHappinessSum(int[] happiness, int k) {
        //Arrays.sort(happiness);

        // quickSort(happiness, 0, happiness.length-1);
        mergeSort(happiness, 0, happiness.length-1);
        System.out.println(Arrays.toString(happiness));
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

    /**Time :O(n*log(n)) Space:O(1) */
    public void quickSort(int[] arr, int left, int right){
        if(left<right){
            int pivotIndex= partition(arr, left, right);
            quickSort(arr, left, pivotIndex-1);
            quickSort(arr, pivotIndex+1 , right);
        }
    }
    public int partition(int[] arr, int left, int right){
        int i=left-1, j=left ;
        while(j<right){
            if(arr[j] < arr[right]) swap(arr, ++i , j); 
            j++;
        }
        swap(arr, ++i, right);
        return i;
    }
    public void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    /**Time : O(n*log(n)) Space : O(n*log(n)) */
    public void mergeSort(int[] arr, int left, int right){
        if(left<right){
            int mid= left+ (right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    public void merge(int[] arr, int left, int mid, int right){
            int n=mid-left+1 , m=right-mid , i=0, j=0, k=left;

            int[] nArr=new int[n], mArr= new int[m];

            while(i<n) nArr[i]= arr[left+ i++];
            while(j<m) mArr[j]= arr[mid+1 + j++];

            i=0; j=0;
            while(i<n && j<m)  arr[k++]= nArr[i] < mArr[j] ? nArr[i++] : mArr[j++];

            while(i<n) arr[k++]=nArr[i++];
            while(j<m) arr[k++]= mArr[j++];
    }
}

/**

3075. Maximize Happiness of Selected Children
Solved
Medium
Topics
Companies
Hint
You are given an array happiness of length n, and a positive integer k.

There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.

In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.

Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.

 

Example 1:

Input: happiness = [1,2,3], k = 2
Output: 4
Explanation: We can pick 2 children in the following way:
- Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].
- Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.
The sum of the happiness values of the selected children is 3 + 1 = 4.
Example 2:

Input: happiness = [1,1,1,1], k = 2
Output: 1
Explanation: We can pick 2 children in the following way:
- Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].
- Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].
The sum of the happiness values of the selected children is 1 + 0 = 1.
Example 3:

Input: happiness = [2,3,4,5], k = 1
Output: 5
Explanation: We can pick 1 child in the following way:
- Pick the child with the happiness value == 5. The happiness value of the remaining children becomes [1,2,3].
The sum of the happiness values of the selected children is 5.
 

Constraints:

1 <= n == happiness.length <= 2 * 105
1 <= happiness[i] <= 108
1 <= k <= n
 */
