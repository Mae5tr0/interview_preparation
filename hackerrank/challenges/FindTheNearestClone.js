/*
 * For the unweighted graph, <name>:
 *
 * 1. The number of nodes is <name>Nodes.
 * 2. The number of edges is <name>Edges.
 * 3. An edge exists between <name>From[i] to <name>To[i].
 *
 */
function findShortest(graphNodes, graphFrom, graphTo, ids, val) {
    let graph = new Array(graphNodes + 1);
    for (let i = 1; i <= graphNodes; i++) {
        graph[i] = []
    }
    graphFrom.forEach(function (from, i) {
        graph[from].push(graphTo[i])
        graph[graphTo[i]].push(from)
    })

    let shortestPath = Number.MAX_SAFE_INTEGER

    graph.forEach(function (connections, currentNode) {
        if (ids[currentNode - 1] !== val) return

        let queue = []
        let visited = new Array(graphNodes + 1)
        visited[currentNode] = true

        connections.forEach(function(nodeTo) {
            queue.push([nodeTo, 1]);
        })

        while (queue.length !== 0) {
            let [node, distance] = queue.shift()
            if (distance > shortestPath) return

            if (visited[node]) continue
            visited[node] = true

            if (ids[node - 1] === val) {
                shortestPath = distance
                return
            }
            graph[node].forEach(function (nodeTo) {
                queue.push([nodeTo, distance + 1])
            })
        }
    })

    return shortestPath === Number.MAX_SAFE_INTEGER ? -1 : shortestPath
}

// console.log(findShortest(5, [1, 2, 2, 3], [2, 3, 4, 5], [1, 2, 3, 1, 3], 1)) // 2
// console.log(findShortest(5, [1, 2, 2, 3], [2, 3, 4, 5], [1, 2, 3, 1, 3], 3)) // 1
// console.log(findShortest(5, [1, 2, 2, 3], [2, 3, 4, 5], [1, 2, 3, 1, 3], 2)) // -1

console.log(findShortest(5, [1, 1, 2, 3], [2, 3, 4, 5], [1, 2, 3, 3, 2], 2)) // 3

