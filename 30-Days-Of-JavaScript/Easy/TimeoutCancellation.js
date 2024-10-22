/*
Given a function fn, an array of arguments args, and a timeout t in milliseconds, 
return a cancel function cancelFn.

After a delay of t, fn should be called with args passed as parameters unless cancelFn was 
invoked before the delay of t milliseconds elapses, specifically at cancelT ms. In that case, 
fn should never be called.

Example 1:
Input: fn = (x) => x * 5, args = [2], t = 20, cancelT = 50
Output: [{"time": 20, "returned": 10}]
Explanation: 
const result = []
const fn = (x) => x * 5
const start = performance.now() 
const log = (...argsArr) => {
    const diff = Math.floor(performance.now() - start);
    result.push({"time": diff, "returned": fn(...argsArr)})
}
const cancel = cancellable(log, [2], 20);
const maxT = Math.max(t, 50)      
setTimeout(cancel, cancelT)
setTimeout(() => {
     console.log(result) // [{"time":20,"returned":10}]
}, 65)
The cancellation was scheduled to occur after a delay of cancelT (50ms), 
which happened after the execution of fn(2) at 20ms.
*/
/*
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function (fn, args, t) {
    const timeoutId = setTimeout(function () {
        fn.apply(null, args);
    }, t);
    const cancelFn = function () {
        clearTimeout(timeoutId);
    };
    return cancelFn;
};

/**
 *  const result = []
 *
 *  const fn = (x) => x * 5
 *  const args = [2], t = 20, cancelT = 50
 *
 *  const start = performance.now() 
 *
 *  const log = (...argsArr) => {
 *      const diff = Math.floor(performance.now() - start);
 *      result.push({"time": diff, "returned": fn(...argsArr)})
 *  }
 *       
 *  const cancel = cancellable(log, args, t);
 *
 *  const maxT = Math.max(t, cancelT)
 *           
 *  setTimeout(() => {
 *     cancel()
 *  }, cancelT)
 *
 *  setTimeout(() => {
 *     console.log(result) // [{"time":20,"returned":10}]
 *  }, maxT + 15)
 */