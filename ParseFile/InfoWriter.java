 

import java.io.*;
import java.io.FileWriter;
import java.util.*;
import java.util.ArrayList;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author bdk85655
 */public class InfoWriter {
    private final static String[] FILE_NAMES    = {"Statistics"};                                         
    private final static String[] BLANK    = {"null"};
                                                      
    private final static String FILE_EXT = ".txt";
    private final static String FILE_PRE = "Images//";                                                       
                                                     
    
    public static String[] readFile(String name){
      
            ArrayList<String> tempAL = new ArrayList<String>();
            try{
                Scanner infile = new Scanner(new File(FILE_PRE + name + FILE_EXT));
                while (infile.hasNextLine()) {
                    String nextWords = infile.nextLine();
                    tempAL.add(nextWords);
                }
                String[] temp = new String[tempAL.size()];
                for(int i = 0; i < temp.length; i++ ){
                    temp[i] = tempAL.get(i);
                }
            
                return temp;
            }
            catch(FileNotFoundException e){
                
                return BLANK;
            }

    }
    
    public static boolean writeFile(String name){
      /*
            ArrayList<String> tempAL = new ArrayList<String>();
            try{
                FileWriter outfile = new FileWriter(new File(FILE_PRE + name + FILE_EXT));
                while (outfile.hasNextLine()) {
                    String nextWords = infile.nextLine();
                    tempAL.add(nextWords);
                }
                String[] temp = new String[tempAL.size()];
                for(int i = 0; i < temp.length; i++ ){
                    temp[i] = tempAL.get(i);
                }
            
                return true;
            }
            catch(FileNotFoundException e){
                
                return false;
            }
            */
           return false;

    }
    
   
    
    public static int findPosition(String find, String[] search){
        int position = -1;
        for ( int i= 0; i < search.length; i++){
            if (search[i].equals(find)){
                return i;
            }
            }
        return position;
        //return search.length;
    }
    
     public static int findPosition(String find, ArrayList<String> search){
        int position = -1;
        for ( int i= 0; i < search.size(); i++){
            if (search.get(i).equals(find)){
                return position;
            }
            }
        return position;
    }
}
