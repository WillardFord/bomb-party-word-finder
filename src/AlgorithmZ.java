// 1.4 Fundamental Pre-processing in Linear Time

import java.util.ArrayList;
import java.util.Scanner;

public class AlgorithmZ {
    ArrayList<Integer> Zscores;
    Integer l, r;
    String processing_str;
    Integer find_str_length;

    AlgorithmZ(){
        this.processing_str = "";
        this.find_str_length = 0;
        this.l = 0;.
        this.r = 0;
        this.Zscores = null;
    }

    void generate_Zscores(String find_str, String search_str){
        this.l = 0;
        this.r = 0;
        this.find_str_length = find_str_length
        this.processing_str = find_str + "$" + search_str;
        this.Zscores = new ArrayList<>(processing_str.length);

        for(int index = 1; index < processing_str.length; index ++){
            if(!this.in_Zbox(index)){
                int start = 0;
                while(processing_str.substring(start+index, start+index+1).equals(
                    processing_str.substring(start, start+1))){
                        start ++;
                    }
                Zscores.put(index, start);
                if(start>0){
                    this.r = index + start - 1;
                    this.l = index;
                }
            } 
            else{
                int z_prime = Zscores.get(index - l)
                if( z_prime < r - index + 1){
                    Zscores.add(index, z_prime)
                }
                else{
                    int right_of_r = r + 1;
                    while(processing_str.substring(right_of_r, right_of_r + 1).equals(
                    processing_str.substring(right_of_r - index + 1, right_of_r - index + 2))){
                        right_of_r ++;
                    }
                    Zscores.add(index, right_of_r - index);
                    this.r = right_of_r - 1;
                    this.l = index;
                }
            }
        }
    }

    private boolean in_Zbox(index){
        if(index>r) return false;
        return true;
    }

    ArrayList<Integer> find(){
        ArrayList<Integer> output = new ArrayList<Integer>()
        for(Integer index : this.Zscores){
            if(index.equals(this.find_str_length)){
                output.add(index)
            }
        }
        return output;
    }

    public static void main(String[] args){
        AlgorithmZ string_searcher = new AlgorithmZ();

        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter string to be searched: ");
        String search_str = user_input.nextLine();
        System.out.println("Enter string to find: ");
        String find_str = user_input.nextLine();

        string_searcher.generate_Zscores(find_str, search_str)
        for(Integer index: string_searcher.find()){
            System.out.println(index);
        }

    }
}