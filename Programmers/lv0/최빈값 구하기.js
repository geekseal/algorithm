function solution(array) {
    if (array.length === 1) return array[0];

    const map = new Map([...new Set(array)].map((v) => [v, 0]));
    array.forEach((v) => {
        map.set(v, map.get(v) + 1);
    });

    const descending = [...map.entries()].sort((a, b) => b[1] - a[1]);
    return descending[0][1] === descending[1][1] ? -1 : descending[0][0];
}

console.log(solution([1, 2, 3, 3, 3, 4]));
console.log(solution([1, 1, 2, 2]));
