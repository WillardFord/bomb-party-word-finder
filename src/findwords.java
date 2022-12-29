package src;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Need to implement a Generalized Suffix Tree I think.
 */
class SortedDictionary{
    // number represents the number of words to find per query.
    int number;

    /*
     * Set the number wods to find per query
     * 
     * num - the number of words to check for each substring
     */
    SortedDictionary(int num){
        this.number = num;
    }

    /*
     * Add word to dictionary
     * 
     * Does this need to be made from a list or can we do this one by one?
     */
    void add(){

    }

    /*
     * Returns n words with given substring
     * 
     * substring - the substring present in the best word
     */
    String[] getWords(String substring){
        
    }

    /*
     * Finds the best word from the first n found words
     * 
     * substring - the substring present in the best word
     */
    String bestWord(String substring){
        String[] possibleWords = getWords(substring);
        
        /*
         * From this list of words we need to pick the best to show to the user.
         * The best word should be, in order of importance:
         * 1) Use many unique words
         * 2) Use letters that we haven't seen before
         * 3) Not be too difficult to type
         */

        
    }
}

public static void main(String[] args){

    // Read file to 
    File dictFile = new File("dict.txt");
    Scanner scnr = new Scanner(dictFile);
    while(scnr.hasNextLine()){
        String word = scnr.nextLine();

    }
    scnr.close();

    while(true){

    }
}