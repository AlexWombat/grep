import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grep {
  public Grep() {}
  
  public static void main(String[] args) {
    String fName;
    File f;
    
    for (int fileNumber = 1; fileNumber <= 5; fileNumber++) {
      fName = "src/TestFile" + fileNumber + ".txt";
      try {
        f = new File(fName);
        Scanner file = new Scanner(f);
        Pattern pattern = Pattern.compile("\\d+");
        while (file.hasNextLine()) {
          String row = file.nextLine();
          Matcher matcher = pattern.matcher(row);
          if (matcher.find()) {
            System.out.println(fName+":"+row);
          }
        }
        file.close();
      } catch (FileNotFoundException e) {
        System.out.println("Problem opening file.");
        e.printStackTrace();
        return;
      }
    }
  }
}