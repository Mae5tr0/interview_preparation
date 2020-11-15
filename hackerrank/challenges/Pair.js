function pairs(k, arr) {
    let result = 0
    let values = {}

    arr.forEach(function (value) {
        if (values[value - k]) {
            result++;
        }
        if (values[value + k]) {
            result++;
        }
        values[value] = true
    })

    return result;
}

console.log(pairs(1, [1, 2, 3, 4])) // 3
console.log(pairs(2, [1, 5, 3, 4, 2])) // 3
