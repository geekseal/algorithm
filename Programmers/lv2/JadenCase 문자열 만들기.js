function solution(s) {
  // console.log(""[0], "".charAt(0));
  return s
    .split(" ")
    .map(v => v.charAt(0).toUpperCase() + v.slice(1).toLowerCase())
    .join(" ");
}

console.log(solution(" 3people unFollowed  me"));
/*
['', '3people', 'unfollowed', '', 'me'] -> ''.toUpperCase()
*/
console.log(solution("for the last week"));
