package testArea001;

import java.io.FileWriter;

import org.json.JSONException;
import org.json.JSONObject;





public class JsonReadWrite {
	
	private void JsonRead()
	{

		String age = "age";
		int ageValue = 22;
		String FName = "FName";
		String FNameValue = "eli";
		String LName = "LName";
		String LNameValue = "lee";

		String sourceFileName = ".\\test.json";
				
		JSONObject jsonObj = new JSONObject();
		
		
		try {
			jsonObj.put(age, new Integer(22));
			jsonObj.put(FName,FNameValue);
			jsonObj.put(LName,LNameValue);
			
			FileWriter file = new FileWriter(sourceFileName);

		    file.write(jsonObj.toString());
		    file.flush();

    	    System.out.print(obj);
						
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	public JsonReadWrite() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	

}
