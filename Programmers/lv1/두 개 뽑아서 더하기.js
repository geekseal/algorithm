function solution(numbers) {
  const answer = [];
  numbers.forEach((v, i, arr) => {
    let j = i + 1;
    while (j in arr) {
      // check if index exists in array
      answer[answer.length] = v + arr[j];
      j++;
    }
  });
  return [...new Set(answer)].sort((a, b) => a - b);
}

console.log(solution([2, 1, 3, 4, 1]));
console.log(solution([5, 0, 2, 7]));
