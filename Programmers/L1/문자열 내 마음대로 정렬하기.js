// localeCompare, charAt, charCodeAt

// 먼저 sort하고 한번 더 비교
function solution(strings, n) {
  return strings.sort().sort((a, b) => a.charCodeAt(n) - b.charCodeAt(n));
}

function solution(strings, n) {
  return strings.sort((a, b) => {
    if (a[n] > b[n]) return 1;
    else if (a[n] < b[n]) return -1;
    else {
      if (a > b) return 1;
      else if (a < b) return -1;
      else return 0;
    }
  });
}

console.log(solution(["abce", "abcd", "cdx"], 2));
console.log(solution(["sun", "bed", "car", "cc"], 1));
