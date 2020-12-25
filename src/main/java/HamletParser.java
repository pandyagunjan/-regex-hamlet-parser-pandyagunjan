import com.sun.org.apache.xml.internal.resolver.readers.OASISXMLCatalogReader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    String hamletToLeonREGEX = "[Hh][Aa][Mm][Ll][Ee][Tt]";
    //String hamletToLeonREGEX = "(?i)\\bHamlet\\b";
    String horatioToTariqREGEX = "[Hh][Oo][Rr][Aa][Tt][Ii][Oo]";
    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        Pattern pattern =  Pattern.compile(hamletToLeonREGEX);
        Matcher match = pattern.matcher(hamletData);
        //match.replaceAll("Leon");
       return  match.replaceAll("Leon");
       // return hamletData;
    }
    public String getHoratioData(){
        Pattern pattern =  Pattern.compile(horatioToTariqREGEX);
        Matcher match = pattern.matcher(hamletData);

        return  match.replaceAll("Tariq");
    }

    public int hamletNumbers(){
        Pattern pattern = Pattern.compile(hamletToLeonREGEX);
        Matcher matcher = pattern.matcher(hamletData);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }

    public int horatioNumbers(){
        Pattern pattern = Pattern.compile(horatioToTariqREGEX);
        Matcher matcher = pattern.matcher(hamletData);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }
}
