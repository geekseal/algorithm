function solution(n) {
  let fiboSequence = [1, 0];
  while (n >= 2) {
    [a, b] = fiboSequence;
    fiboSequence = [(a + b) % 1234567, a % 1234567]; // to take care of overflow
    n--;
  }
  return fiboSequence[0];
}

/*
// RangeError: Maximum call stack size exceeded
const F = n => {
  if (n <= 1) return [n, 0];

  [a, b] = F(n - 1);
  return [(a + b) % 1234567, a % 1234567];
};
*/

console.log(solution(3));
console.log(solution(5));
