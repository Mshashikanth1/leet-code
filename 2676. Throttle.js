/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 5
(4 votes)

2676. Throttle
Medium
23
3
Companies

Given a function fn and a time in milliseconds t, return a throttled version of that function.

A throttled function is first called without delay and then, for a time interval of t milliseconds, can't be executed but should store the latest function arguments provided to call fn with them after the end of the delay.

For instance, t = 50ms, and the function was called at 30ms, 40ms, and 60ms. The first function call would block calling functions for the following t milliseconds. The second function call would save arguments, and the third call arguments should overwrite currently stored arguments from the second call because the second and third calls are called before 80ms. Once the delay has passed, the throttled function should be called with the latest arguments provided during the delay period, and it should also create another delay period of 80ms + t.

Throttle DiagramThe above diagram shows how throttle will transform events. Each rectangle represents 100ms and the throttle time is 400ms. Each color represents a different set of inputs.

 

Example 1:

Input: t = 100, calls = [{"t":20,"inputs":[1]}]
Output: [{"t":20,"inputs":[1]}]
Explanation: The 1st call is always called without delay

Example 2:

Input: t = 50, calls = [{"t":50,"inputs":[1]},{"t":75,"inputs":[2]}]
Output: [{"t":50,"inputs":[1]},{"t":100,"inputs":[2]}]
Explanation: 
The 1st is called a function with arguments (1) without delay.
The 2nd is called at 75ms, within the delay period because 50ms + 50ms = 100ms, so the next call can be reached at 100ms. Therefore, we save arguments from the 2nd call to use them at the callback of the 1st call.

Example 3:

Input: t = 70, calls = [{"t":50,"inputs":[1]},{"t":75,"inputs":[2]},{"t":90,"inputs":[8]},{"t": 140, "inputs":[5,7]},{"t": 300, "inputs": [9,4]}]
Output: [{"t":50,"inputs":[1]},{"t":120,"inputs":[8]},{"t":190,"inputs":[5,7]},{"t":300,"inputs":[9,4]}]
Explanation: 
The 1st is called a function with arguments (1) without delay.
The 2nd is called at 75ms within the delay period because 50ms + 70ms = 120ms, so it should only save arguments. 
The 3rd is also called within the delay period, and because we need just the latest function arguments, we overwrite previous ones. After the delay period, we do a callback at 120ms with saved arguments. That callback makes another delay period of 120ms + 70ms = 190ms so that the next function can be called at 190ms.
The 4th is called at 140ms in the delay period, so it should be called as a callback at 190ms. That will create another delay period of 190ms + 70ms = 260ms.
The 5th is called at 300ms, but it is after 260ms, so it should be called immediately and should create another delay period of 300ms + 70ms = 370ms.

 

Constraints:

    0 <= t <= 1000
    1 <= calls.length <= 10
    0 <= calls[i].t <= 1000
    0 <= calls[i].inputs[i], calls[i].inputs.length <= 10


Solution
Overview

This question asks you to implement the throttle higher-order function. The one-sentence description of throttle is that it should call the provided callback as frequently as possible but no more frequently than t milliseconds. This means that it should call the provided callback with the same arguments as soon as the throttled function is called. Then,
after t milliseconds, we should check if the throttled function was called again. If it was, we should call the provided function with the last known arguments. If it wasn't, we wait until it is called again.

To give a concrete example of throttle in action:

const start = Date.now();
function log(id) {
  console.log(id, Date.now() - start);
}

setTimeout(() => log(1), 10); // logs: 1, 10
setTimeout(() => log(2), 15); // logs: 2, 15
setTimeout(() => log(3), 20); // logs: 3, 20
setTimeout(() => log(4), 60); // logs: 4, 60
setTimeout(() => log(5), 70); // logs: 5, 70

As expected, the log function is called with the delay specified by setTimeout.

However, if we throttle the log function:

