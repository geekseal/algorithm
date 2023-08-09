const can_pronounce = new Map([
    ["y", "ye"],
    ["m", "ma"],
    ["a", "aya"],
    ["w", "woo"],
]);

function solution(babbling) {
    let answer = babbling.filter((input) => matchPatternRecursive(input));
    return answer.length;
}

function matchPatternRecursive(input) {
    const pattern = can_pronounce.get(input[0]);
    if (!pattern || pattern !== input.slice(0, pattern.length)) {
        return false;
    }

    const new_input = input.substring(pattern.length);
    if (!new_input) {
        // assuming that babbling[i] >= 1, as described in condition.
        return true;
    }

    return matchPatternRecursive(new_input);
}

console.log(solution(["aya", "yee", "u", "maa", "wyeoo"]));
