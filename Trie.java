/*
Author: Andrew Endres
Date: 4/21/26
*/

public class Trie<T> {
    private TrieNode<T> root;

    public Trie() {
        this.root = new TrieNode<T>();
    }
    /*
     * creates the trie object by giving its root a new trienode
     */

    private TrieNode<T> getNode(String str) {
        TrieNode<T> returnTrie = root;
        
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i); //gets character at index in string
            if (returnTrie == null) {
                return null; //if the current node is null, return null
            }
            returnTrie = returnTrie.getChild(currChar); // if not null, sets the new trie to the child of the current trie
                                                        // associated w/ that char in the sequence of chars
        }
        return returnTrie;
    }
    /*
     * gets a node which has the strings value by searching through the starting
     * node, and reassigning the current node to the next node in the sequence of
     * nodes for that specific string of chars, then returns the final node 
     */

    public T get(String str) {
        return getNode(str).getData();
    }
    /*
     * returns the data of the node with this string value
     */

    public void put(String str, T value) {
        getNode(str).setData(value);
    }
    /*
     * sets the data of the node with this string value
     */
}
