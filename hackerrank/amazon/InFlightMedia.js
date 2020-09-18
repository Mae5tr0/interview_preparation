'use strict';

function foo(flightDuration, moviesDuration) {
    let result = [-1, -1];
    if (moviesDuration.length < 1) return result;
    let longestMovie = -1;
    let durations = {};

    for (let i = 0; i < moviesDuration.length - 1; i++) {
        let movieDuration = moviesDuration[i];
        let pairDuration = flightDuration - movieDuration - 30;
        if (durations[pairDuration] !== undefined) {
            if (Math.max(movieDuration, pairDuration) > longestMovie) {
                result = [durations[pairDuration], i];
                longestMovie = Math.max(movieDuration, pairDuration);
            }
        }
        durations[movieDuration] = i;
    }

    return result;
}

// console.log(foo(90, [1, 10, 25, 35, 60])) // [2, 3]
// console.log(foo(110, [6, 20, 70, 90, 30, 60, 110, 74])) // [2, 3]
console.log(foo(630, [590, 567, 500, 680, 300, 400, 700, 666, 300])) // [5, 6]