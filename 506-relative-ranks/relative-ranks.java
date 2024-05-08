class Solution {
    public String[] findRelativeRanks(int[] score) {
       int n=score.length;
       int[] scoreDub=new int[n];

       Queue<Integer> queue= new PriorityQueue<>((a,b)-> b-a);
       Map<Integer,String> hMap=new HashMap<>();

       for(int i: score) queue.offer(i);

       String[] ans=new String[n];

        int i=1;
       while(!queue.isEmpty()){
            if(i==1){hMap.put(queue.poll(),"Gold Medal"); }
            else if(i==2){hMap.put(queue.poll(), "Silver Medal");}
            else if(i==3){hMap.put(queue.poll(), "Bronze Medal");}
            else { hMap.put(queue.poll(), ""+ i);}
            i++;
       }

       for( i=0; i<n; i++){
            ans[i]=hMap.get(score[i]);
       }

       return ans;
    }
}