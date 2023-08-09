function solution(A, B) {
  const arr = [A.sort((a, b) => a - b), B.sort((a, b) => a - b)].flat();
  let answer = 0;
  for (let i = 0; i < arr.length / 2; i++) {
    answer += arr[i] * arr[arr.length - i - 1];
  }
  return answer;
}

console.log(solution([1, 4, 2], [5, 4, 4]));
console.log(solution([1, 2], [3, 4]));
// 큰 숫자일 수록 작은 숫자와 곱셈
