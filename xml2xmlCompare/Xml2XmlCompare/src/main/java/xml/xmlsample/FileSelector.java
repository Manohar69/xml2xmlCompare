package xml.xmlsample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileSelector {
	public static final String source = new String("./src/input/");
	public static final String destination = new String("./src/output/");
	public static final XmlMapper mapper = new XmlMapper();

	public FileSelector() throws FileNotFoundException, IOException {
		File folder=new File(source);
		//File outputFolder = new File(destination);
		File[] files= folder.listFiles();{
			System.out.println(folder);
			if(folder!=null && files != null) {
				for(File f:files) {
					System.out.println(f.getName());
					if(f.getName().endsWith(".xml")) {
						String xml = inputStreamToString(new FileInputStream(f));
						System.out.println("XML String:-"+xml);
						Object value=mapper.readValue(f, Object.class);
						System.out.println("XML Object:-"+value.toString());
						boolean outputFolder= new File(destination+f.getName().concat(".xml")).getParentFile().createNewFile();
						System.out.println(outputFolder);
					}
				}
			} else if(!folder.exists()){
				System.out.println("There is no specified folder exists"+folder);
			} else {
				System.out.println("There is no files in specific path"+files);
			}
		}
	}
	public String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
}
