//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} ring
 * @param {string} key
 * @return {number}
 */
var findRotateSteps = function (ring, key) {
    const n = ring.length;
    const m = key.length;
    const memo = Array.from({length: m}, () => Array(n).fill(null));
    const ringPositions = new Map();

    for (let i = 0; i < n; i++) {
        const char = ring[i];

        if (!ringPositions.has(char)) {
            ringPositions.set(char, []);
        }

        ringPositions.get(char).push(i);
    }

    function findMinSteps(keyIndex, ringIndex) {
        if (keyIndex === key.length) {
            return 0;
        }

        if (memo[keyIndex][ringIndex] !== null) {
            return memo[keyIndex][ringIndex];
        }

        let minSteps = Infinity;
        const keyChar = key[keyIndex];

        for (const pos of ringPositions.get(keyChar)) {
            const diff = Math.abs(ringIndex - pos);
            const step = Math.min(diff, n - diff);
            const nextSteps = findMinSteps(keyIndex + 1, pos);
            minSteps = Math.min(minSteps, step + nextSteps);
        }

        memo[keyIndex][ringIndex] = minSteps;
        return minSteps;
    }

    return findMinSteps(0, 0) + m;
};
//leetcode submit region end(Prohibit modification and deletion)
