function Node(data, left, right) {
    this.data = data;
    this.left = left ? left : null;
    this.right = right ? right : null;
}

let root = new Node(4,
    new Node(7,
        new Node(10),
        new Node(2,
            null,
            new Node(6, new Node(2)
            )
        )
    ),
    new Node(9, null, new Node(6))
);

function averageLevelValue(root) {
    if (!root) return []

    let data = {}
    processNodes(root, 0, data)

    let result = []
    Object.keys(data).sort().forEach(function (level) {
        let [count, sum] = data[level]
        result.push(sum / count)
    })

    return result;
}

function processNodes(node, level, data) {
    if (node === null) return;

    if (!data[level]) {
        data[level] = [1, node.data]
    } else {
        let [count, sum] = data[level]
        data[level] = [count + 1, sum + node.data]
    }
    processNodes(node.left, level + 1, data)
    processNodes(node.right, level + 1, data)
}


console.log(averageLevelValue(root)) // [4, 8, 6, 6, 2]
