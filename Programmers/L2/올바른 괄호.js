function solution(s) {
  let stackCount = 0;

  for (let i = 0; i < s.length; i++) {
    stackCount += s[i] === "(" ? 1 : -1;
    if (stackCount < 0) return false;
  }

  return !!stackCount ? false : true;
}

console.log(solution("()()"));
console.log(solution("(())()"));
console.log(solution(")()("));
console.log(solution("(()("));
