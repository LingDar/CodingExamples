 

import java.io.*;
import java.util.*;
import java.util.ArrayList;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author bdk85655
 */public class InfoLists {
    private final static String[] FILE_NAMES    = {"Statistics"};                                         
    private final static String[] BLANK    = {"null"};
    private final static int[] INT_BLANK    = {0};
                                                      
    private final static String FILE_EXT = ".txt"; 
    private final static String FILE_PRE = "Info//";//"Images//";                                                       
                                                     
    
    public static String[] readFile(String name){
            System.setProperty("file.encoding","UTF-8");
            ArrayList<String> tempAL = new ArrayList<String>();
            try{
                Scanner infile = new Scanner(new File(FILE_PRE + name + FILE_EXT), "UTF-8");
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
                System.out.println("FILE NOT FOUND");
                return BLANK;
            }

    }
    
    public static int[] readIntFile(String name){
      
            ArrayList<String> tempAL = new ArrayList<String>();
            try{
                Scanner infile = new Scanner(new File(FILE_PRE + name + FILE_EXT));
                while (infile.hasNextLine()) {
                    String nextWords = infile.nextLine();
                    tempAL.add(nextWords);
                }
                int[] temp = new int[tempAL.size()];
                for(int i = 0; i < temp.length; i++ ){
                    temp[i] = Integer.parseInt(tempAL.get(i));
                }
            
                return temp;
            }
            catch(FileNotFoundException e){
                
                return INT_BLANK;
            }

    }
    
    public static ArrayList<String> readFileAL(String name){
            setToUTF8();
            ArrayList<String> tempAL = new ArrayList<String>();
            try{
                Scanner infile = new Scanner(new File(FILE_PRE + name + FILE_EXT), "UTF-8");
                while (infile.hasNextLine()) {
                    String nextWords = infile.nextLine();
                    tempAL.add(nextWords);
                }
                return tempAL;
            }
            catch(FileNotFoundException e){
                
                return tempAL;
            }

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
    
    public static String readStringFile(String name){
            String temp ="";
            //ArrayList<String> tempAL = new ArrayList<String>();
            try{
                Scanner infile = new Scanner(new File(FILE_PRE + name + FILE_EXT));
                while (infile.hasNextLine()) {
                    String nextWords = infile.nextLine();
                    temp += nextWords;
                }
                return temp;
                }
            catch(FileNotFoundException e){
                return temp;
            }

    }
    
    public static void setToUTF8(){
        System.setProperty("file.encoding", "UTF-8");
      
        //System.out.println("defaultCharacterEncoding by property after updating file.encoding : " + System.getProperty("file.encoding"));

    }
    
    /**
     * To get  Random array from an array with no repeats
     * ArrayList<String> deck the arrylsit o get random ones from
     * int num the number of card to get from deck
     */
    public static ArrayList<String> getRandomArrrayListFromArrayList(ArrayList<String> deck, int num){
        ArrayList<String> tempAL = new ArrayList<String>();
        if (deck.size() <= num ){
            return deck;
        }
        Die die = new Die(deck.size());
        boolean notThere = true;
        while (notThere){
            int rNum = die.roll() -1 ;
            String entry = deck.get(rNum);
            if (tempAL.contains(entry)){}
            else {
                tempAL.add(entry);
            }
            if(tempAL.size() == num){
                notThere = false;
            }
        }
        
        
        return tempAL;
    }
}
