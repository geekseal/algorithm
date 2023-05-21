function solution(sizes) {
    const ordered = sizes.map((v) => (v[0] > v[1] ? [v[1], v[0]] : v));
    let lMax = 0;
    let rMax = 0;
    ordered.forEach((v) => {
        lMax = v[0] > lMax ? v[0] : lMax;
        rMax = v[1] > rMax ? v[1] : rMax;
    });
    return lMax * rMax;
}

console.log(
    solution([
        [14, 4],
        [19, 6],
        [6, 16],
        [18, 7],
        [7, 11],
    ])
);
