//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string[]} deadends
 * @param {string} target
 * @return {number}
 */
var openLock = function (deadends, target) {
    const deadSet = new Set(deadends);

    if (deadSet.has("0000")) {
        return -1;
    }

    const queue = ["0000"];
    deadSet.add("0000");
    let count = 0;

    while (queue.length > 0) {
        let size = queue.length;

        for (let i = 0; i < size; i++) {
            const curr = queue.shift();

            if (curr === target) {
                return count;
            }

            const nextStates = getNextStates(curr);

            for (const state of nextStates) {
                if (!deadSet.has(state)) {
                    deadSet.add(state);
                    queue.push(state);
                }
            }
        }

        count++;
    }

    return -1;
};

/**
 * Generates the next states for a given state.
 *
 * @param {string} curr - The current state.
 * @return {Array<string>} - The next states.
 */
function getNextStates(curr) {
    const nextStates = [];
    const chars = [...curr];

    for (let i = 0; i < 4; i++) {
        const currChar = chars[i];
        chars[i] = currChar === '9' ? '0' : String.fromCharCode(currChar.charCodeAt(0) + 1);
        nextStates.push(chars.join(''));
        chars[i] = currChar === '0' ? '9' : String.fromCharCode(currChar.charCodeAt(0) - 1);
        nextStates.push(chars.join(''));
        chars[i] = currChar;
    }

    return nextStates;
}

//leetcode submit region end(Prohibit modification and deletion)
