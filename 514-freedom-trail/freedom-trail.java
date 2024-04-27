class Solution {
    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length();
        int keyLen = key.length();

        // HashMap to store the indices of occurrences of each character in the ring
        Map<Character, List<Integer>> characterIndices = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char ch = ring.charAt(i);
            characterIndices.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        // Initialize the min heap (priority queue) with the starting point
        // Each element of the heap is an array of integers representing:
        // totalSteps, ringIndex, keyIndex
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
                                                                                             
        heap.offer(new int[] { 0, 0, 0 });

        // HashSet to keep track of visited states
        Set<Pair<Integer, Integer>> seen = new HashSet<>();

        // Spell the keyword using the metal dial
        int totalSteps = 0;
        while (!heap.isEmpty()) {
            // Pop the element with the smallest total steps from the heap
            int[] state = heap.poll();
            totalSteps = state[0];
            int ringIndex = state[1];
            int keyIndex = state[2];

            // We have spelled the keyword
            if (keyIndex == keyLen) {
                break;
            }

            // Continue if we have visited this character from this position in ring before
            Pair<Integer, Integer> currentState = new Pair<>(ringIndex, keyIndex);
            if (seen.contains(currentState)) {
                continue;
            }

            // Otherwise, add this pair to the visited list
            seen.add(currentState);

            // Add the rest of the occurrences of this character in ring to the heap
            for (int nextIndex : characterIndices.get(key.charAt(keyIndex))) {
                heap.offer(
                        new int[] {totalSteps + countSteps(ringIndex, nextIndex, ringLen),
                                    nextIndex, keyIndex + 1});
            }
        }

        // Return the total steps and add keyLen to account for 
        // pressing the center button for each character in the keyword
        return totalSteps + keyLen;
    }

    // Find the minimum steps between two indexes of ring
    private int countSteps(int curr, int next, int ringLen) {
        int stepsBetween = Math.abs(curr - next);
        int stepsAround = ringLen - stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }
}