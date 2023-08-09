/*
 ** 알고리즘 시간 복잡도 O(log n) 이지만 사실상 O(a)에 가까움.
 ** 655395 입력후 1억번 실행에 소요 시간450ms 미만
 */
function solution(n) {
  var i, j;
  for (i = 0; !(n & 1); i++) {
    n = n >> 1;
  } // 1을 찾을때까지 우로 쉬프트, i = 우로 쉬프트 횟수
  for (j = 0; n & 1; i++, j++) {
    n = n >> 1;
  } // 0을 찾을때까지 우로 쉬프트, j = 마주치는 1의 갯수
  for (--j, ++n; i !== j; i--) {
    n = n << 1;
  } // 0자리에 1대입, 1의 갯수 -1, i === j 가 될 때까지 좌로 쉬프트하면서 쉬프트 횟수 -1
  for (i; i; i--, n++) {
    n = n << 1;
  } // i === 0 될때까지 좌로 쉬프트 하면서 쉬프트 횟수 -1, 0자리에 1대입
  return n;
}

console.log(solution(78));
console.log(solution(74));
console.log(solution(14));
