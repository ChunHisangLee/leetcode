//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string[]} words
 * @param {number} maxWidth
 * @return {string[]}
 */
var fullJustify = function (words, maxWidth) {
    let res = [];
    let line = [];
    let lineLength = 0;
    let i = 0;
    while (i < words.length) {
        if (lineLength + words[i].length <= maxWidth) {
            line.push(words[i]);
            lineLength += words[i].length + 1;
            i++;
        } else {
            res.push(line);
            line = [];
            lineLength = 0;
        }
    }
    if (line.length > 0) {
        res.push(line);
    }

    for (let i = 0; i < res.length - 1; i++) {
        let line = res[i];
        if (line.length === 1) {
            res[i] = line[0] + " ".repeat(maxWidth - line[0].length);
        } else {
            let space = maxWidth - line.reduce((sum, word) => sum + word.length, 0);
            let spacePerWord = Math.floor(space / (line.length - 1));
            let extraSpace = space % (line.length - 1);
            let lineStr = "";
            for (let j = 0; j < line.length - 1; j++) {
                lineStr += line[j] + " ".repeat(spacePerWord + (j < extraSpace ? 1 : 0));
            }
            lineStr += line[line.length - 1];
            res[i] = lineStr;
        }
    }
    let lastLine = res[res.length - 1];
    res[res.length - 1] = lastLine.join(" ") + " ".repeat(maxWidth - lastLine.reduce((sum, word) => sum + word.length, 0) - lastLine.length + 1);
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
