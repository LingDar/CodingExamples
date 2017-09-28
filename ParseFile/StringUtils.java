import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class contains numerous static methods for manipulating Strings.
 * 
 * @author Dave Reed
 * @version 4/10/2010
 */
public class StringUtils {
    /**
     * Reverses a string.
     *   @param str the string to be reversed
     *   @return a copy of str with the order of the characters reversed
     */
    public static String reverse(String str) {
        String copy = "";
        for (int i = 0; i < str.length(); i++) {
            copy = str.charAt(i) + copy;
        }
        return copy;
    }
    
    /**
     * Removes all non-letters from a string.
     *   @param str the string to be stripped
     *   @return a copy of str with all non-letters removed
     */
    public static String stripNonLetters(String str) {
        String copy = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                copy += str.charAt(i);
            }
        }
        return copy;    
    }

    /**
     * Determines whether a string is a palindrome.
     *   @param str the string to be tested
     *   @return true if the string is a palindrome; else, false
     */     
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        str = StringUtils.stripNonLetters(str);
        
        String reverseStr = StringUtils.reverse(str);
        
        return (str.equals(reverseStr));
    }
    
    ///////////////////////////////////////////////////////////////////////

     /**
     * Removes all non-letters from a string.
     *   @param str the string to be stripped
     *   @return a copy of str with all non-letters removed
     */
    public static String stripWhiteSpace(String str) {
        str = str.replaceAll("\t", ""); 
        String copy = "";
        for (int i = 0; i < str.length(); i++) 
            if (Character.isWhitespace(str.charAt(i)) ){
                
            }
            else {
                copy += str.charAt(i);
            }
        //}
        return copy; //str = str.replaceAll("\\s", "");   
    }
    
    
     /**
     * Removes all non-letters from a string.
     *   @param str the string to be stripped
     *   @return a copy of str with all non-letters removed
     */
    public static String trimWhiteSpace(String str) {
        str = str.replaceAll("\t", ""); 
        String copy = "";
        ArrayList<String> tempAL = separateWords(str);
        for (int i = 0; i < tempAL.size(); i++) {
            if(i == 0) {
                copy += tempAL.get(i);
            }
            else {
                copy += " " + tempAL.get(i);
            }
        }
        return copy; //str = str.replaceAll("\\s", "");   
    }
    
    /**
     * Finds the first occurrence of a vowel in a string.
     *   @param str the string to be searched
     *   @return the index of the first occurrence of a vowel from seq
     */
     public static int findVowel(String str) {
        str = str.toLowerCase();

        String vowels = "aeiou";        
        for (int i = 0; i < str.length(); i++) {
            char nextChar = str.charAt(i);
            if (vowels.indexOf(nextChar) != -1) {
                return i;
            }
        }
        return -1;
    }
 
    /**
     * Translates a string into Pig Latin
     *   @param str the string to be translated
     *   @return a copy of str translated into Pig Latin
     */     
    public static String pigLatin(String str) {  
        int firstVowel = StringUtils.findVowel(str);
        
        if (firstVowel <= 0) {
            return str + "way";
        }
        else {
            return str.substring(firstVowel, str.length()) + 
                   str.substring(0,firstVowel) + "ay";
        }
    }
    
    /**
     * returns the first string that starts with capital and ends before the space or next capital
     */
    public static String findSet(String str){
        if(str.length() < 1){
            return str;
        }
        else {
           for(int i = 1; i < str.length(); i++){
                if( Character.isUpperCase(str.charAt(i))){
                    return str.substring(0,i);
                }
                else if(Character.isWhitespace(str.charAt(i))){
                    return str.substring(0,i);
                }
            } 
        }
        return str;
    }
    
    public static ArrayList<String> separateWords(String str){
        ArrayList<String> tempAL = new ArrayList<String>();
        String tempCurrent = "";
        int start = 0;
        int end = 0;
        boolean isWord = false;
        for(int i = 0; i < str.length();i++){
             if(Character.isWhitespace(str.charAt(i))){
                if (isWord){
                    tempAL.add(str.substring(start, i));
                    start = i+1;
                    isWord = false;
                }
                else{
                    start++;
                    isWord = false;
                }
             } 
             else if(i == str.length()-1){
                if(isWord){
                    tempAL.add(str.substring(start));
                }
                else if (!Character.isWhitespace(str.charAt(i))){
                    tempAL.add(str.substring(i));
                }
                }
             else {
                 isWord = true;
             }
        }
        
        return tempAL;
    }
    
    public static ArrayList<String> separateWords(ArrayList<String> str){
        ArrayList<String> tempAL = new ArrayList<String>();
        for(int i = 0; i < str.size(); i++){
            ArrayList<String> temp2 = separateWords(str.get(i));
            for(int x = 0; x < temp2.size(); x++){
                tempAL.add(temp2.get(x));
            }
        }
        return tempAL;
    }
    
    /**
     * returns the first string that starts with capital and ends before the space or next capital
     */
    public static String firstWord(String str){
        if(str.length() < 1){
            return str;
        }
        else {
           for(int i = 1; i < str.length(); i++){
               if(Character.isWhitespace(str.charAt(i))){
                    return str.substring(0,i);
                }
            } 
        }
        return str;
    }
    
    public static ArrayList<String> parseCommas(String str){
        ArrayList<String> tempAL = new ArrayList<String>();
        String tempCurrent = "";
        int start = 0;
        int end = 0;
        boolean isWord = false;
        for(int i = 0; i < str.length();i++){
             if(str.charAt(i) == ','){
                if (isWord){
                    tempAL.add(str.substring(start, i));
                    start = i+1;
                    isWord = false;
                }
                else{
                    start++;
                    isWord = false;
                }
             } 
             else if(i == str.length()-1){
                if(isWord){
                    tempAL.add(str.substring(start));
                }
                }
             else {
                 isWord = true;
             }
        }
        
        return tempAL;
    }
    
    public static ArrayList<String> parseSpecial(String str){
        ArrayList<String> tempAL = new ArrayList<String>();
        String tempCurrent = "";
        int start = 0;
        int end = 0;
        boolean isWord = false;
        for(int i = 0; i < str.length();i++){
             if(str.charAt(i) == '➽'){
                if (isWord){
                    tempAL.add(str.substring(start, i));
                    start = i+1;
                    isWord = false;
                }
                else{
                    start++;
                    isWord = false;
                }
             } 
             else if(i == str.length()-1){
                if(isWord){
                    tempAL.add(str.substring(start));
                }
                }
             else {
                 isWord = true;
             }
        }
        
        return tempAL;
    }
    
    public static ArrayList<String> parseSpecialRemoveWhiteSpace(String str){
        ArrayList<String> tempAL = new ArrayList<String>();
        String tempCurrent = "";
        int start = 0;
        int end = 0;
        boolean isWord = false;
        for(int i = 0; i < str.length();i++){
             if(str.charAt(i) == '➽'){
                if (isWord){
                    String str2 = trimWhiteSpace(str.substring(start, i));
                    tempAL.add(str2);
                    start = i+1;
                    isWord = false;
                }
                else{
                    start++;
                    isWord = false;
                }
             } 
             else if(i == str.length()-1){
                if(isWord){
                    String str2 = trimWhiteSpace(str.substring(start));
                    tempAL.add(str2);
                }
                }
             else {
                 isWord = true;
             }
        }
        
        return tempAL;
    }
    
    public static ArrayList<String> parseSpecialRemoveWhiteSpace(String str, char specail){
        ArrayList<String> tempAL = new ArrayList<String>();
        String tempCurrent = "";
        int start = 0;
        int end = 0;
        boolean isWord = false;
        for(int i = 0; i < str.length();i++){
             if(str.charAt(i) == specail){
                if (isWord){
                    String str2 = trimWhiteSpace(str.substring(start, i));
                    tempAL.add(str2);
                    start = i+1;
                    isWord = false;
                }
                else{
                    start++;
                    isWord = false;
                }
             } 
             else if(i == str.length()-1){
                if(isWord){
                    String str2 = trimWhiteSpace(str.substring(start));
                    tempAL.add(str2);
                }
                }
             else {
                 isWord = true;
             }
        }
        
        return tempAL;
    }
    
    public static String getPinyinFromCsPinyin(String str){
        String str2 = "";
        int strlength = str.length();
        //char numChar = '5';
        for (int i = 0; i< strlength; i++){
            char char1 = str.charAt(i);
            if (Character.isLetter(char1)){
                str2 += char1;
            }
        }
        return str2;
    }
    
    public static int getNumberFromCsPinyin(String str){
        //String str2 = "";
        int strlength = str.length();
        int numChar = 5;
        for (int i = 0; i< strlength; i++){
            char char1 = str.charAt(i);
            if (Character.isDigit(char1)){
                numChar = Character.getNumericValue(char1);
            }
        }
        return numChar;
    }
    
    public static boolean isNumber(String str){
        boolean isNumber = true;
        str = stripWhiteSpace(str);
        int strlength = str.length();
        for (int i = 0; i< strlength; i++){
            char char1 = str.charAt(i);
            if (Character.isDigit(char1)){
               
            }
            else {
                isNumber = false;
                return isNumber;
            }
        }
        return isNumber;
    }
}
   
