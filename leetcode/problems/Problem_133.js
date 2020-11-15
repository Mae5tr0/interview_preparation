/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
    let clone = new Node(node.val)

    let queue = []
    node.neighbors.forEach(function (neighbor) {
        queue.push({
            source: clone,
            target: neighbor
        })
    })
    let visited = {
        [node.val]: true
    }

    while (queue.length !== 0) {
        let clonedNode = queue.pop()
        let newNode = new Node(clonedNode.target.value)
        clonedNode.source.neighbors.push(newNode)
        clonedNode.target.neighbors.forEach(function (item) {
            if (visited[item.val]) return;
            queue.push({
                source: newNode,
                target: item
            })
        })
        visited[clonedNode.val] = true
    }

    return clone;
};

