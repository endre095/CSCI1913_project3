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
        for (String s : strings) { //loops through all strings in the string array
            LetterSample[] samples = LetterSample.toSamples(s, segLength);// create a letter sample array of letter samples for the string
            for (LetterSample sample : samples) { //loops through the letter sample array
                String string = sample.getSegment(); //gets the string from that letter sample
            
                }
            }
            }
        
    

    public int getSampleCount() {
        return samplesProcessed;
    }

    public String generate(){return "";};


}
