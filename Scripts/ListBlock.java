import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;

public class ListBlock{

    static String readFile(){
        String value = "";
        try {
            File myObj = new File("listBlock.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              try{
                if(data.charAt(0) == '0' && data.charAt(0) != 'w'){
                    if(!data.contains("#"))
                        value += "\"*://*."+data.substring(8,data.length())+"/*\",\n";
                }
              }catch(Exception e){
                  
              }
            }
            myReader.close();
            System.out.println("Successfully read to the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
          return value;

    }
     static void writeFile(String text) {
        try {
          FileWriter myWriter = new FileWriter("listBlock_v2.txt");
          myWriter.write(text);
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }

    public static void main(String[] args){
        //https://raw.githubusercontent.com/StevenBlack/hosts/master/hosts
        String value = readFile();
        writeFile(value);
    }
}