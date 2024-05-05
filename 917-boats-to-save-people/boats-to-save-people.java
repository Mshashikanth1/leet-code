class Solution {
    public int numRescueBoats1(int[] people, int limit) {
        int boats=0, k= 0, i=0;

        Arrays.sort(people);
        while(i<people.length){
          k=0;
        while( i<people.length && (k+people[i]<= limit)){
                k+=people[i];
                i++;
            }
            boats++;
        }
        return boats;
    }

   public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }
}