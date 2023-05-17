/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 2636. Promise Pool
Medium
105
13
Companies

Given an array of asyncronous functions functions and a pool limit n, return an asyncronous function promisePool. It should return a promise that resolves when all the input functions resolve.

Pool limit is defined as the maximum number promises that can be pending at once. promisePool should begin execution of as many functions as possible and continue executing new functions when old promises resolve. promisePool should execute functions[i] then functions[i + 1] then functions[i + 2], etc. When the last promise resolves, promisePool should also resolve.

For example, if n = 1, promisePool will execute one function at a time in series. However, if n = 2, it first executes two functions. When either of the two functions resolve, a 3rd function should be executed (if available), and so on until there are no functions left to execute.

You can assume all functions never reject. It is acceptable for promisePool to return a promise that resolves any value.

 

Example 1:

Input: 
functions = [
  () => new Promise(res => setTimeout(res, 300)),
  () => new Promise(res => setTimeout(res, 400)),
  () => new Promise(res => setTimeout(res, 200))
]
n = 2
Output: [[300,400,500],500]
Explanation:
Three functions are passed in. They sleep for 300ms, 400ms, and 200ms respectively.
They resolve at 300ms, 400ms, and 500ms respectively. The returned promise resolves at 500ms.
At t=0, the first 2 functions are executed. The pool size limit of 2 is reached.
At t=300, the 1st function resolves, and the 3rd function is executed. Pool size is 2.
At t=400, the 2nd function resolves. There is nothing left to execute. Pool size is 1.
At t=500, the 3rd function resolves. Pool size is zero so the returned promise also resolves.

Example 2:

Input:
functions = [
  () => new Promise(res => setTimeout(res, 300)),
  () => new Promise(res => setTimeout(res, 400)),
  () => new Promise(res => setTimeout(res, 200))
]
n = 5
Output: [[300,400,200],400]
Explanation:
The three input promises resolve at 300ms, 400ms, and 200ms respectively.
The returned promise resolves at 400ms.
At t=0, all 3 functions are executed. The pool limit of 5 is never met.
At t=200, the 3rd function resolves. Pool size is 2.
At t=300, the 1st function resolved. Pool size is 1.
At t=400, the 2nd function resolves. Pool size is 0, so the returned promise also resolves.

Example 3:

Input:
functions = [
  () => new Promise(res => setTimeout(res, 300)),
  () => new Promise(res => setTimeout(res, 400)),
  () => new Promise(res => setTimeout(res, 200))
]
n = 1
Output: [[300,700,900],900]
Explanation:
The three input promises resolve at 300ms, 700ms, and 900ms respectively.
The returned promise resolves at 900ms.
At t=0, the 1st function is executed. Pool size is 1.
At t=300, the 1st function resolves and the 2nd function is executed. Pool size is 1.
At t=700, the 2nd function resolves and the 3rd function is executed. Pool size is 1.
At t=900, the 3rd function resolves. Pool size is 0 so the returned promise resolves.

 

Constraints:

    0 <= functions.length <= 10
    1 <= n <= 10

Accepted
3.2K
Submissions
3.9K
Acceptance Rate
81.1%
Overview

This question asks you to write a function that manages a pool of promises such that the amount of code running in parallel at a given time is below some threshold.

It is recommended you first read the Sleep Editorial as it covers topics on asynchronous programming not discussed here.
Use-case for Promise Pool

Imagine you have a long list of files you have to download, and you can only download them one at a time. If you requested all of them at once in parallel (using Promise.all), several bad things could happen:

    The environment may cancel requests because it detects that there are too many to handle.
    The database may become unresponsive under the heavy load.
    Too much network traffic could cause higher priority requests to get delayed.
    The app could become unresponsive trying to process all the data at once.

An alternative approach could be to process one file at a time:

for (const filename of files) {
  await download(filename);
}

However, this is slow and doesn't take advantage of parallelization.

The optimal approach is to decide on a reasonable limit on the number of concurrent requests and use a promise pool. Using the implementation asked for in this problem, it would look like this:

const files = ["data.json", "data2.json", "data3.json"];

