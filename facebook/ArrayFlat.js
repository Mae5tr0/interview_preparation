function flat() {
    let result = []

    function helper(arr) {
        arr.forEach(function (item) {
            if (Array.isArray(item)) {
                helper(item)
            } else {
                result.push(item)
            }
        })
    }

    helper(this)

    return result;
}

Array.prototype.flat = flat

// [1, [2, [3], 4], 5] => [1, 2, 3, 4, 5]

console.log([1, [2, [3], 4], 5].flat())

