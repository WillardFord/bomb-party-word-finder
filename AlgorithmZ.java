// 1.4 Fundamental Pre-processing in Linear Time

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class AlgorithmZ {
    int[] Zscores;
    Integer l, r;
    String processing_str;
    Integer find_str_length;
    String search_str;

    AlgorithmZ(String search_str){
        this.processing_str = "";
        this.find_str_length = 0;
        this.l = 0;
        this.r = 0;
        this.Zscores = null;
        this.search_str = search_str;
    }
    /**
     * This function takes a search_str and find_str concats them together into a 
     * processing_str.
     * Then it generates the Z scores stored in an array Zscores using fundamental 
     * preprocessing of strings algorithm.
     */
    void generate_Zscores(String find_str){
        this.l = 0;
        this.r = 0;
        this.find_str_length = find_str.length();
        this.processing_str = find_str + "$" + this.search_str;
        Integer processing_str_length = processing_str.length();
        this.Zscores = new int[processing_str_length];

        for(int index = 1; index < processing_str_length; index ++){
            if(!this.in_Zbox(index)){
                int start = 0;
                while((start + index < processing_str_length) && 
                processing_str.charAt(start+index) == processing_str.charAt(start)){
                        start ++;
                    }
                this.Zscores[index] = start;
                if(start>0){
                    this.r = index + start - 1;
                    this.l = index;
                }
            }
            else{
                int z_prime = Zscores[index - l];
                if( z_prime < r - index + 1){
                    Zscores[index] = z_prime;
                }
                else{
                    int right_of_r = r + 1;
                    while((right_of_r < processing_str_length) && 
                    (processing_str.charAt(right_of_r) == 
                    processing_str.charAt(right_of_r - index + 1))){
                        right_of_r ++;
                    }
                    Zscores[index] = right_of_r - index;
                    this.r = right_of_r - 1;
                    this.l = index;
                }
            }
        }
    }

    private boolean in_Zbox(Integer index){
        if(index>r) return false;
        return true;
    }

    /**
     * This function simply iterates through the Zscores and prints the indices in the 
     * search_str that corresponds to the found find_str.
     */
    ArrayList<String> find(){
        ArrayList<String> output_words = new ArrayList<String>();
        for(int index = 1; index < this.Zscores.length ; index += 1){
            if(Zscores[index] == this.find_str_length){
                int left_index = index - find_str_length - 1;
                while(search_str.charAt(left_index) != '#') left_index --;
                int right_index = index - find_str_length - 1;
                while(search_str.charAt(right_index) != '#') right_index ++;
                
                output_words.add(this.search_str.substring(left_index + 1 , right_index));
            }
        }
        return output_words;
    }

    public static void main(String[] args){
        // Add dictionary to search str, separate each character by a #.
        String search_str = "";

        try{
            FileInputStream fstream = new FileInputStream("src/dict.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                search_str += strLine.toLowerCase() + "#";
            }
            in.close();
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

        //System.out.println("Enter string to be searched:");
        //String search_str = user_input.nextLine();
        AlgorithmZ string_searcher = new AlgorithmZ(search_str);

        try{
            String newline = System.getProperty("line.separator");
            Scanner user_input = new Scanner(System.in);
            HashSet<String> seen_words = new HashSet<String>();
            HashSet<Character> seen_chars = new HashSet<Character>();

            ArrayList<String> possible_words = new ArrayList<String>();
            int j = 0;
            while(true){
                
                System.out.println("Enter string to find:");
                String find_str = user_input.nextLine();

                if (find_str == ""){
                    j++;
                    String new_word = possible_words.get(j);
                    seen_words.add(new_word);
                    for (Character letter: new_word.toCharArray()){
                        seen_chars.add(letter);
                    }

                    if (seen_chars.size() > 25) {
                        seen_chars = new HashSet<Character>();
                    }
                    System.out.println(new_word);
                    continue;
                }
                j = 0;
                possible_words = new ArrayList<String>();
                string_searcher.generate_Zscores(find_str);


                
            
                ArrayList<String> found_words = string_searcher.find();
                Collections.sort(found_words, Comparator.comparingInt(String::length));
                for (String word: found_words) {
                    if (!seen_words.contains(word)) {
                        for (Character letter: word.toCharArray()){
                            if (!seen_chars.contains(letter)){
                                possible_words.add(word);
                                break;
                            }
                        }
                    }
                }
                if (possible_words.size() < 1) {
                    for (int i = 0; i < 5; i++){
                        possible_words = found_words;
                    }
                }
                String the_word = possible_words.get(j);
                System.out.println(the_word);

                seen_words.add(the_word);
                for (Character letter: the_word.toCharArray()){
                    seen_chars.add(letter);
                }

                if (seen_chars.size() > 25) {
                    seen_chars = new HashSet<Character>();
                }


            }
        }catch(Exception E){
            System.out.println("System.in was closed; exiting");
        }
    }
}
