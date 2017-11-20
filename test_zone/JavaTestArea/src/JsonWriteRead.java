

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;



public class JsonWriteRead 
{

	private String fileName = ".\\config.json";
	
	
	
	private static Staff  jsonConfig() 
	{
		Staff staff = new Staff();  //object to class (Staff.java)
		
		staff.setName("miko");
		staff.setAge(46);
		staff.setSalary(new BigDecimal(7777));
		
		
//   	    List<String> skills = new ArrayList<String>();
//   	    skills.add("dance");
//   	    skills.add("sing");
//   	    skills.add("move");
//   	    
//   	    staff.setSkills(skills);
   	    
		
		return staff; //returb object
	}
	
	
	
	public boolean WriteToFile() 
	{
		
		Staff staff = jsonConfig();


		
//		//gson object
		Gson gs = new Gson();
		
		
//		//print the json (json to string)	
		String json = gs.toJson(staff);
		System.out.println(json);
		
		
//		//Convert object to JSON string and save into a file directly
		try {
			FileWriter write2file = new FileWriter(fileName);
			
			gs.toJson(staff, write2file);
			
			write2file.flush(); //flush memory
			write2file.close(); //close file.
			
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	
	
	
	public boolean ReadFromFile() 
	{
		FileReader read4file;
		try {
			read4file = new FileReader(fileName);
			
			
//			//gson object
			Gson gs = new Gson();

			//convert json to Java Object
			Staff staff = gs.fromJson(read4file, Staff.class);

			
			
//			//print the json (json to string)	
			String json = gs.toJson(staff);
			System.out.println(json);
			
//			//print object staff 
			System.out.println(staff.getName());
			
			return true;
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		

	}
	
	
	
	
	
/// MainIt() -- constructor ///
	public JsonWriteRead() 
	{
		
		//Write JSON
		boolean blWriteResult = WriteToFile();
		if (blWriteResult == false)
			System.out.println("[NOT-OK]--> reading file");
		else
			System.out.println("[OK]--> reading file");

		
		
		//Read Json
		boolean blReadResult = ReadFromFile();
		if (blReadResult == false)
			System.out.println("[NOT-OK]--> reading file");
		else
			System.out.println("[OK]--> reading file");
				
	}
	
	
	
	public static void main(String[] args) 
	{ 
		JsonWriteRead mi = new JsonWriteRead();
	}

}
