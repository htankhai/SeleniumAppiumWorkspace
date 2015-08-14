package json_Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsontoObject_fromJson {
	public static void main(String[] args) {
		Gson gson = new Gson();

		try {

			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\htan\\Workspace_Selenium_TextFiles\\ObjecttoGsonFile.json"));

			//convert the json string back to object
			DataObject obj = gson.fromJson(br, DataObject.class);

			System.out.println(obj);
			
			
			//Enable pretty print
			System.out.println("Enable pretty print in Json");
			DataObject obj2 = new DataObject();
		    // Gson gson = new Gson();
		 
		    Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		 
		    String json = gson2.toJson(obj2);
		 
		    System.out.println(json);
		    

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
