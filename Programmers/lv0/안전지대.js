function solution(board) {
    const DANGEROUS = 1;
    board_copy = [...board];
    indices = [];

    board_copy.forEach((row, y, arr) => {
        row.forEach((data, x) => {
            if (data === 1) indices[indices.length] = [y, x];
        });
    });

    indices.forEach(([y, x]) => {
        // left
        if (x - 1 in board_copy[y]) board_copy[y][x - 1] = DANGEROUS;

        // right
        if (x + 1 in board_copy[y]) board_copy[y][x + 1] = DANGEROUS;

        // up
        if (y - 1 in board_copy) {
            board_copy[y - 1][x] = DANGEROUS;

            if (x - 1 in board_copy[y - 1])
                board_copy[y - 1][x - 1] = DANGEROUS;
            if (x + 1 in board_copy[y - 1])
                board_copy[y - 1][x + 1] = DANGEROUS;
        }

        // down
        if (y + 1 in board_copy) {
            board_copy[y + 1][x] = DANGEROUS;

            if (x - 1 in board_copy[y + 1])
                board_copy[y + 1][x - 1] = DANGEROUS;
            if (x + 1 in board_copy[y + 1])
                board_copy[y + 1][x + 1] = DANGEROUS;
        }
    });

    let answer = 0;
    for (const row of board_copy) {
        for (const column of row) {
            if (!column) answer++;
        }
    }

    return answer;
}

/*
cf) let the function take care of exceptions, not the main code.

function turn_dangerous(elem) {
    if (elem) elem = DANGEROUS;
}
*/

console.log(
    solution([
        [0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [1, 0, 1, 1, 0],
        [0, 0, 0, 0, 1],
    ])
);
