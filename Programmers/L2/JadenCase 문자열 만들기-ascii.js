function solution(s) {
  let answer = s[0].charCodeAt() >= 97 && s[0].charCodeAt() <= 122 ? String.fromCharCode(s[0].charCodeAt() - 32) : s[0];

  let isFormerBlank = false;

  for (let i = 1; i < s.length; i++) {
    const charCode = s[i].charCodeAt();

    if (isFormerBlank) {
      if (charCode >= 97 && charCode <= 122) {
        answer += String.fromCharCode(charCode - 32);
      } else {
        answer += s[i];
      }
      isFormerBlank = false;
    } else if (!isFormerBlank) {
      if (charCode >= 65 && charCode <= 90) {
        answer += String.fromCharCode(charCode + 32);
      } else {
        answer += s[i];
      }
    }

    if (charCode === 32) {
      isFormerBlank = true;
    }
  }
  return answer;
}

console.log(solution("3people unFollowed me"));
console.log(solution("for the last week"));
