package testArea001;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

//import org.json.JSONException;
//import org.json.JSONObject;





public class JsonReadWrite 
{
	
	private String sourceFileName = ".\\config\\test.json";
	
	private void JsonWrite() throws JSONException
	{

		String age = "age";
		int ageValue = 22;
		String FName = "FName";
		String FNameValue = "eli2";
		String LName = "LName";
		String LNameValue = "lee2";

		//String sourceFileName = ".\\config\\test.json";
				
		JSONObject jsonObj = new JSONObject();
		
		
		jsonObj.put(age, new Integer(22));
		jsonObj.put(FName,FNameValue);
		jsonObj.put(LName,LNameValue);
		
//		FileWriter file = new FileWriter(sourceFileName);

//	    file.write(jsonObj.toString());
//	    file.flush();

        try (FileWriter file = new FileWriter(this.sourceFileName)) {

            file.write(jsonObj.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

	    System.out.print(jsonObj);
	}

	private void JsonWrite2() throws JSONException
	{

		String age = "age";
		int ageValue = 22;
		String FName = "FName";
		String FNameValue = "eli2";
		String LName = "LName";
		String LNameValue = "lee2";


        
		
				
		JSONObject jsonObj = new JSONObject();
		
		
		jsonObj.put(age, new Long(22));
		jsonObj.put(FName,FNameValue);
		jsonObj.put(LName,LNameValue);

		jsonObj.put(age, ageValue);
		jsonObj.put(FName,FNameValue);
		jsonObj.put(LName,LNameValue);
	
		
	    JSONArray list = new JSONArray();
	    
        list.put("msg_ 1");
        list.put("msg_2");
        list.put("msg_3");
        
        jsonObj.put("messages", list.toString());
		
//		FileWriter file = new FileWriter(sourceFileName);

//	    file.write(jsonObj.toString());
//	    file.flush();

        try (FileWriter file = new FileWriter(this.sourceFileName)) {

            file.write(jsonObj.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

	    System.out.print(jsonObj);		
	}

	
	private void JsonRead() throws JSONException
	{
		try 
		{ 
			FileReader file = new FileReader(this.sourceFileName);
		
			JSONObject jsObj = new JSONObject();
			System.out.println("\n json object =\n" + jsObj);
			
//			long readAge = (long) jsObj.get("age");
//			System.out.println(readAge);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();     
		}		
	}
	
	
	public JsonReadWrite() { } //constructor

	
	public static void main(String[] args) throws JSONException 
	{
		JsonReadWrite jrw = new JsonReadWrite();
		jrw.JsonWrite();
//		jrw.JsonWrite2();
		
		//here
		//////jrw.JsonRead();
			
	}
}
