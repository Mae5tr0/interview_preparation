// Complete the minimumAbsoluteDifference function below.
function minimumAbsoluteDifference(arr) {
    arr.sort();
    let result = Math.abs(arr[0] - arr[1]);
    for (let i = 1; i < arr.length; i++) {
        result = Math.min(result, Math.abs(arr[i] - arr[i - 1]));
    }

    return result;
}

console.log(minimumAbsoluteDifference([3, -7, 0])); // 3
console.log(minimumAbsoluteDifference([-59, -36, -13, 1, -53, -92, -2, -96, -54, 75])); // 1
console.log(minimumAbsoluteDifference([1, -3, 71, 68, 17])); // 3