/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    map = {}
    return function(...args) {
        if(args in map){
            return map[args]
        }
        map[args] = fn(...args)
        return map[args]
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */