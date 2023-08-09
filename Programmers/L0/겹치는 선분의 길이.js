/**
 * 겹치는 선분의 길이를 구한다.
 * 입력으로 주어진 선분을 구성하는 점들을 나열한 이후, 두 개의 인접한 점들이 하나의 '구간'을 구성한다.
 * 만약 구간이 두 개 이상의 선분에 포함된다면 '겹친 구간'으로 판단한다.
 *
 * @param {number[]} lines
 */
function solution(lines) {
    const sorted_dots = [...new Set(lines.flat().sort((a, b) => a - b))];

    const possible_sections = sorted_dots.map((v, i, arr) =>
        i < arr.length - 1 ? [[v, arr[i + 1]], 0] : undefined
    );
    possible_sections.pop();

    const sections_with_count = new Map(possible_sections);

    lines.forEach((line) => {
        sections_with_count.forEach((count, section, map) => {
            const contains = line[0] <= section[0] && line[1] >= section[1];
            if (contains) map.set(section, ++count);
        });
    });

    const answer = [...sections_with_count]
        .filter((v) => v[1] >= 2)
        .reduce(
            (accumulator, curr) => accumulator + (curr[0][1] - curr[0][0]),
            0
        );

    return answer;
}

console.log(
    solution([
        [0, 1],
        [2, 5],
        [3, 9],
    ])
);
