//No Link

//Time & Space Complexity: O(2^N) O(N)

const comb = (arr) => {
    if(arr.length == 0) return [[]];

    const firstEl = arr[0];
    const rest = arr.slice(1);

    const combWithout = comb(rest);
    const combWithFE = []
    combWithout.forEach((c) => {
        const cwithfe = [...c, firstEl];
        combWithFE.push(cwithfe);
    })

    return [...combWithout, ...combWithFE];
}

console.log(comb(['a','b','c']))
