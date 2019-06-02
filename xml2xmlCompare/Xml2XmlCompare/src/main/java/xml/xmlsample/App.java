package xml.xmlsample;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        
		try {
			new FileSelector();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
    }
}
