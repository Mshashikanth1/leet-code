var inorderTraversal = function* (arr) {
  const stack = [arr];
  
  while (stack.length > 0) {
    const current = stack.pop();

    if (!Array.isArray(current)) {
      yield current;
      continue;
    }

    for (let i = current.length - 1; i >= 0; i--) {
      stack.push(current[i]);
    }
  }
}

/*

2649. Nested Array Generator
Medium
94
3
Companies

Given a multi-dimensional array of integers, return a generator object which yields integers in the same order as inorder traversal.

A multi-dimensional array is a recursive data structure that contains both integers and other multi-dimensional arrays.

inorder traversal iterates over each array from left to right, yielding any integers it encounters or applying inorder traversal to any arrays it encounters.

 

Example 1:

Input: arr = [[[6]],[1,3],[]]
Output: [6,1,3]
Explanation:
const generator = inorderTraversal(arr);
generator.next().value; // 6
generator.next().value; // 1
generator.next().value; // 3
generator.next().done; // true

Example 2:

Input: arr = []
Output: []
Explanation: There are no integers so the generator doesn't yield anything.

 

Constraints:

    0 <= arr.flat().length <= 105
    0 <= arr.flat()[i] <= 105
    maxNestingDepth <= 105

 */
