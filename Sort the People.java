class Solution {

    class People{
        String name;
        int height;
         People(String name, int height){
            this.name=name;
            this.height=height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        People[] population = new People[names.length];

        for( int i=0; i<names.length; i++){
            population[i]= new People(names[i], heights[i]);
        }
        quickSort(population , 0, names.length-1);

    
        for( int i=0; i<names.length; i++){
            names[i]= population[i].name;
        }
        return names;
    }

  public void quickSort(  People[]  p, int left, int right){
        if(left < right){
            int pivot= partition(p, left,right);
            quickSort( p, left, pivot-1);
            quickSort( p, pivot+1, right);
        }
  }

  public int partition(People[]  p, int left, int right ){
        int i= left-1, j=left;

        while( j< right) { 
            if( p[j].height > p[right].height) swap( p, ++i, j);
            j++;
        }

        swap( p, ++i, right);
        return i;  
  }

  public void swap( People[]  p, int i, int j ){
    People temp= p[i];
    p[i]=p[j];
    p[j]=temp;
  }

}

/**

2418. Sort the People
Solved
Easy
Topics
Companies
Hint
You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.

 

Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
 

Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct.

 */
