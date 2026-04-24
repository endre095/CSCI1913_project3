/*
Author: Andrew Endres
Date: 4/21/26
*/

public class TrieNode<T> {
    private T data;
    private TrieNode<T>[] links;

    public TrieNode() {
        data = null;
        links = (TrieNode<T>[]) new TrieNode[26]; 
    }
    /*
     * creates the trienode object with its array and data values set to null
     */
       
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TrieNode<T> getChild(char letter) {
        if (Character.isUpperCase(letter)) { //if character is uppercase return null
            return null;
        }
        int index = letter - 'a'; //get letters index in array, similar to CharBag's but opposite result, char to ascii
        if (links[index] == null) { //if it is null at index, make  new trienode
            links[index] = new TrieNode<T>();
        }
        return links[index]; //return trienode at index
        }
        /*
         * checks if the letter is uppercase, if it is it returns null, then finds the
         * index of the letter, checks if it is null at that index, if it is it makes a
         * new trienode there and returns the index
         */

    
    public int getTreeSize() {
        int total = 1; 
        for (TrieNode<T> n : links) {
            if (n != null) {
                total += n.getTreeSize();
            }
        }
        //System.out.println("adding: " + total);
        return total; //every node increases count by 1
    }
    /*
     * gets the size of the tree recursively by calling the function on each node in
     * every links array of every trienode object in a tree
     */
    }




