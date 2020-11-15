/**
 * @param {string} text
 * @return {string}
 */
var reorderSpaces = function(text) {
    let words = text.split(' ').filter((item) => item !== '')
    let spaceCount = text.split('').filter((item) => item === ' ').length

    if (words.length - 1 === 0) {
        return words[0] + ' '.repeat(spaceCount)
    }
    let wordDivider = ' '.repeat(spaceCount / (words.length - 1))

    return words.join(wordDivider) + ' '.repeat(spaceCount % (words.length - 1))
};

// console.log(reorderSpaces("  this   is  a sentence ")) // "this   is   a   sentence"
// console.log(reorderSpaces(" practice   makes   perfect")) // "practice   makes   perfect "
// console.log(reorderSpaces("hello   world")) // "hello   world"
// console.log(reorderSpaces("  walks  udp package   into  bar a")) // "  walks  udp package   into  bar a"
// console.log(reorderSpaces("a")) // "a"
// console.log(reorderSpaces("  hello")) // "hello  "

/**
 * @param {string} s
 * @return {number}
 */
var maxUniqueSplit = function(s) {
    let map = {}

    function helper(substring) {
        let max = 0;
        for (let i = 1; i <= substring.length; i++) {
            let candidate = substring.substring(0, i)
            if (!map[candidate]) {
                map[candidate] = true
                max = Math.max(max, 1 + helper(substring.substring(i)))
                map[candidate] = false
            }
        }
        return max;
    }

    return helper(s)
};

// console.log(maxUniqueSplit("ababccc"))  // 5
// console.log(maxUniqueSplit("aba"))  // 2
// console.log(maxUniqueSplit("aa"))  // 1
// console.log(maxUniqueSplit("ababab"))  // 3
// console.log(maxUniqueSplit("addbsd"))  // 5


/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxProductPath = function(grid) {

};

console.log(maxProductPath(
    [[-1,-2,-3],
    [-2,-3,-3],
    [-3,-3,-2]]
)) // -1
console.log(maxProductPath(
    [[1,-2,1],
        [1,-2,1],
        [3,-4,1]]
)) // 8
console.log(maxProductPath(
    [[1, 3],
        [0,-4]]
)) // 0
console.log(maxProductPath([
        [ 1, 4, 4, 0],
        [-2, 0, 0, 1],
        [ 1, -1, 1, 1]
])) // 2
console.log(maxProductPath([
    [-1, -4,  2],
    [ 4,  3, -1],
    [ 2, -4,  4],
    [ 1, -1, -4]
])) // 768