class Solution {
    /*
    public long wonderfulSubstrings(String word) {
        int[] frqArr=new int[26];

        long c=-1;

        Set<String> hset=new HashSet<>();
        for(int i=0;i<word.length();i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<word.length();j++){
                sb.append(word.charAt(j));

                if(hset.add(sb.toString())){
                  System.out.println(sb.toString());
                  frqArr[word.charAt(j)-97]++;
                  c+=check(frqArr);
                }
            }
            Arrays.fill(frqArr,0);
        }
        return c;
    }

    public int check(int[] arr){
        for(int i:arr) 
            if(i%2==1) return 1;
        return 0;
    }
    */

    public long wonderfulSubstrings(String word) {
          int N = word.length();

        // Create the frequency map
        // Key = bitmask, Value = frequency of bitmask key
        Map<Integer, Integer> freq = new HashMap<>();

        // The empty prefix can be the smaller prefix, which is handled like this
        freq.put(0, 1);

        int mask = 0;
        long res = 0L;
        for (int i = 0; i < N; i++) {
            char c = word.charAt(i);
            int bit = c - 'a';

            // Flip the parity of the c-th bit in the running prefix mask
            mask ^= (1 << bit);
            
            // Count smaller prefixes that create substrings with no odd occurring letters
            res += freq.getOrDefault(mask, 0);

            // Increment value associated with mask by 1
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);

            // Loop through every possible letter that can appear an odd number of times in a substring
            for (int odd_c=0; odd_c < 10; odd_c++) {
                res += freq.getOrDefault(mask ^ (1 << odd_c),0);
            }
        }
        return res;
    }

}