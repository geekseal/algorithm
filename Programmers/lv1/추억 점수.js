function solution(name, yearning, photo) {
  const map = new Map(name.map((v, i) => [v, yearning[i]]));

  const answer = photo.map(piece => {
    let score = 0;
    piece.forEach(person => {
      score += map.get(person) || 0; // `undefined` if key not in map
    });
    return score;
  });

  return answer;
}

console.log(
  solution(
    ["may", "kein", "kain", "radi"],
    [5, 10, 1, 3],
    [
      ["may", "kein", "kain", "radi"],
      ["may", "kein", "brin", "deny"],
      ["kon", "kain", "may", "coni"],
    ]
  )
);

console.log(
  solution(
    ["kali", "mari", "don"],
    [11, 1, 55],
    [
      ["kali", "mari", "don"],
      ["pony", "tom", "teddy"],
      ["con", "mona", "don"],
    ]
  )
);

console.log(
  solution(["may", "kein", "kain", "radi"], [5, 10, 1, 3], [["may"], ["kein", "deny", "may"], ["kon", "coni"]])
);
