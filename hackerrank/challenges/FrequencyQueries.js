const INSERT_COMMAND = 1;
const DELETE_COMMAND = 2;
const CHECK_COMMAND = 3;

// Complete the freqQuery function below.
function freqQuery(queries) {
    let result = [];
    let hash = {};
    let freq = [];

    for (let i = 0; i < queries.length; i += 1) {
        let [command, value] = queries[i];
        let prev = hash[value] || 0;

        switch (command) {
            case INSERT_COMMAND:
                hash[value] = prev + 1;
                freq[prev] = (freq[prev] || 0) - 1;
                freq[prev + 1] = (freq[prev + 1] || 0) + 1;
                break;
            case DELETE_COMMAND:
                if (prev <= 0) break;

                hash[value] = prev - 1;
                freq[prev - 1] += 1;
                freq[prev] -= 1;
                break;
            case CHECK_COMMAND:
                result.push(freq[value] > 0 ? 1 : 0)
                break;
        }
    }

    return result;
}

console.log(freqQuery([[1, 5], [1, 6], [3, 2], [1, 10], [1, 10], [1, 6], [2, 5], [3, 2]])) // 0, 1
