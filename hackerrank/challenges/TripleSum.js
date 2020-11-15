function triplets(a, b, c) {
    a = [...new Set(a)];
    a.sort((a, b) => a - b);
    b = [...new Set(b)];
    b.sort((a, b) => a - b);
    c = [...new Set(c)];
    c.sort((a, b) => a - b);

    let result = 0

    b.forEach(function (bValue) {
        let ai = 0;
        let ci = 0;

        while (ai < a.length && a[ai] <= bValue) {
            ai++;
        }
        while (ci < c.length && c[ci] <= bValue) {
            ci++;
        }
        result += ai * ci;
    })

    return result;
}

// console.log(triplets([3, 5, 7], [3, 6], [4, 6, 9])) // 4
// console.log(triplets([1, 4, 5], [2, 3, 3,], [1, 2, 3])) //5
console.log(triplets([1, 3, 5, 7], [5, 7, 9], [7, 9, 11, 13])) //12