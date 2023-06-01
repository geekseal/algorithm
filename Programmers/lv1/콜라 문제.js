function solution(a, b, n) {
  const redundant = n % a;
  const received = parseInt(n / a) * b;
  const myStock = received + redundant;
  const answer = received;

  return recursiveStep(a, b, myStock, answer);
}

function recursiveStep(a, b, myStock, answer) {
  if (myStock < a) return answer;

  const redundant = myStock % a;
  const received = parseInt(myStock / a) * b;
  myStock = received + redundant;
  answer += received;

  return recursiveStep(a, b, myStock, answer);
}

console.log(solution(2, 1, 20));
console.log(solution(3, 1, 20));
