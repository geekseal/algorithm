function solution(s) {
  if (s.length % 2) return 0;
  // 연속되는 2개를 제거하기 때문에 aaa는 return 0이 맞음

  const stack = [];

  for (let i = 0; i < s.length; i++) {
    // `for...of` fails in efficency case 2
    if (stack[stack.length - 1] === s[i]) {
      stack.pop();
    } else {
      stack[stack.length] = s[i];
    }
  }

  return +!stack.length;
}

console.log(solution("baabaa"));
console.log(solution("cdcd"));
