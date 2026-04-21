/*
Author: Andrew Endres
Date: 4/21/26
*/

public class Gibberisher {
    private Trie<CharBag> model;
    private int segLength;
    private int samplesProcessed;

    public Gibberisher(int length) {
        segLength = length;
        samplesProcessed = 0;
        model = new Trie<CharBag>();
    }

    public void train(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            LetterSample[] strArray = LetterSample.toSamples(strings[i], segLength);
            for (int j = 0; j < strArray.length; j++) {
                String currStr = strArray[j].getSegment();
                TrieNode<CharBag> 
            }
        }
    }

}