// weird double arrow function because we want to create functions
// but we don't want to execute them until later
const functions = files.map(filename => () => download(filename));

const POOL_LIMIT = 2;
await promisePool(functions, POOL_LIMIT);

You can look at popular JavaScript packages that implement promise pools here and here.
const files = ["data.json", "data2.json", "data3.json"];

for (const filename of files) {
  await download(filename);
}
// weird double arrow function because we want to create functions
// but we don't want to execute them until later
const functions = files.map(filename => () => download(filename));

const POOL_LIMIT = 2;
await promisePool(functions, POOL_LIMIT);
Approach 1: Recursive Helper Function

We can keep track of current index in the functions array (functionIndex) and the current number of promises being executed (inProgressCount). We define a recursive function helper which will allow us to execute code asynchronously. All this code is wrapped in the returned promise's callback.

    Every time we execute a new function, we increment functionIndex and we increment inProgressCount.
    Every time a promise resolves, we decrement inProgressCount, and repeat step 1 while inProgressCount < n and there are still functions left to execute
    If at any point, functionIndex == functions.length and inProgressCount == 0, we are done and should resolve the returned promise.
var promisePool = async function(functions, n) {
    return new Promise((resolve) => {
        let inProgressCount = 0;
        let functionIndex = 0;
        function helper() {
            if (functionIndex >= functions.length) {
                if (inProgressCount === 0) resolve();
                return;
            }

            while (inProgressCount < n && functionIndex < functions.length) {
                inProgressCount++;
                const promise = functions[functionIndex]();
                functionIndex++;
                promise.then(() => {
                    inProgressCount--;
                    helper();
                });
            }
        }
        helper();
    });
};
Approach 2: Async/Await + Promise.all() + Array.shift()

We can use async/await syntax to greatly simplify the code from approach 1.

We can define a recursive function evaluateNext that:

    Immediately returns if there are no functions to execute (the base case).
    Removes the first function from the list of functions (using Array.shift).
    Executes that same first function and waits for its completion.
    Recursively calls itself and waits for its own completion. That way as soon as any function finishes, the next function in the queue is processed.

If we just call this code once, it wouldn't work (unless n = 1) because it will execute each function one-at-a-time in series. We need to initially execute evaluateNext n times in parallel to achieve the desired promise pool size. We could do this with a for loop, but that would make it hard to know when all n promises have resolved. Instead we use await Promise.all to execute n promises in parallel and wait for their completion.

On a side note, You may wonder why we can't simply write Array(n).map(evaluateNext) when initially creating the promises. This is because Array(n) creates an array of empty values which can't be mapped over. .fill() adds "real" values of undefined which can be mapped over.

On another side note, it's generally not good practice to mutate arguments within a function as the user of the function may not expect that. In a real implementation, it may be wise to clone the array initially with functions = [...functions];.
var promisePool = async function(functions, n) {
    async function evaluateNext() {
        if (functions.length === 0) return;
        const fn = functions.shift();
        await fn();
        await evaluateNext();
    }
    const nPromises = Array(n).fill().map(evaluateNext);
    await Promise.all(nPromises);
};
Approach 3: 2-Liner

We can modify the general idea from Approach 2 and make it very short with some syntax trickery.

    Instead of removing the first element of the array via Array.shift, we can instead use the variable n as the current index.
    Instead of checking if there are functions left to execute with an if statement, we can use optional chaining on the function call (functions[n++]?.()). This syntax immediately returns undefined if functions[n++] is null or undefined. Without this syntax, an error would be thrown.
    Instead of using await on a different line, we can use promise chaining (.then(evaluateNext)).
    When initially executing the first n promises in parallel, we need to write functions.slice(0, n).map(f => f().then(evaluateNext)) instead of simply functions.slice(0, n).map(evaluateNext). That way the first n promises are executed immediately outside of the helper function so we can correctly use n as the index variable.


 */
var promisePool = async function(functions, n) {
    const evaluateNext = () => functions[n++]?.().then(evaluateNext);
    return Promise.all(functions.slice(0, n).map(f => f().then(evaluateNext)));
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */
