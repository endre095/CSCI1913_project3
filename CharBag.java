public class CharBag {
    
    private char[] bag;
    private int[] count;
    private int index;


    public CharBag() {
        bag = new char[1000];
        count = new int[27];
        index = 0;
    }

    public int getCount(char c){ return 0;};

    public void add(char c){
        if (Character.isUpperCase(c)) {
            c = Character.toLowerCase(c);
        }
        int asciVal = (int) c;
        

        if (asciVal >= 141 && asciVal <= 172) {
            bag[index] = c;
            index++;
            return;
        }
        else {
            bag[index] = '.';
            index++;
        }
    }

    public void remove(char c){
        for (char curr: bag) {
            if (curr == c) {
                bag.remove()
            }
        }
    }


    public int getSize(){ return 0;}
    public String toString() {return "";}
    public char getRandomChar() {return 'x';}


}