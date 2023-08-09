function solution(num, total) {
    const middle = num % 2 ? total / num : (total - num / 2) / num;
    const start = num % 2 ? middle - parseInt(num / 2) : middle - (num / 2 - 1);

    return new Array(num).fill(start).map((v, i) => v + i);
}

console.log(solution(5, 5));
