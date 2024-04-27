
/*
Santa Banta
MediumAccuracy: 50.01%Submissions: 13K+Points: 4

Santa is still not married. He approaches a marriage bureau and asks them to hurry the process. The bureau checks the list of eligible girls of size N and hands it over to Santa. Santa being conscious about his marriage is determined to find a girl with maximum connections so that he can gather more information about her. Accordingly, he looks to figure out the maximum number of girls (from the list) who know each other to achieve the above purpose.

In order to finalize the girl, he needs to find the Kth prime. Where k = largest group of girls who know each other. Considering Santa's poor knowledge of Maths, he seeks Banta's help for the answer. Now you, a fan of Santa Banta Jokes, take this prestigious opportunity to solve the problem.

In case no of connections is zero, print "-1". Here the connection between girls is represented by a 2-D array arr of dimension M*2, where M is the number of connections.

Note :
1. Suppose girl "a" knows girl "b" and girl "b" knows girl "c", then girl "a" also knows girl "c". Transitivity holds here.
2. Consider 1 as a composite number.
3. For precompute function given in the template you just have to complete it and use it wherever required, do not call it again and again, it is already being called by driver function before executing test cases. 

Example 1:

Input : 
arr[] = {{1,2},{2,3},{3,4},{4,5},{6,7},{9,10}}
N = 10 and M = 6
Output : 
11
Explanation:
Here in this graph there are 4 groups. 
In 1st group: (1 -> 2 -> 3 -> 4 -> 5) are 
there. In 2nd group: (6 -> 7) are there.
In 3rd group: (8) is there.
In 4th group: (10 -> 9) are there.
In these 4 group the maximum number of 
value is 5. So, K = 5 and the 5th prime number 
is 11. Return 11.

Example 2:

Input : 
arr[ ] = {{1, 2}}
N = 2 and M = 1 
Output : 
3
Explanation:
In this Example there will only be a 
single group of 2 girls, and hence the 
value of K is 2, The 2nd prime is 3.

Your Task:

This is a function problem. The input is already taken care of by the driver code. You only need to complete the function helpSanta() that takes a number of girls (n), a number of connections (m), an adjacency list of girls connections (g), and return the Kth prime no if there are no connections then return -1. The driver code takes care of the printing.

Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(N + M).

Constraints:

1 ≤ n ≤ 105
0 ≤ m ≤ 105
1 ≤ u, v ≤ n
*/
class Complete {
    
    //define global variables
    static int maxCount = 0;
    static ArrayList<Integer> primeNumbers;

    public static void precompute() {
    	//Precomputes prime numbers up to a certain limit.
        primeNumbers = new ArrayList<>();
        int limit = 1299227; //according to the constraint 100000th prime number is 1299227
        int[] sieve = new int[limit + 1];
        
        // Sieve of Eratosthenes algorithm to find prime numbers
        for (int i = 2; i <= limit && i * i <= limit; i++) {
            if (sieve[i] == 0) {
                for (int j = i * i; j <= limit; j += i) {
                    sieve[j] = 1;
                }
            }
        }
        
        // Store prime numbers in the list
        for (int i = 2; i <= limit; i++) {
            if (sieve[i] == 0) {
                primeNumbers.add(i);
            }
        }
    }

    public static void calculateGroupSize(List<List<Integer>> adjList, boolean[] visited, int source) {
        //Calculates the size of the group connected to the given source node.
        
        visited[source] = true;
        maxCount++;
        
        for (int neighbor : adjList.get(source)) {
            if (!visited[neighbor]) {
                calculateGroupSize(adjList, visited, neighbor);
            }
        }
    }

    public static int helpSanta(int n, int m, int[][] connections) {
        if (m == 0) {
            return -1;
        }
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int from = connections[i][0] - 1;
            int to = connections[i][1] - 1;
            
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        
        int largestGroupSize = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            maxCount = 0;
            
            if (!visited[i]) {
                calculateGroupSize(adjList, visited, i);
                
                if (maxCount > largestGroupSize) {
                    largestGroupSize = maxCount;
                }
            }
        }
        
        return primeNumbers.get(largestGroupSize - 1);
    }
}
