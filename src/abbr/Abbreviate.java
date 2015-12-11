package abbr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Abbreviate {

    /**
     * Abbreviates a string by removing all vowels.
     *
     * Returns a new string that is equal to 'string' but with all vowels, both capital and
     * lower case, removed.  Other characters are unmodified.
     */
    final static Set<Character> VOWELS = initVowels();

    private static Set<Character> initVowels(){
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        return vowels;
    }


    public static String abbreviate(String string)
    {
        // TODO: Write this method.
        StringBuilder abbreviated = new StringBuilder();
        for(char letter : string.toCharArray()){
            if(!VOWELS.contains(Character.toUpperCase(letter))){
                abbreviated.append(letter);
            }
        }
        return abbreviated.toString();
    }

    public static void main(String[] args) {
        System.out.println(abbreviate("The quick brown fox jumped over the lazy dogs."));
        System.out.println(abbreviate("It was the best of times, it was the worst of times."));
    }

}
