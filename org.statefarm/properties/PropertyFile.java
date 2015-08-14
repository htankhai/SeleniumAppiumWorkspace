//Create Properties file of Statefarm//Draft

/*import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;*/

public class PropertyFile {

	@Test
	public void CreateProperties() throws IOException {
		Properties prop = new Properties();
		OutputStream output = null;
		//InputStream input = null;

		// create extension properties file
		output = new FileOutputStream("C:/Htan/Statefarm/build.properties");

		prop.setProperty("userNameXpath", "//*[id = 'input']");
		prop.setProperty("userName", "uName");
		prop.setProperty("city", "Fremont");
		prop.setProperty("name", "Htan");

		prop.store(output, "Statefarm Properties file..");

		//prop.store(output,null);

		//Read properties file
		/*input = new FileInputStream(""C:/Htan/Statefarm/build.properties");
		prop.load(input);
		String nameXpath = prop.getProperty("name");
		System.out.println(nameXpath );
		
		String unXpath = prop.getProperty("userName");
		System.out.println(unXpath );
		
		String pwdXpath = prop.getProperty("pwd");
		System.out.println(pwdXpath );
		
		System.out.println(prop.getProperty("userNameXpath"));
		System.out.println(prop.getProperty("city"));
		*/


	}

}
