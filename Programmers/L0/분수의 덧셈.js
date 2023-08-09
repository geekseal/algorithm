function solution(numer1, denom1, numer2, denom2) {
  const denom = denom1 * denom2;
  const numer = numer1 * denom2 + numer2 * denom1;
  const gcd = GCD(denom, numer);
  return [numer / gcd, denom / gcd];
}

// 최대공약수
const GCD = (a, b) => {
  if (a < b) [a, b] = [b, a];

  return b ? GCD(b, a % b) : a;
};

console.log(solution(9, 2, 1, 3));

// 최소공배수
const LCM = (a, b) => (a * b) / GCD(a, b);
