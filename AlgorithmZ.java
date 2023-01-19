// 1.4 Fundamental Pre-processing in Linear Time

import java.util.Scanner;

public class AlgorithmZ {
    int[] Zscores;
    Integer l, r;
    String processing_str;
    Integer find_str_length;

    AlgorithmZ(){
        this.processing_str = "";
        this.find_str_length = 0;
        this.l = 0;
        this.r = 0;
        this.Zscores = null;
    }

    void generate_Zscores(String find_str, String search_str){
        this.l = 0;
        this.r = 0;
        this.find_str_length = find_str.length();
        this.processing_str = find_str + "$" + search_str;
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

    void find(){
        for(int index = 1; index < this.Zscores.length ; index ++){
            if(Zscores[index] == this.find_str_length){
                System.out.println(index - find_str_length - 1);
            }
        }
    }

    public static void main(String[] args){
        AlgorithmZ string_searcher = new AlgorithmZ();

        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter string to be searched:");
        String search_str = user_input.nextLine();
        System.out.println("Enter string to find:");
        String find_str = user_input.nextLine();
        user_input.close();

        string_searcher.generate_Zscores(find_str, search_str);
        string_searcher.find();

    }
}