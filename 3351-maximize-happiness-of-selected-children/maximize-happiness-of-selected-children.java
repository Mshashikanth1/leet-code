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

