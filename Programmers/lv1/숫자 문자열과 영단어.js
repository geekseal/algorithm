function solution(s) {
  const numberInEng = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];

  return parseInt(
    numberInEng.reduce(
      (prev, curr, i) => prev.replaceAll(curr, i.toString()),
      s
    )
  );
}
console.log(solution("one4seveneight"));
console.log(solution("23four5six7"));
console.log(solution("2three45sixseven"));
console.log(solution("123"));
