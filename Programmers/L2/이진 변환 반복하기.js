function solution(s) {
  let inputCopy = s;
  let countIteration = 0;
  let countDeletedZero = 0;

  while (inputCopy !== "1") {
    const first = inputCopy.split("").filter(v => v === "1").length;
    countDeletedZero += inputCopy.length - first;

    const second = first.toString(2);
    countIteration++;
    inputCopy = second;
  }

  return [countIteration, countDeletedZero];
}

console.log(solution("110010101001"));
console.log(solution("01110"));
console.log(solution("1111111"));
