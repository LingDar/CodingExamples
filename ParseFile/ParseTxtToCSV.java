import java.util.ArrayList;
/**
 * Write a description of class ParseTxtToCSV here.
 * Parses a file from txt in to a CSV file
 * see methods for options
 * @author BDK@BDKCreate.com
 * @version May 18, 2017
 */
public class ParseTxtToCSV
{
    /**
     * Constructor for objects of class ParseTxtToCSV
     */
    public ParseTxtToCSV()
    {
 
    }

    public static ArrayList<String> parseTxtToCSVWithSpecialCharacter(String filename, char specail){
        ArrayList<String> attri = new ArrayList<String>();
        ArrayList<String> lines = InfoLists.readFileAL(filename);
        for(int i = 1; i < lines.size(); i++){
            String tempStr = "";
            ArrayList<String> tempArray = StringUtils.parseSpecialRemoveWhiteSpace(lines.get(i), specail);
            for(int a = 0; a < tempArray.size(); a++){
                if(a == 0){
                    tempStr = tempArray.get(a);
                }
                else {
                    tempStr += ","+ tempArray.get(a) ;
                }
            }
            attri.add(tempStr);
            System.out.println(tempStr);
        }
         
        return attri;
        
    }
    
    public static void writeParseTxtToCSVWithSpecialCharacter(String filename, char specail){
        ArrayList<String> lines = parseTxtToCSVWithSpecialCharacter(filename, specail);

    }
}