const start = Date.now();
function log(id) {
  console.log(id, Date.now() - start);
}
const throttledLog = debounce(log, 20);

setTimeout(() => throttledLog(1), 10); // logs: 1, 10
setTimeout(() => throttledLog(2), 15); // cancelled
setTimeout(() => throttledLog(3), 20); // logs: 3, 30
setTimeout(() => throttledLog(4), 60); // logs: 4, 60
setTimeout(() => throttledLog(5), 70); // logs: 5, 80

In the above example, log is immediately called at t=10ms because that was the first time throttledLog was called. The call at t=15ms is cancelled by the call at t=20ms. The call at t=20ms is delayed until t=10+20=30ms. Similar to the first call, the call at t=60ms is immediately evaluated because there were no recent calls before that. And the call at t=70ms was also delayed by 10ms.

It is recommended you also read the Debounce Editorial. Together, throttle and debounce make a powerful pair and are both used frequently in front-end development.
Use-cases for Throttle

Throttle is used when you want to perform an action as soon as possible, but also want to guarantee a limit on how frequently that action could be performed.

A use-case could be as simple as downloading data when a user clicks a button. You don't want there to be any delay when the user first clicks the button (why debounce wouldn't be suitable). But you also don't want to try to download dozens of copies if you user decided to start spam clicking the button. Adding a throttle of a few seconds to the download function elegantly achieve the desired result.

A simple way to think about when to use debounce and when to use throttle:

    Debounce protects the user from unwanted events that could create lag (like trying to re-render a large grid of search results every time a character is typed). This is achieved by only executing code AFTER the user is done with their interaction.
    Throttle prevents code from being called more frequently than the infrastructure/app can handle (like the user trying to spam click download). This is achieved by guaranteeing a limit on how frequently some code can be called. It generally doesn't hurt to apply throttling to most network requests, provided t is reasonably small.

Approach 1: Recursive setTimeout Calls

A good way to think of this problem is that there are two states the code can been in: looping and waiting. If the code is in the waiting state, that means there haven't been any recent function calls, and the provided callback should be immediately called as soon as the throttled function is called. Once that happens, the code enters the looping state. Now the code should keep executing the provided callback every t milliseconds with the last known arguments. Once the the throttled function wasn't called for an entire loop, it goes back to the waiting state.

In the below code, the existence of timeoutInProgress represents if the code in the looping state or not. If the code is in the looping state, argsToProcess is just set to the most recent args. If the code is in the waiting state, fn is immediately called and a recursive loop is created.

Inside this recursive loop, it first check if there were any function calls since the last time the loop was executed. If the answer is there were none, the code goes back to the waiting state. Otherwise, fn is executed with the last known arguments, argsToProcess is set to null, and timeoutFunction is recursively called with a delay.
Approach 2: setInterval + clearInterval

The logic in Approach 1 lends itself nicely to using setInterval instead of setTimeout. To achieve the looping phase, we can essentially replace the recursive calls with a single interval.

The following changes need to be made to use setInterval.

    The looping phase is started with setInterval instead of setTimeout.
    There is no need for a recursive function call inside the interval. setInterval takes care of that.
    It's not enough to revert to the waiting phase by setting intervalInProgress to null. We also have to stop the loop by calling clearInterval(intervalInProgress). Otherwise it will go on forever.

Comments (3)

 */
var throttle = function(fn, t) {
  let intervalInProgress = null;
  let argsToProcess = null;
  
  const intervalFunction = () => {
    if (argsToProcess === null) {
      clearInterval(intervalInProgress);
      intervalInProgress = null; // enter the waiting phase
    } else {
      fn(...argsToProcess);
      argsToProcess = null;
    }
  };

  return function throttled(...args) {
    if (intervalInProgress) {
      argsToProcess = args;
    } else {
      fn(...args); // enter the looping phase
      intervalInProgress = setInterval(intervalFunction, t);
    }
  }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */
