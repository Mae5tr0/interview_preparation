function whatFlavors(costs, money) {
    let prices = {}

    for (let i = 0; i < costs.length; i++) {
        let price = costs[i]
        let pairPrice = money - price
        if (prices[pairPrice] !== undefined) {
            console.log(Math.min(i + 1, prices[pairPrice]), Math.max(i + 1, prices[pairPrice]))
            return
        } else {
            prices[price] = i + 1
        }
    }
}

whatFlavors([2, 1, 3, 5, 6], 5) // 1, 3
whatFlavors([1, 4, 5, 3, 2], 4) // 1, 4
whatFlavors([2, 2, 4, 3], 4) // 1, 2
