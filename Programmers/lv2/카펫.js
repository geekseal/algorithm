function solution(brown, yellow) {
  const arr = getDivisorArray(yellow);

  for (let i = 0; i < arr.length; i++) {
    const [yellowRow, yellowColumn] = arr[i];
    const brownRow = yellowRow + 2;
    const brownColumn = yellowColumn + 2;

    if (brownRow * brownColumn === brown + yellow) {
      return [brownRow, brownColumn];
    }
  }
}

function getDivisorArray(n) {
  const divisorArray = [];

  for (let i = 1; i * i <= n; i++) {
    if (n % i === 0) {
      divisorArray[divisorArray.length] = [n / i, i]; // row >= column
    }
  }

  return divisorArray;
}

console.log(solution(10, 2));
console.log(solution(8, 1));
console.log(solution(24, 24));
