function solution(s) {
  return `${Math.min(...s.split(" "))} ${Math.max(...s.split(" "))}`;
}

console.log(solution("1 2 3 4"));
console.log(solution("-1 -2 -3 -4"));
console.log(solution("-1 -1"));
