// 성능 체크
function solution(answers) {
  const p1 = [1, 2, 3, 4, 5];
  const p2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  const patterns = [p1, p2, p3];

  const score = patterns.map(pattern => {
    return answers.reduce((acc, answer, j) => (answer === pattern[j % pattern.length] ? ++acc : acc), 0);
  });

  const max = Math.max(...score);
  const answer = [];
  score.forEach((v, i) => {
    if (v >= max) {
      answer[answer.length] = i + 1;
    }
  });
  return answer;
}

console.log(solution([1, 2, 3, 4, 5]));
console.log(solution([1, 3, 2, 4, 2]));
