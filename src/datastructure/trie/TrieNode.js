export class TrieNode {

    constructor() {
        children = [];
        isEndOfWord = false;

        for(let i = 0 ; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }
}