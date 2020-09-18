// Complete the roadsAndLibraries function below.
function roadsAndLibraries(n, c_lib, c_road, cities) {
    let graph = new Array(n + 1)
    for (let i = 1; i <= n; i++) {
        graph[i] = []
    }
    let visited = new Array(n + 1)
    let queue = []

    cities.forEach(function ([from, to]) {
        graph[from].push(to)
        graph[to].push(from)
    })

    let result = 0;
    graph.forEach(function (connections, city) {
        if (visited[city]) return;

        result += c_lib;
        visited[city] = true

        connections.forEach(function (to) {
            queue.push(to)
        })

        while (queue.length !== 0) {
            let node = queue.shift()

            if (visited[node]) continue;

            visited[node] = true;
            result += (c_lib > c_road) ? c_road : c_lib

            graph[node].forEach(function (nodeTo) {
                queue.push(nodeTo)
            })
        }
    })

    return result;
}

let cities = [
    [1, 2],
    [2, 3],
    [3, 1]
]
console.log(roadsAndLibraries(3, 2, 1, cities)) // 4


cities = [
    [1, 2],
    [2, 3],
    [2, 4],
    [1, 3],
    [5, 6]
]
console.log(roadsAndLibraries(6, 2, 5, cities)) // 12