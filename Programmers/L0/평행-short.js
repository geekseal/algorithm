const m = ([a, b], [c, d]) => (d - b) / (c - a),
    f = (a, b, c, d) => m(a, b) == m(c, d),
    solution = ([a, b, c, d]) =>
        (f(a, b, c, d) || f(a, c, b, d) || f(a, d, b, c)) * 1;

console.log(
    solution([
        [3, 5],
        [4, 1],
        [2, 4],
        [5, 10],
    ])
);
