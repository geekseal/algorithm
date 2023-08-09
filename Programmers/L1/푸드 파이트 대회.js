function solution(food) {
  let lefty = "";
  for (let i = 1; i < food.length; i++) {
    lefty += i.toString().repeat(Math.floor(food[i] / 2));
  }

  const righty = [...lefty].reverse().join("");

  return lefty + "0" + righty;
}

/*
const lefty = food.reduce((acc, curr, i) => {
  if (i == 0) return "";

  acc += i.toString().repeat(parseInt(curr / 2));
  return acc;
}, "");
*/

console.log(solution([1, 3, 4, 6]));
console.log(solution([1, 7, 1, 2]));
