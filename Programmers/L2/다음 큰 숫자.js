function solution(n) {
  // since string is immutable, and there are no string methods to change its value by index, I used array.
  const binary = n.toString(2).split("");

  for (let i = binary.length - 1; i >= 0; i--) {
    // in case initial binary was e.g. 1111, 110, 1000
    if (i === 0) {
      binary.splice(1, 0, "0");
      binary.splice(2, Infinity, ...binary.slice(2).reverse());
      break;
    }

    if (binary[i] === "1" && binary[i - 1] === "0") {
      binary.splice(i - 1, 2, "1", "0"); // same as swapping position
      binary.splice(i + 1, Infinity, ...binary.slice(i + 1).reverse());
      break;
    } else {
      continue;
    }
  }

  return parseInt(binary.join(""), 2);
}

console.log(solution(78));
console.log(solution(74));
console.log(solution(14)); // forgot this case
