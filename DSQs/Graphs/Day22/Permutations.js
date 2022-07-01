//No Link

//Time & Space Complexity: O(N!) O(N^2)

const permutations = (arr) => {
    if(arr.length == 0) return [[]];

    const firstEl = arr[0];
    const rest = arr.slice(1);

    const permutationsWithout = permutations(rest);
    const permutationsWith = [];
    permutationsWithout.forEach((p) => {
        for(let i=0; i<=p.length; i++){
            const perm = [...p.slice(0, i), firstEl, ...p.slice(i)];
            permutationsWith.push(perm);
        }
    })

    return [...permutationsWith];
}

console.log(permutations(['a','b','c']))
