function solution(t, p) {
  const n = p.length;
  const nGrams = [];

  for (let i = 0; i < t.length - n + 1; i++) {
    nGrams[nGrams.length] = t.slice(i, i + n);
  }

  const answer = nGrams.filter(v => +v <= +p);
  return answer.length;
}

console.log(solution("3141592", "271"));
console.log(solution("500220839878", "7"));
console.log(solution("10203", "15"));
