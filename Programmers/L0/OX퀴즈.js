function solution(quiz) {
  const answer = quiz.map(equation => {
    const [calc, result] = equation.split(" = ");
    const sign = calc.includes("+") ? 1 : -1;
    const [x, y] = calc.split(sign === 1 ? " + " : " - ");

    return +x + sign * +y === +result ? "O" : "X";
  });

  return answer;
}

console.log(
  solution(["19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "2 - -1 = 3"])
);
