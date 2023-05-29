function solution(s) {
  let countIteration = 0;
  let countDeletedZero = 0;

  while (s !== "1") {
    countDeletedZero += (s.match(/0/g) || []).length;

    s = s.replace(/0/g, "").length.toString(2);

    countIteration++;
  }

  return [countIteration, countDeletedZero];
}

console.log(solution("110010101001"));
console.log(solution("01110"));
console.log(solution("1111111"));
