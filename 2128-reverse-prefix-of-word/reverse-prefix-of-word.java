class Solution {
    public String reversePrefix(String word, char ch) {
        char[] chrArr= word.toCharArray();
        int indx=0;
        for(int i=0;i<chrArr.length;i++){
            if(chrArr[i]==ch){
                indx=i;
                break;
            }
        }

        reverse(chrArr,0,indx);
        return String.valueOf(chrArr);
    }

    public void reverse(char[] chrArr, int start, int end){
        while(start<end){
            char ch=chrArr[end];
            chrArr[end--]=chrArr[start];
            chrArr[start++]=ch;
        }
    }
}