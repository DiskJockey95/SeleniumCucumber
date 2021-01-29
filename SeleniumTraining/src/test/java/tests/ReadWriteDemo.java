package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWriteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		FileInputStream input = null;
		FileOutputStream output = null;
		
		try {
			input = new FileInputStream("./src/test/resources/properties/testdata.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser = properties.getProperty("browser");
		System.out.println(browser);
		
		String url = properties.getProperty("url");
		System.out.println(url);
		
		try {
			output = new FileOutputStream("./src/test/resources/properties/testdata.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		properties.setProperty("testdata", "6464643");
		try {
			properties.store(output, "This is customer data from TC2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
