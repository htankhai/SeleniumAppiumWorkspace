package json.Simple;/* write JSON data via JSONObject and JSONArray, and save it into a file named “JsonFile.json“.

 */
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class WriteJsonFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		obj.put("name", "Htan.com");
		obj.put("age", new Integer(100));

		JSONArray list = new JSONArray();
		list.add("msg 1");
		list.add("msg 2");
		list.add("msg 3");
		
		list.add("msg 100");
		
		list.add("msg 200");
		
		list.add("msg 300");


		obj.put("messages", list);

		try {
			FileWriter file = new FileWriter("C:\\Users\\htan\\Workspace_Selenium_TextFiles\\JsonFile.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);
	}

}
