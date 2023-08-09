function solution(s) {
  const answer = [...s].map((letter, i, arr) => {
    // const idx = arr.slice(0, i).findLastIndex(v => v === letter);
    // const idx = s.slice(0, i).lastIndexOf(letter);
    const idx = arr
      .slice(0, i)
      .reverse()
      .findIndex(v => v === letter);
    return idx === -1 ? -1 : idx + 1;
  });
  return answer;
}

console.log(solution("banana"));
console.log(solution("foobar"));
