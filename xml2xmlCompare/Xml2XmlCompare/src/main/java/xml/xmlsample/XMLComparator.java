package xml.xmlsample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;

/**
  *
  * Java program to compare two XML files using XMLUnit example

  * @author Javin Paul
  */
public class XMLComparator {
 
 
    public static void main(String args[]) throws FileNotFoundException, 
                                                  SAXException, IOException {
        FileInputStream fis1 = new FileInputStream("./src/input/source.xml");
        FileInputStream fis2 = new FileInputStream("./src/input/target.xml");
     

        BufferedReader  source = new BufferedReader(new InputStreamReader(fis1));
        BufferedReader  target = new BufferedReader(new InputStreamReader(fis2));
     
        //configuring XMLUnit to ignore white spaces, attribute order and comments
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreAttributeOrder(true);
        XMLUnit.setIgnoreComments(true);
     
        //comparing two XML using XMLUnit in Java
        List<Difference> differences = compareXML(source, target);
     
        //showing differences found in two xml files
        printDifferences(differences);
   
    }    
 
    @SuppressWarnings("unchecked")
	public static List<Difference> compareXML(Reader source, Reader target) throws
                  SAXException, IOException{
     
        //creating Diff instance to compare two XML files
        Diff xmlDiff = new Diff(source, target);
     
        //for getting detailed differences between two xml files
        DetailedDiff detailXmlDiff = new DetailedDiff(xmlDiff);
     
        return detailXmlDiff.getAllDifferences();
    }
 
    public static void printDifferences(List<Difference> differences){
        int totalDifferences = differences.size();
        System.out.println("===============================");
        System.out.println("Total differences : " + totalDifferences);
        System.out.println("================================");
     
        for(Difference difference : differences){
            System.out.println(difference);
        }
    }
}