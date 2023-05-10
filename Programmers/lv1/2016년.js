function solution(a, b) {
  const days = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
  const firstDayIdx = 5; // if first day changes, just change the firstDayIndex, not the order of array `days` itself.

  const monthDay = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  const dayBeforeA = monthDay.slice(0, a - 1).reduce((a, b) => a + b, 0); // monthDay.slice(0, 0) = [] -> [].reduce = 0 (becuase of 0 initialization)
  const daySum = dayBeforeA + b - 1;

  const targetIdx = (firstDayIdx + (daySum % 7)) % days.length;

  return days[targetIdx];
}

console.log(solution(5, 24));
console.log(solution(1, 2));
