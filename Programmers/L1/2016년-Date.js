function solution(a, b) {
  const date = new Date(`2016-${a}-${b}`);
  return date.toString().split(" ")[0].toUpperCase();
}

console.log(solution(5, 24));
console.log(solution(1, 2));
