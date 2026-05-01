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
    /*
     * creates the gibberisher with a specified segment length for the words created
     */

    public void train(String[] strings) {
        for (String s : strings) { // loops through all strings in the string array
            LetterSample[] samples = LetterSample.toSamples(s, segLength);// create a letter sample array of letter
                                                                          // samples for the string
            for (LetterSample sample : samples) { // loops through the letter sample array
                String str = sample.getSegment(); // gets the string from that letter sample
                char next = sample.getNextLetter(); 
                CharBag cb = model.get(str); //get the charbag at that string from the model

                if (cb == null) {
                    cb = new CharBag();
                    model.put(str, cb); //if its null, make cb a new charbag and then puts it in the model
                }
               /*  if (cb.getCharIndex(LetterSample.STOP) == 26) {  
                    samplesProcessed++;
                }*/
                cb.add(next); //add the next char in the sequence to the charbag
                samplesProcessed++;

            }
        }
    }
    /*
     * goes through all input strings, creates letter samples for each, goes though
     * each sample, gets the string and next char in the sequence and adds its to
     * the char bag, if the bag at the string is null, it makes a new char bag
     */

    public int getSampleCount() {
        return samplesProcessed;
    }

    public String generate() {
        StringBuilder master = new StringBuilder(); // makes new editable string
        String lookUp;
        char append;
        boolean stopPleaseThanks = false;

        do {
            CharBag cb = model.get(master.toString()); // gets charbag at the current master string
            if (master.length() > segLength) {
                lookUp = master.substring(master.length() - segLength, master.length()); // sets the string to look up
                                                                                         // with
            } else {
                lookUp = master.toString();
            }

            // System.out.println(lookUp);
            append = model.get(lookUp).getRandomChar();
            // System.out.println(append);

            if (append == LetterSample.STOP) {
                stopPleaseThanks = true;
            } else {
                master.append(append);
            }
        } while (!stopPleaseThanks); 

        return master.toString();
    }
    /*
     * while the following letter is not the stop character, sets the current char
     * bag equal to the model's node's char bag, then does checks to determine what
     * the look up string should be for the following character, then checks if the
     * character should stop the loop, if not goes appends the master string and
     * goes again
     * 
     * p.s. used a do-while loop b/c there was issues with the stop character
     * being attatched at the end of every string, reversing the order of the check
     * prevented the stop char from being added
     */

}
