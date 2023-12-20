//leetcode submit region begin(Prohibit modification and deletion)

var Trie = function () {
    this.root = new TrieNode();
};

/**
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function (word) {
    let node = this.root;

    for (let c of word) {
        if (!node.children[c]) {
            node.children[c] = new TrieNode();
        }

        node = node.children[c];
    }

    node.isEndOfWord = true;
};

/**
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
    let node = this.root;

    for (let c of word) {
        if (!node.children[c]) {
            return false;
        }

        node = node.children[c];
    }

    return node.isEndOfWord;
};

/**
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
    let node = this.root;

    for (let c of prefix) {
        if (!node.children[c]) {
            return false;
        }

        node = node.children[c];
    }

    return true;
};

var TrieNode = function () {
    this.children = {};
    this.isEndOfWord = false;
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
//leetcode submit region end(Prohibit modification and deletion)
