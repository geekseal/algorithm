function solution(dots) {
    const slope_arr = [];

    dots.forEach((dot, index, dots) => {
        let i = index;
        while (i < dots.length - 1) {
            const vx = dot[0] - dots[i + 1][0];
            const vy = dot[1] - dots[i + 1][1];
            const slope = vy / vx;
            slope_arr[slope_arr.length] = slope;
            i++;
        }
    });

    // const slope_set = new Set(slope_arr);
    // const has_parallel = slope_arr.length !== slope_set.size;
    // wrong, '주어진 네 개의 점을 두 개씩 이었을 때'라는 조건을 놓침

    let has_parallel = false;
    if (
        slope_arr[0] === slope_arr[5] ||
        slope_arr[1] === slope_arr[4] ||
        slope_arr[2] === slope_arr[3]
    ) {
        has_parallel = true;
    }

    return +has_parallel;
}

console.log(
    solution([
        [3, 5],
        [4, 1],
        [2, 4],
        [5, 10],
    ])
);
