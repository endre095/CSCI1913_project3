/*
Author: Andrew Endres
Date: 4/21/26
*/

public class CharBag {
    
    private int[] bag;
    private int netChanges;


    public CharBag() {
        bag = new int[27];
        netChanges = 0;

    }
    /*
     * creates the charBag object and setting default vals
     */

    public int getCharIndex(char c) {
        if (Character.isUpperCase(c)) { //converst the char to lowercase if not already
            c = Character.toLowerCase(c);
        }
        int index = c - 'a'; //normalizes the characters asci value into its array index
        if (index >= 26 || index < 0) {
            return 26; //returns the '.' character
        }
        return index; //else returns the characters index thats within the array's bounds
    }
    /*
     * converts the char to lowercase if it already isnt, then it normalizes the
     * char's ascii val to find its array index, if it is out of range of the
     * alphabet it returns the index for ., else it returns the chars corresponding
     * index
     */
    

    public void add(char c){
        int index = getCharIndex(c);
        bag[index]++;
        netChanges++;
    }
    /*
     * adds a character by finding the index associated with the character and
     * incremengint it
     */

    public void remove(char c){
        int index = getCharIndex(c);
        if (bag[index] > 0) {
            bag[index]--;
            netChanges--;
        }
    }
    /*
     * removes a characters from the bag by using its index and decrementing the
     * count associated with the index
     */


    public int getCount(char c) {
        int index = getCharIndex(c);
        return bag[index];
    }
    
    public int getSize() {
        return netChanges;
    }

    public  String toString() {
        String returnStr = "CharBag{";
        for (int i = 0; i < bag.length; i++) {
            char currChar = (char) (i + 97);
            if (i == 26) {
                returnStr += (LetterSample.STOP + ":" + bag[i]);
            }
            else {
                returnStr += (currChar + ":" + bag[i] + ", ");
            }
        }
        return returnStr + "}";
    }
    /*
     * prints the characters and their frequency
     */

    public char getRandomChar() {
        if (getSize() <= 0) {
            return LetterSample.STOP; // or '.'
        }

        int count = (int) (Math.random() * getSize()); // random number [0, size)

        for (int i = 0; i < bag.length; i++) {
            count -= bag[i];
            if (count < 0) {
                if (i == 26)
                    return LetterSample.STOP;
                return (char) (i + 'a');
            }
        }

        return LetterSample.STOP; // fallback (should never happen)
    }
    /*
 * if there were never any changes made to the array, it returns the stop char,
 * then it finds a random number from 0 to the netChanges-1, and loops through
 * the bag subtracting the values in each arary slot from count, if count is < 0
 * it finds a value to return, this makes it so that there is a weight based on
 * how many times a char shows up, if it shows up more it subtracts more from
 * the count and therefor is more likely to make the count < 0, which will pick
 * the char
 */
}